package com.beehyv.paymentgateway.payment.seviceimpl;

import com.beehyv.paymentgateway.payment.dao.MerchantRepo;
import com.beehyv.paymentgateway.payment.dto.MerchantDTO;
import com.beehyv.paymentgateway.payment.entity.Merchant;
import com.beehyv.paymentgateway.payment.exception.MerchantExistException;
import com.beehyv.paymentgateway.payment.mapper.EntityAndDtoMapper;
import com.beehyv.paymentgateway.payment.service.MerchantService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private EntityAndDtoMapper mapper;
    @Autowired
    private MerchantRepo merchantRepo;

    @Override
    public ResponseEntity<MerchantDTO> registerAMerchant(MerchantDTO merchant) throws MerchantExistException {


        Merchant request = mapper.merchantDTOTOMerchant(merchant);
        Merchant response ;
        try {
            response = merchantRepo.save(request);

        }catch (DataIntegrityViolationException ex){
            throw new MerchantExistException("Error: This merchant already exists.");
        }



        return new ResponseEntity<>(mapper.merchantTOMerchantDTO(response), HttpStatus.OK);
    }
}
