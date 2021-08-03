package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DominosPizzeria implements PizzeriaService {

    @Value("Domino's")
    private String name;

    @Value("123 Pizza av.")
    private String address;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Pizza makePizza(Pizza pizza) {
        return pizza;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getAddress();
    }
}
