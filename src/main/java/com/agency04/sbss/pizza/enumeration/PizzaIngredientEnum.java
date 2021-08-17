package com.agency04.sbss.pizza.enumeration;

public enum PizzaIngredientEnum {

    TOMATO_SAUCE("tomato sauce"),
    MOZZARELLA("mozzarella"),
    OREGANO("oregano"),
    HAM("ham"),
    MUSHROOMS("mushrooms"),
    ARTICHOKES("artichokes"),
    ANCHOVIES("anchovies"),
    GARLIC("garlic"),
    BASIL("basil");


    private final String description;

    PizzaIngredientEnum(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
