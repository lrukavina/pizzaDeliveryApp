package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.Pizza;

public class Margherita implements Pizza {
    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public String getIngredients() {
        return "Tomato sauce, mozzarella, and oregano";
    }
}
