package com.beehyv.paymentgateway.payment.entity;


import com.beehyv.paymentgateway.payment.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "payment_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PaymentStatus status;

    private Double amount;
    private String currency;
    private String orderId;
    private UUID paymentCode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "merchantId",referencedColumnName = "merchantId")
    private Merchant merchant;
}
