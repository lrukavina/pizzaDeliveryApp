package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.Pizza;
import com.agency04.sbss.pizza.enumeration.PizzaIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {

    private DominosPizzeria dominosPizzeria;
    private PizzaHutPizzeria pizzaHutPizzeria;

    public PizzaDeliveryServiceImpl(DominosPizzeria dominosPizzeria) {
        this.dominosPizzeria = dominosPizzeria;
    }

    public void setPizzaHutPizzeria(PizzaHutPizzeria pizzaHutPizzeria) {
        this.pizzaHutPizzeria = pizzaHutPizzeria;
    }

    public DominosPizzeria getDominosPizzeria() {
        return dominosPizzeria;
    }

    public PizzaHutPizzeria getPizzaHutPizzeria() {
        return pizzaHutPizzeria;
    }

    @Override
    public String orderPizza(Pizza pizza) {
        return "You've ordered "+pizza.getName()+" pizza with "+getIngredientsDescription(pizza.getIngredients());
    }

    private String getIngredientsDescription(List<PizzaIngredient> pizzaIngredients){
        StringBuilder ingredients = new StringBuilder();

        for(int i = 0; i < pizzaIngredients.size(); i++){

            if(i >= pizzaIngredients.size() -1)
                ingredients.append(" and ");

            ingredients.append(pizzaIngredients.get(i).getDescription());

            if(i < pizzaIngredients.size() - 2){
                ingredients.append(", ");
            }
        }

        return ingredients.toString();
    }
}
