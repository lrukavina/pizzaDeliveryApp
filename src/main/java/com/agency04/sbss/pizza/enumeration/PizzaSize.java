package com.agency04.sbss.pizza.enumeration;

public enum PizzaSize {

    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String description;

    PizzaSize(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
