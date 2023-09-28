package com.beehyv.paymentgateway.payment.mapper;


import com.beehyv.paymentgateway.payment.dto.MerchantDTO;
import com.beehyv.paymentgateway.payment.dto.PaymentDTO;
import com.beehyv.paymentgateway.payment.entity.Merchant;
import com.beehyv.paymentgateway.payment.entity.Payment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EntityAndDtoMapper {

    EntityAndDtoMapper INSTANCE = Mappers.getMapper(EntityAndDtoMapper.class);


    MerchantDTO merchantTOMerchantDTO(Merchant merchant);

    Merchant merchantDTOTOMerchant(MerchantDTO merchantDTO);

    @Mapping(source = "merchantId", target = "merchant.merchantId")
    Payment paymentDTOToPayment(PaymentDTO paymentDTO);

    @InheritInverseConfiguration
    PaymentDTO paymentToPaymentDTO(Payment payment);


}
