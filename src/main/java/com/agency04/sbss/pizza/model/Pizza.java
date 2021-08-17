package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizza")
    private List <PizzaOrder> pizzaOrders;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizza")
    private List<PizzaIngredient> pizzaIngredients;

    public Pizza(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PizzaIngredient> getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void setPizzaIngredients(List<PizzaIngredient> pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(getId(), pizza.getId()) &&
                Objects.equals(getName(), pizza.getName()) &&
                Objects.equals(pizzaOrders, pizza.pizzaOrders) &&
                Objects.equals(getPizzaIngredients(), pizza.getPizzaIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), pizzaOrders, getPizzaIngredients());
    }
}
