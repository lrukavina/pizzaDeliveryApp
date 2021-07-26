package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.Pizza;
import com.agency04.sbss.pizza.enumeration.PizzaIngredient;

import java.util.ArrayList;
import java.util.List;

public class Marinara implements Pizza {
    @Override
    public String getName() {
        return "Marinara";
    }

    @Override
    public List<PizzaIngredient> getIngredients() {
        List<PizzaIngredient> pizzaIngredients = new ArrayList<>();

        pizzaIngredients.add(PizzaIngredient.TOMATO_SAUCE);
        pizzaIngredients.add(PizzaIngredient.GARLIC);
        pizzaIngredients.add(PizzaIngredient.BASIL);

        return pizzaIngredients;
    }
}
