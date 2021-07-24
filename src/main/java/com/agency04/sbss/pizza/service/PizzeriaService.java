package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Calzone;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;

public interface PizzeriaService {

    String getName();
    String getAddress();
    void setName(String name);
    void setAddress(String address);
    Calzone makePizza(Calzone calzone);
    Margherita makePizza(Margherita margherita);
    Marinara makePizza(Marinara marinara);
}
