package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.PizzaInterface;

import java.util.List;


public interface PizzeriaService {

    String getName();
    String getAddress();
    List<PizzaInterface> getPizzas();
}
