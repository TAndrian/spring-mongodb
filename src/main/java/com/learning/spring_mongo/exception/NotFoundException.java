package com.learning.spring_mongo.exception;

public class NotFoundException extends GlobalException {
    public NotFoundException(String message, String code) {
        super(message, code);
    }
}