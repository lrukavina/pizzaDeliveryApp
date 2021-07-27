package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.Pizza;
import com.agency04.sbss.pizza.enumeration.PizzaIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {

    @Autowired
    @Qualifier("dominosPizzeria")
    private PizzeriaService pizzeriaService;

    public PizzeriaService getPizzeriaService() {
        return pizzeriaService;
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
