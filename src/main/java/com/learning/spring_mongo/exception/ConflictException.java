package com.learning.spring_mongo.exception;

public class ConflictException extends GlobalException {
    public ConflictException(String message, String code) {
        super(message, code);
    }
}
