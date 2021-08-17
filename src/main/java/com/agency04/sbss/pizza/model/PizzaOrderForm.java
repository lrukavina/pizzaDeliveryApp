package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.enumeration.PizzaSize;

public class PizzaOrderForm {
    
    private String pizzaName;
    private Integer quantity;
    private PizzaSize pizzaSize;

    public PizzaOrderForm(String pizzaName, Integer quantity, PizzaSize pizzaSize) {
        this.pizzaName = pizzaName;
        this.quantity = quantity;
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
}
