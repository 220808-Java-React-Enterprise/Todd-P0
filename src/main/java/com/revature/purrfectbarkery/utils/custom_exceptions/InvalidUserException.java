package com.revature.purrfectbarkery.utils.custom_exceptions;

public class InvalidUserException extends RuntimeException {

    public InvalidUserException(String message) {
        super(message);
    }
}
