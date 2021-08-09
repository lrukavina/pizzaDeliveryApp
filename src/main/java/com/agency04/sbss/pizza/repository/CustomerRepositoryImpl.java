package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.exception.CustomerExistsException;
import com.agency04.sbss.pizza.exception.CustomerNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private List<Customer> customers = new ArrayList<>(Arrays.asList(

            new Customer("lrukavina", "Luka", "Rukavina"),
            new Customer("vm912", "Vitomir", "Marjanović")

    ));

    @Override
    public Optional<Customer> findCustomerByUsername(String username) {
        Optional<Customer> optionalCustomer = customers.stream()
                .filter(it -> Objects.equals(it.getUsername(), username)).findAny();

        if (optionalCustomer.isPresent()){
            return optionalCustomer;
        }
        else {
            throw new CustomerNotFoundException("Customer with username: \""+ username +"\" does not exist!");
        }
    }

    private Optional<Customer> checkIfCustomerExists(String username){
        Optional<Customer> optionalCustomer = customers.stream()
                .filter(it -> Objects.equals(it.getUsername(), username)).findAny();

        return optionalCustomer;
    }

    @Override
    public Optional<Customer> saveCustomer(Customer customer) {
        Optional<Customer> checkedCustomer = checkIfCustomerExists(customer.getUsername());

        if(checkedCustomer.isEmpty()){
            customers.add(customer);
            return Optional.of(customer);
        }
        else {
            throw new CustomerExistsException("Customer with username: \""+ customer.getUsername()+"\" already exists!");
        }
    }

    @Override
    public Optional<Customer> updateCustomer(Customer updatedCustomer) {
        Optional<Customer> checkedCustomer = checkIfCustomerExists(updatedCustomer.getUsername());

        if (checkedCustomer.isPresent()) {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getUsername().equals(updatedCustomer.getUsername()))
                    customers.set(i, updatedCustomer);
            }
            return Optional.of(updatedCustomer);
        }
        else {
            throw new CustomerNotFoundException("Customer with username: \""+ updatedCustomer.getUsername()+"\" does not " +
                    "exist.");
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        if (!customers.removeIf(customers -> customers.equals(customer))) {
            throw new CustomerNotFoundException("Customer with username: \""+ customer.getUsername()+"\" does not " +
                    "exist.");
        }
    }


}
