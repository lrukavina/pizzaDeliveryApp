package com.agency04.sbss.pizza.exception;

public class CustomerExistsException extends RuntimeException {

    public CustomerExistsException(String message){
        super(message);
    }

    public CustomerExistsException(Throwable cause){
        super(cause);
    }

    public CustomerExistsException(String message, Throwable cause){
        super(message, cause);
    }
}
