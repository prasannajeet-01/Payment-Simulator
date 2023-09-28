package com.beehyv.paymentgateway.payment.controller;


import com.beehyv.paymentgateway.payment.dto.PaymentDTO;
import com.beehyv.paymentgateway.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/simulator")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    ResponseEntity<PaymentDTO> paymentRequest(@RequestBody PaymentDTO payment)  {
        return paymentService.doPayment(payment);

    }

    @GetMapping("payment_request/{transactionId}")
    ResponseEntity<String>getPaymentStatusByTransactionId(@PathVariable(name = "transactionId") UUID id){
        return paymentService.getStatusOfPayment(id);
    }
}
