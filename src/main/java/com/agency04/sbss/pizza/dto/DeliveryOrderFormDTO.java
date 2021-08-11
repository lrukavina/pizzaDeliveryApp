package com.agency04.sbss.pizza.dto;

import com.agency04.sbss.pizza.model.Customer;

import java.util.List;

public class DeliveryOrderFormDTO {

    private Customer customer;
    private List<OrderedPizzaDTO> orderedPizzas;

    public DeliveryOrderFormDTO(Customer customer, List<OrderedPizzaDTO> orderedPizzas) {
        this.customer = customer;
        this.orderedPizzas = orderedPizzas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderedPizzaDTO> getOrderedPizzas() {
        return orderedPizzas;
    }

    public void setOrderedPizzas(List<OrderedPizzaDTO> orderedPizzas) {
        this.orderedPizzas = orderedPizzas;
    }
}
