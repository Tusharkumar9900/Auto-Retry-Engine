package com.autoretry.autoretry.exception;

public class RetryableException extends RuntimeException {
    public RetryableException(String message) {
        super(message);
    }
    
}
