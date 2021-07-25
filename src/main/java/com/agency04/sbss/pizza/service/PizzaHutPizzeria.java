package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Calzone;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PizzaHutPizzeria implements PizzeriaService {

    @Value("${pizzaHutName}")
    private String name;

    @Value("${pizzaHutAddress}")
    private String address;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Qualifier("pizzaHutPizzeria")
    public void setName(String name) {
        this.name = name;
    }

    @Qualifier("pizzaHutPizzeria")
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
