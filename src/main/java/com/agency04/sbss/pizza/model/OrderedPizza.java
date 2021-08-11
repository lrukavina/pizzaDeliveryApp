package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.Pizza;


public class OrderedPizza {
    private Pizza pizza;
    private Integer numberOfPizzas;

    public OrderedPizza(Pizza pizza, Integer numberOfPizzas) {
        this.pizza = pizza;
        this.numberOfPizzas = numberOfPizzas;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Integer getNumberOfPizzas() {
        return numberOfPizzas;
    }

    public void setNumberOfPizzas(Integer numberOfPizzas) {
        this.numberOfPizzas = numberOfPizzas;
    }
}
