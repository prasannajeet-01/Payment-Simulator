package com.beehyv.paymentgateway.payment.controller;

import com.beehyv.paymentgateway.payment.dto.MerchantDTO;
import com.beehyv.paymentgateway.payment.exception.MerchantExistException;
import com.beehyv.paymentgateway.payment.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/simulator")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("/create")
    ResponseEntity<MerchantDTO> registerMerchant(@RequestBody MerchantDTO merchant) throws MerchantExistException {
        return merchantService.registerAMerchant(merchant);

    }
}
