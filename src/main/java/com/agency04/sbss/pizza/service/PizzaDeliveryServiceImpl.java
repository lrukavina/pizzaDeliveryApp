package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Calzone;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {

    private DominosPizzeria dominosPizzeria;
    private PizzaHutPizzeria pizzaHutPizzeria;

    @Autowired
    public PizzaDeliveryServiceImpl(DominosPizzeria dominosPizzeria, PizzaHutPizzeria pizzaHutPizzeria) {
        this.dominosPizzeria = dominosPizzeria;
        this.pizzaHutPizzeria = pizzaHutPizzeria;
    }

    public DominosPizzeria getDominosPizzeria() {
        return dominosPizzeria;
    }

    public PizzaHutPizzeria getPizzaHutPizzeria() {
        return pizzaHutPizzeria;
    }

    @Override
    public String orderPizza(Calzone calzone) {
        return "You've ordered "+calzone.getName()+" pizza with "+calzone.getIngredients();
    }

    @Override
    public String orderPizza(Margherita margherita) {
        return "You've ordered "+margherita.getName()+" pizza with "+margherita.getIngredients();
    }

    @Override
    public String orderPizza(Marinara marinara) {
        return "You've ordered "+marinara.getName()+" pizza with "+marinara.getIngredients();
    }
}
