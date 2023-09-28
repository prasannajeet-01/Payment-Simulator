package com.beehyv.paymentgateway.payment.seviceimpl;


import com.beehyv.paymentgateway.payment.dao.PaymentRepo;
import com.beehyv.paymentgateway.payment.dto.PaymentDTO;
import com.beehyv.paymentgateway.payment.entity.Payment;
import com.beehyv.paymentgateway.payment.enums.PaymentStatus;
import com.beehyv.paymentgateway.payment.mapper.EntityAndDtoMapper;
import com.beehyv.paymentgateway.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private EntityAndDtoMapper mapper;
    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public ResponseEntity<PaymentDTO> doPayment(PaymentDTO payment) {
        Payment request = mapper.paymentDTOToPayment(payment);

        //call here partner bank api's
        //here im generating random number on the basis of number for setting the status

        request.setPaymentCode(UUID.randomUUID()); //setting the transaction id

        Random random = new Random();
        int num = random.nextInt(2);
        if (num == 1) {
            request.setStatus(PaymentStatus.COMPLETED);

        } else {
            request.setStatus(PaymentStatus.FAILED);

        }
        Payment response ;
        try {

            response = paymentRepo.save(request);  // handle exception

        } catch (DataIntegrityViolationException ex) {
            throw new NoSuchElementException("Merchant does not exist,Please register First");

        }

        return new ResponseEntity<>(mapper.paymentToPaymentDTO(response), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getStatusOfPayment(UUID transactionId) {

        Payment response = paymentRepo.findByPaymentCode(transactionId)
                .orElseThrow(() -> new NoSuchElementException("No Transaction exist with given transaction Id " + transactionId));

        return response.getStatus().equals(PaymentStatus.COMPLETED) ?
                new ResponseEntity<>("Transaction successful", HttpStatus.OK) : new ResponseEntity<>("Transaction failed", HttpStatus.OK);
    }
}
