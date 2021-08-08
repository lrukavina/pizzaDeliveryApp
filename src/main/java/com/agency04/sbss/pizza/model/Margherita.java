package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.Pizza;
import com.agency04.sbss.pizza.enumeration.PizzaIngredient;
import com.agency04.sbss.pizza.enumeration.PizzaSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Margherita implements Pizza {

    private List<PizzaSize> pizzaSizes = new ArrayList<>(Arrays.asList(
            PizzaSize.SMALL,
            PizzaSize.MEDIUM,
            PizzaSize.LARGE
    ));

    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public List<PizzaIngredient> getIngredients() {
        List<PizzaIngredient> pizzaIngredients = new ArrayList<>();

        pizzaIngredients.add(PizzaIngredient.TOMATO_SAUCE);
        pizzaIngredients.add(PizzaIngredient.MOZZARELLA);
        pizzaIngredients.add(PizzaIngredient.OREGANO);

        return pizzaIngredients;
    }

    @Override
    public List<PizzaSize> getSizes() {
        return pizzaSizes;
    }

    @Override
    public void setSize(PizzaSize size) {
        pizzaSizes.clear();
        pizzaSizes.add(size);
    }
}
