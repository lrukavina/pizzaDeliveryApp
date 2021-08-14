package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.PizzaInterface;
import com.agency04.sbss.pizza.enumeration.PizzaIngredientEnum;

import java.util.HashSet;
import java.util.Set;

public class Marinara implements PizzaInterface {

    @Override
    public String getName() {
        return "Marinara";
    }

    @Override
    public Set<PizzaIngredientEnum> getIngredients() {
        Set<PizzaIngredientEnum> pizzaIngredientEnums = new HashSet<>();

        pizzaIngredientEnums.add(PizzaIngredientEnum.TOMATO_SAUCE);
        pizzaIngredientEnums.add(PizzaIngredientEnum.GARLIC);
        pizzaIngredientEnums.add(PizzaIngredientEnum.BASIL);

        return pizzaIngredientEnums;
    }
}
