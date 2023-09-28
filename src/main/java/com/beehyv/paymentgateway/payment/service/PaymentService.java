package com.beehyv.paymentgateway.payment.service;

import com.beehyv.paymentgateway.payment.dto.PaymentDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PaymentService {
    ResponseEntity<PaymentDTO> doPayment(PaymentDTO payment);

    ResponseEntity<String> getStatusOfPayment(UUID id);
}
