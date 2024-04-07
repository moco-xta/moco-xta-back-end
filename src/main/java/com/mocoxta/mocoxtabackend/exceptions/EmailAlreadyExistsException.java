package com.mocoxta.mocoxtabackend.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException() {
    }

    public EmailAlreadyExistsException(String email) {

        super(email);
    }
}