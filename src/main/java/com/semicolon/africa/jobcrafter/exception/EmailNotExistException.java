package com.semicolon.africa.jobcrafter.exception;

public class EmailNotExistException extends RuntimeException {
    public EmailNotExistException(String message) {
        super(message);
    }
}
