package com.agency04.sbss.pizza.dto;

import com.agency04.sbss.pizza.enumeration.PizzaSize;

public class PizzaOrderDTO {

    private String pizzaName;
    private String quantity;
    private PizzaSize pizzaSize;

    public PizzaOrderDTO(String pizzaName, String quantity, PizzaSize pizzaSize) {
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
}
