package com.agency04.sbss.pizza.enumeration;

public enum PizzaIngredient {

    TOMATO_SAUCE("tomato sauce"),
    MOZZARELLA("mozzarella"),
    OREGANO("oregano"),
    HAM("ham"),
    MUSHROOMS("mushrooms"),
    ARTICHOKES("artichokes"),
    ANCHOVIES("anchovies");


    private final String description;

    PizzaIngredient(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
