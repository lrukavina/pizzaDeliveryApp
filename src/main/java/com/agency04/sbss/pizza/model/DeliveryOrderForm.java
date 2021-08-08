package com.agency04.sbss.pizza.model;

import java.time.LocalDateTime;
import java.util.List;

public class DeliveryOrderForm {

    private Customer customer;
    private List<OrderedPizza> orderedPizzas;
    private LocalDateTime dateTimeIssuedOrder;

    public DeliveryOrderForm(Customer customer, List<OrderedPizza> orderedPizzas) {
        this.customer = customer;
        this.orderedPizzas = orderedPizzas;
        this.dateTimeIssuedOrder = LocalDateTime.now();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderedPizza> getOrderedPizzas() {
        return orderedPizzas;
    }

    public void setPizzas(List<OrderedPizza> orderedPizzas) {
        this.orderedPizzas = orderedPizzas;
    }

    public LocalDateTime getDateTimeIssuedOrder() {
        return dateTimeIssuedOrder;
    }

    public void setDateTimeIssuedOrder(LocalDateTime dateTimeIssuedOrder) {
        this.dateTimeIssuedOrder = dateTimeIssuedOrder;
    }
}
