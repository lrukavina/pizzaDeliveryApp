package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.enumeration.PizzaIngredientEnum;

import java.util.HashSet;
import java.util.Set;

public class Margherita implements PizzaInterface {

    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public Set<PizzaIngredientEnum> getIngredients() {
        Set<PizzaIngredientEnum> pizzaIngredientEnums = new HashSet<>();

        pizzaIngredientEnums.add(PizzaIngredientEnum.TOMATO_SAUCE);
        pizzaIngredientEnums.add(PizzaIngredientEnum.MOZZARELLA);
        pizzaIngredientEnums.add(PizzaIngredientEnum.OREGANO);

        return pizzaIngredientEnums;
    }
}
