package com.agency04.sbss.pizza.exception;

public class PizzaNotOnMenuException extends RuntimeException {

    public PizzaNotOnMenuException(String message){
        super(message);
    }

    public PizzaNotOnMenuException(Throwable cause){
        super(cause);
    }

    public PizzaNotOnMenuException(String message, Throwable cause){
        super(message, cause);
    }
}
