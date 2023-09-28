package com.beehyv.paymentgateway.payment.dao;

import com.beehyv.paymentgateway.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {

    Optional<Payment> findByPaymentCode(UUID transactionUId);
}
