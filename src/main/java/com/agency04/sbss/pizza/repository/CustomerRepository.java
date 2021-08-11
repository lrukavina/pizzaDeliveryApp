package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findCustomerByUsername(String username);
    Optional<Customer> saveCustomer(Customer customer);
    Optional<Customer> updateCustomer(Customer updatedCustomer);
    void deleteCustomer(Customer customer);
}
