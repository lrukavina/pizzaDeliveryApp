package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        Optional<Customer> customer;

        customer = customerRepository.findCustomerByUsername(username);

        return customer.orElse(null);
    }

    @Override
    public Optional<Customer> saveCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @Override
    public Optional<Customer> updateCustomer(Customer updatedCustomer) {
        return customerRepository.updateCustomer(updatedCustomer);
    }

    @Override
    public void deleteCustomer(String username) {
        Optional<Customer> checkedCustomer = customerRepository.findCustomerByUsername(username);

        checkedCustomer.ifPresent(customerRepository::deleteCustomer);
    }


}
