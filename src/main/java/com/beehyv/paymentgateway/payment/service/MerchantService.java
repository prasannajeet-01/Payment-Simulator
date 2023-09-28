package com.beehyv.paymentgateway.payment.service;


import com.beehyv.paymentgateway.payment.dto.MerchantDTO;
import com.beehyv.paymentgateway.payment.exception.MerchantExistException;
import org.springframework.http.ResponseEntity;



public interface MerchantService {
    ResponseEntity<MerchantDTO> registerAMerchant(MerchantDTO merchant) throws MerchantExistException;
}
