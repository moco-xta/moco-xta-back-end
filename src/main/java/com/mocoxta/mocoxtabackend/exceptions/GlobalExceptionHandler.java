package com.mocoxta.mocoxtabackend.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value=EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception){
        log.error(HttpStatus.CONFLICT + exception.getMessage());
        System.out.println("--------------------------------> handleEmailAlreadyExistsException");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ErrorResponse(HttpStatus.CONFLICT.value(),
                exception.getMessage()));
    }
}
