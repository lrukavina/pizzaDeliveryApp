package com.agency04.sbss.pizza.converter;

import com.agency04.sbss.pizza.model.PizzaInterface;
import com.agency04.sbss.pizza.enumeration.PizzaIngredientEnum;
import com.agency04.sbss.pizza.enumeration.PizzaSize;
import com.agency04.sbss.pizza.exception.PizzaNotOnMenuException;
import com.agency04.sbss.pizza.exception.PizzaQuantityException;
import com.agency04.sbss.pizza.exception.PizzaSizeException;
import com.agency04.sbss.pizza.model.*;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class DeliveryToPizzaOrderConverter implements Converter<DeliveryForm, List<PizzaOrder>> {

    @Override
    public List<PizzaOrder> convert(DeliveryForm source) {

        List<PizzaOrder> pizzaOrders = new ArrayList<>();

        for (PizzaOrderForm pizzaOrderForm: source.getPizzaOrderForms()){

            PizzaOrder pizzaOrder = new PizzaOrder();

            Pizza pizza = new Pizza();
            switch (pizzaOrderForm.getPizzaName()){
                case "Calzone": pizza = mapToPizza("Calzone", new Calzone()); break;
                case "Margherita": pizza = mapToPizza("Margherita", new Margherita()); break;
                case "Marinara": pizza = mapToPizza("Marinara", new Marinara()); break;
                default:
                    throw new PizzaNotOnMenuException(pizzaOrderForm.getPizzaName() + " pizza is not on the menu");
            }

            Integer numberOfPizzas = pizzaOrderForm.getQuantity();
            if(numberOfPizzas < 0 ){
                throw new PizzaQuantityException("Number of ordered pizzas cannot be "+ numberOfPizzas +"." +
                        " It must be a positive number");
            }

            switch (pizzaOrderForm.getPizzaSize()){
                case SMALL: pizzaOrder.setSize(PizzaSize.SMALL); break;
                case MEDIUM: pizzaOrder.setSize(PizzaSize.MEDIUM); break;
                case LARGE: pizzaOrder.setSize(PizzaSize.LARGE); break;
                default:
                    throw new PizzaSizeException(pizzaOrderForm.getPizzaSize() + " is not available pizza size. " +
                            "Sizes are: SMALL, MEDIUM or LARGE");
            }

            pizzaOrder.setPizza(pizza);
            pizzaOrder.setQuantity(numberOfPizzas.toString());

            pizzaOrders.add(pizzaOrder);
        }

        return pizzaOrders;
    }

    private Pizza mapToPizza(String pizzaName, PizzaInterface mappedPizza){
        Pizza pizza = new Pizza();
        pizza.setName(pizzaName);

        List<PizzaIngredient> pizzaIngredients = new ArrayList<>();
        for (PizzaIngredientEnum pizzaIngredientEnum: mappedPizza.getIngredients()){
            PizzaIngredient pizzaIngredient = new PizzaIngredient();
            pizzaIngredient.setPizzaIngredientEnum(pizzaIngredientEnum);
            pizzaIngredients.add(pizzaIngredient);
        }

        pizza.setPizzaIngredients(pizzaIngredients);

        return pizza;
    }
}
