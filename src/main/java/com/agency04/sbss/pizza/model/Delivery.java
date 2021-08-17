package com.agency04.sbss.pizza.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "submission_date")
    private LocalDate submissionDate;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<PizzaOrder> pizzaOrders;

    public Delivery(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery)) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(getId(), delivery.getId()) &&
                Objects.equals(getCustomer(), delivery.getCustomer()) &&
                Objects.equals(getSubmissionDate(), delivery.getSubmissionDate()) &&
                Objects.equals(getPizzaOrders(), delivery.getPizzaOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomer(), getSubmissionDate(), getPizzaOrders());
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", customer=" + customer +
                ", submissionDate=" + submissionDate +
                ", pizzaOrders=" + pizzaOrders +
                '}';
    }
}
