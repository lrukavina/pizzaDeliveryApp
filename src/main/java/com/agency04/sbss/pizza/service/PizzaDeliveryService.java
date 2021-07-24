package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Calzone;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;

public interface PizzaDeliveryService {

    String orderPizza(Calzone calzone);
    String orderPizza(Margherita margherita);
    String orderPizza(Marinara marinara);
}
