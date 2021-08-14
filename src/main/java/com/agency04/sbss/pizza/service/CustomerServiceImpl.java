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

        customer = Optional.ofNullable(customerRepository.findByUsername(username));

        return customer.orElse(null);
    }

    public Optional<Customer> saveCustomer(Customer customer) {
         customerRepository.save(customer);
         return Optional.of(customer);
    }

    @Override
    public Optional<Customer> updateCustomer(Customer updatedCustomer) {
        Customer customer = customerRepository.findByUsername(updatedCustomer.getUsername());
        customer.getCustomerDetails().setFirstName(updatedCustomer.getCustomerDetails().getFirstName());
        customer.getCustomerDetails().setLastName(updatedCustomer.getCustomerDetails().getLastName());
        customer.getCustomerDetails().setPhone(updatedCustomer.getCustomerDetails().getPhone());

        customerRepository.save(customer);
        return Optional.of(updatedCustomer);
    }

    @Override
    public void deleteCustomer(String username) {
    customerRepository.deleteCustomerByUsername(username);
    }

}
