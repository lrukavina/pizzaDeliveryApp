package com.agency04.sbss.pizza.model;

import java.time.LocalDate;
import java.util.List;

public class DeliveryForm {

    String customerUsername;
    LocalDate submissionDate;
    List<PizzaOrderForm> pizzaOrderForms;

    public DeliveryForm(String customerUsername, List<PizzaOrderForm> pizzaOrderForms) {
        this.customerUsername = customerUsername;
        this.submissionDate = LocalDate.now();
        this.pizzaOrderForms = pizzaOrderForms;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public List<PizzaOrderForm> getPizzaOrderForms() {
        return pizzaOrderForms;
    }

    public void setPizzaOrderForms(List<PizzaOrderForm> pizzaOrderForms) {
        this.pizzaOrderForms = pizzaOrderForms;
    }
}
