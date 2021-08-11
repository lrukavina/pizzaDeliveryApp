package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.enumeration.PizzaIngredient;
import com.agency04.sbss.pizza.enumeration.PizzaSize;

import java.util.List;

public interface Pizza {

    String getName();
    List<PizzaIngredient> getIngredients();
    List<PizzaSize> getSizes();
    void setSize(PizzaSize size);
}
