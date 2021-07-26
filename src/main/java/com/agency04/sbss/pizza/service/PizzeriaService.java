package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.Pizza;


public interface PizzeriaService {

    String getName();
    String getAddress();
    Pizza makePizza(Pizza pizza);
}
