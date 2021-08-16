package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.exception.CustomerExistsException;
import com.agency04.sbss.pizza.exception.CustomerNotFoundException;
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

        if(customer.isEmpty()){
            throw new CustomerNotFoundException("Customer with username: \""+ username +"\" does not exist!");
        }
        else {
            return customer.get();
        }
    }

    private Optional<Customer> checkIfCustomerExists(String username){
        Optional<Customer> customer;

        customer = Optional.ofNullable(customerRepository.findByUsername(username));

        return customer;
    }

    public Optional<Customer> saveCustomer(Customer customer) {

        Optional<Customer> checkedCustomer = checkIfCustomerExists(customer.getUsername());
        if(checkedCustomer.isEmpty()){
            customerRepository.save(customer);
            return Optional.of(customer);
        }
        else {
            throw new CustomerExistsException("Customer with username: \""+ customer.getUsername()+"\" already exists!");
        }
    }

    @Override
    public Optional<Customer> updateCustomer(Customer updatedCustomer) {
        Customer customer = findCustomerByUsername(updatedCustomer.getUsername());
        customer.getCustomerDetails().setFirstName(updatedCustomer.getCustomerDetails().getFirstName());
        customer.getCustomerDetails().setLastName(updatedCustomer.getCustomerDetails().getLastName());
        customer.getCustomerDetails().setPhone(updatedCustomer.getCustomerDetails().getPhone());

        customerRepository.save(customer);
        return Optional.of(updatedCustomer);
    }

    @Override
    public void deleteCustomer(String username) {
        Customer customer = findCustomerByUsername(username);
        customerRepository.deleteCustomerByUsername(customer.getUsername());
    }

}
