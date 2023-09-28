package com.beehyv.paymentgateway.payment.dto;


import com.beehyv.paymentgateway.payment.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Long id;
    private PaymentStatus status;
    private Long merchantId;
    private Double amount;
    private String currency;
    private String orderId;
    private UUID paymentCode;
}
