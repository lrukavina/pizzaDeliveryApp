package com.agency04.sbss.pizza.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message){
        super(message);
    }

    public CustomerNotFoundException(Throwable cause){
        super(cause);
    }

    public CustomerNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
