package com.beehyv.paymentgateway.payment.dao;

import com.beehyv.paymentgateway.payment.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MerchantRepo extends JpaRepository<Merchant, Long> {
}
