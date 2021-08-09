package com.agency04.sbss.pizza.exception;

public class PizzaQuantityException extends RuntimeException {

    public PizzaQuantityException(String message){
        super(message);
    }

    public PizzaQuantityException(Throwable cause){
        super(cause);
    }

    public PizzaQuantityException(String message, Throwable cause){
        super(message, cause);
    }
}
