package com.beehyv.paymentgateway.payment.exception;

import com.beehyv.paymentgateway.payment.response.ErrorResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.NoSuchElementException;


@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception exception, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setCause(String.valueOf(exception.getCause()));
        errorResponse.setStatus((long) HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setPath(webRequest.getDescription(false));
        LOGGER.error("Exception{}", errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException noSuchElementException, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(noSuchElementException.getMessage());
        errorResponse.setCause(String.valueOf(noSuchElementException.getCause()));
        errorResponse.setStatus((long) HttpStatus.NOT_FOUND.value());
        errorResponse.setPath(webRequest.getDescription(false));

        LOGGER.error("NoSuchElementException{}", errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(dataIntegrityViolationException.getMessage());
        errorResponse.setCause(String.valueOf(dataIntegrityViolationException.getCause()));
        errorResponse.setStatus((long) HttpStatus.CONFLICT.value());
        errorResponse.setPath(webRequest.getDescription(false));

        LOGGER.error("DataIntegrityViolationException{}", errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException constraintViolationException, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(constraintViolationException.getMessage());
        errorResponse.setCause(String.valueOf(constraintViolationException.getCause()));
        errorResponse.setStatus((long) HttpStatus.CONFLICT.value());
        errorResponse.setPath(webRequest.getDescription(false));

        LOGGER.error("ConstraintViolationException{}", errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(MerchantExistException.class)
    public ResponseEntity<ErrorResponse> handleMerchantExistException(MerchantExistException merchantExistException, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(merchantExistException.getMessage());
        errorResponse.setCause(String.valueOf(merchantExistException.getCause()));
        errorResponse.setStatus((long) HttpStatus.CONFLICT.value());
        errorResponse.setPath(webRequest.getDescription(false));

        LOGGER.error("MerchantExistException{}", errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }




}



