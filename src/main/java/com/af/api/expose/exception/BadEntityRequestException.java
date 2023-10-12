package com.af.api.expose.exception;

import lombok.Getter;

@Getter
public class BadEntityRequestException extends RuntimeException {

    private final ErrorCodes errorCodes;

    public BadEntityRequestException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }
}
