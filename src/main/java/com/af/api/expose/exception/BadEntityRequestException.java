package com.af.api.expose.exception;

import lombok.Getter;

public class BadEntityRequestException extends RuntimeException{

    @Getter
    private ErrorCodes errorCodes;

    public BadEntityRequestException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }
}
