package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.enumeration.PizzaIngredient;

import java.util.List;

public interface Pizza {

    String getName();
    List<PizzaIngredient> getIngredients();
}
