package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.PizzaInterface;
import com.agency04.sbss.pizza.enumeration.PizzaIngredientEnum;

import java.util.HashSet;
import java.util.Set;

public class Calzone implements PizzaInterface {

    @Override
    public String getName() {
        return "Calzone";
    }


    @Override
    public Set<PizzaIngredientEnum> getIngredients() {
        Set<PizzaIngredientEnum> pizzaIngredientEnums = new HashSet<>();

        pizzaIngredientEnums.add(PizzaIngredientEnum.TOMATO_SAUCE);
        pizzaIngredientEnums.add(PizzaIngredientEnum.MOZZARELLA);
        pizzaIngredientEnums.add(PizzaIngredientEnum.HAM);
        pizzaIngredientEnums.add(PizzaIngredientEnum.MUSHROOMS);
        pizzaIngredientEnums.add(PizzaIngredientEnum.ARTICHOKES);
        pizzaIngredientEnums.add(PizzaIngredientEnum.ANCHOVIES);
        pizzaIngredientEnums.add(PizzaIngredientEnum.OREGANO);

        return pizzaIngredientEnums;

    }
}
