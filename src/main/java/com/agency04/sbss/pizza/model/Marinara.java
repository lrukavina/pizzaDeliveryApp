package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.Pizza;

public class Marinara implements Pizza {
    @Override
    public String getName() {
        return "Marinara";
    }

    @Override
    public String getIngredients() {
        return "Tomato sauce, garlic and basil";
    }
}
