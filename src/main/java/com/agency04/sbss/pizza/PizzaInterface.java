package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.enumeration.PizzaIngredientEnum;

import java.util.Set;

public interface PizzaInterface {

    String getName();
    Set<PizzaIngredientEnum> getIngredients();
}
