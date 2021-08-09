package com.agency04.sbss.pizza.exception;

public class PizzaSizeException extends RuntimeException {

    public PizzaSizeException(String message){
        super(message);
    }

    public PizzaSizeException(Throwable cause){
        super(cause);
    }

    public PizzaSizeException(String message, Throwable cause){
        super(message, cause);
    }
}
