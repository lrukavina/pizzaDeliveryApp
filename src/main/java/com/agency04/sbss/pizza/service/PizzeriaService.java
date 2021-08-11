package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.Pizza;

import java.util.List;


public interface PizzeriaService {

    String getName();
    String getAddress();
    List<Pizza> getPizzas();
}
