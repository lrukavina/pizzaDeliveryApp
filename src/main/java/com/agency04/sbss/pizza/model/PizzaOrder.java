package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.enumeration.PizzaSize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {

    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private String quantity;

    @Enumerated(EnumType.STRING)
    private PizzaSize size;

    public PizzaOrder(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PizzaOrder)) return false;
        PizzaOrder that = (PizzaOrder) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPizza(), that.getPizza()) &&
                Objects.equals(delivery, that.delivery) &&
                Objects.equals(getQuantity(), that.getQuantity()) &&
                getSize() == that.getSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPizza(), delivery, getQuantity(), getSize());
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "id=" + id +
                ", pizza=" + pizza +
                ", delivery=" + delivery +
                ", quantity='" + quantity + '\'' +
                ", size=" + size +
                '}';
    }
}
