package com.agency04.sbss.pizza.dto;

import com.agency04.sbss.pizza.enumeration.PizzaSize;

public class OrderedPizzaDTO {

    private String pizzaName;
    private PizzaSize pizzaSize;
    private Integer numberOfPizzas;

    public OrderedPizzaDTO(String pizzaName, PizzaSize pizzaSize, Integer numberOfPizzas) {
        this.pizzaName = pizzaName;
        this.pizzaSize = pizzaSize;
        this.numberOfPizzas = numberOfPizzas;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public Integer getNumberOfPizzas() {
        return numberOfPizzas;
    }

    public void setNumberOfPizzas(Integer numberOfPizzas) {
        this.numberOfPizzas = numberOfPizzas;
    }
}
