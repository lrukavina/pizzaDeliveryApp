package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer findCustomerByUsername(String username);

    Optional<Customer> saveCustomer(Customer customer);
    Optional<Customer> updateCustomer(Customer updatedCustomer);
    void deleteCustomer(String username);
}
