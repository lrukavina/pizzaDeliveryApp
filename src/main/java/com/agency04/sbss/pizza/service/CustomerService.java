package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.dto.CustomerDTO;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerForm;

import java.util.Optional;

public interface CustomerService {

    Optional<CustomerDTO> findCustomerByUsername(String username);
    Optional<Customer> findConvertedCustomer(String username);
    Optional<CustomerDTO> saveCustomer(CustomerForm customerForm);
    Optional<CustomerDTO> updateCustomer(CustomerForm updatedCustomerForm);
    void deleteCustomer(String username);
}
