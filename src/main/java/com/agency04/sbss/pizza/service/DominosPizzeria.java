package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.PizzaInterface;
import com.agency04.sbss.pizza.model.Calzone;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DominosPizzeria implements PizzeriaService {

    @Value("Domino's")
    private String name;

    @Value("123 Pizza av.")
    private String address;

    private List<PizzaInterface> pizzaInterfaces = initializePizzas();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public List<PizzaInterface> getPizzas() {
        return pizzaInterfaces;
    }

    private List<PizzaInterface> initializePizzas() {

        return new ArrayList<>(Arrays.asList(
                 new Calzone(),
                 new Margherita(),
                 new Marinara()
        ));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return this.getName() + ", " + this.getAddress();
    }
}
