package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.enumeration.PizzaIngredientEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ingredient")
public class PizzaIngredient {

    @Id
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private PizzaIngredientEnum pizzaIngredientEnum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    public PizzaIngredient(){}

    public PizzaIngredient(Long id, PizzaIngredientEnum pizzaIngredientEnum, Pizza pizza) {
        this.id = id;
        this.pizzaIngredientEnum = pizzaIngredientEnum;
        this.pizza = pizza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PizzaIngredientEnum getPizzaIngredientEnum() {
        return pizzaIngredientEnum;
    }

    public void setPizzaIngredientEnum(PizzaIngredientEnum pizzaIngredientEnum) {
        this.pizzaIngredientEnum = pizzaIngredientEnum;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaIngredient)) return false;
        PizzaIngredient that = (PizzaIngredient) o;
        return Objects.equals(getId(), that.getId()) &&
                getPizzaIngredientEnum() == that.getPizzaIngredientEnum() &&
                Objects.equals(pizza, that.pizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPizzaIngredientEnum(), pizza);
    }
}
