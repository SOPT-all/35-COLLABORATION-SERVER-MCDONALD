package com.sopt.mcdonald.global.exception;

import org.springframework.http.HttpStatus;

public class McdonaldException extends RuntimeException {

    private final HttpStatus statusCode;

    public McdonaldException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
