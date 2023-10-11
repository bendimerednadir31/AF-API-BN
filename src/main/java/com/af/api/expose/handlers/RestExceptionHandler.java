package com.af.api.expose.handlers;

import com.af.api.expose.exception.BadEntityRequestException;
import com.af.api.expose.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(UserNotFoundException exception) {
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(notFound).body(errorDto);
    }

    @ExceptionHandler(BadEntityRequestException.class)
    public ResponseEntity<ErrorDto> handleException(BadEntityRequestException exception) {
        final HttpStatus notFound = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(notFound).body(errorDto);
    }
}