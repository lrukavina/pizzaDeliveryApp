package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Calzone;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;

public class DominosPizzeria implements PizzeriaService {

    private String name;
    private String address;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Calzone makePizza(Calzone calzone) {
        return calzone;
    }

    @Override
    public Margherita makePizza(Margherita margherita) {
        return margherita;
    }

    @Override
    public Marinara makePizza(Marinara marinara) {
        return marinara;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getAddress();
    }
}
