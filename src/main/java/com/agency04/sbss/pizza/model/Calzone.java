package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.Pizza;

public class Calzone implements Pizza {
    @Override
    public String getName() {
        return "Calzone";
    }

    @Override
    public String getIngredients() {
        return "Tomato sauce, mozzarella, ham, mushrooms, artichokes, anchovies, and oregano";
    }
}
