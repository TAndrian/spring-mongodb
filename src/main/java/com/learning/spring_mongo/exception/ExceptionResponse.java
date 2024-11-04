package com.learning.spring_mongo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse {
    private String code;
    private String message;
    private int statusCode;
}
