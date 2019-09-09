package com.dskarataev.dskmoney.account.exception;

public class InvalidCurrencyException extends Exception {

    public InvalidCurrencyException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
