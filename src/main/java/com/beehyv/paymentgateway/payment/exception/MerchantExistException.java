package com.beehyv.paymentgateway.payment.exception;

public class MerchantExistException extends Exception{
    public MerchantExistException(String error){
        super(error);
    }
}
