package com.af.api.expose.exception;

import lombok.Getter;

public class UserNotFoundException extends RuntimeException{
    @Getter
    private ErrorCodes errorCode;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
