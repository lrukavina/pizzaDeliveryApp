package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.dto.CustomerDTO;
import com.agency04.sbss.pizza.exception.CustomerExistsException;
import com.agency04.sbss.pizza.exception.CustomerNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import com.agency04.sbss.pizza.model.CustomerForm;
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
    public Optional<CustomerDTO> findCustomerByUsername(String username) {
        Optional<Customer> customer;

        customer = Optional.ofNullable(customerRepository.findByUsername(username));

        if(customer.isEmpty()){
            throw new CustomerNotFoundException("Customer with username: \""+ username +"\" does not exist!");
        }
        else {
            return Optional.of(mapCustomerToDTO(customer.get()));
        }
    }

    private Optional<Customer> checkIfCustomerExists(String username){
        Optional<Customer> customer;

        customer = Optional.ofNullable(customerRepository.findByUsername(username));

        return customer;
    }

    @Override
    public Optional<Customer> findConvertedCustomer(String username){
        Optional<Customer> customer;

        customer = Optional.ofNullable(customerRepository.findByUsername(username));

        if(customer.isEmpty()){
            throw new CustomerNotFoundException("Customer with username: \""+ username +"\" does not exist!");
        }
        else {
            return customer;
        }
    }

    @Override
    public Optional<CustomerDTO> saveCustomer(CustomerForm customerForm) {

        Customer customer = mapCustomerFormToEntity(customerForm);
        Optional<Customer> checkedCustomer = checkIfCustomerExists(customer.getUsername());
        if(checkedCustomer.isEmpty()){
            customerRepository.save(customer);
            return Optional.of(mapCustomerToDTO(customer));
        }
        else {
            throw new CustomerExistsException("Customer with username: \""+ customer.getUsername()+"\" already exists!");
        }
    }

    @Override
    public Optional<CustomerDTO> updateCustomer(CustomerForm updatedCustomerForm) {
        Optional<Customer> customer = findConvertedCustomer(updatedCustomerForm.getUsername());
        Customer foundCustomer = new Customer();

        if(customer.isPresent()){
            foundCustomer = customer.get();
        }

        foundCustomer.getCustomerDetails().setFirstName(updatedCustomerForm.getFirstName());
        foundCustomer.getCustomerDetails().setLastName(updatedCustomerForm.getLastName());
        foundCustomer.getCustomerDetails().setPhone(updatedCustomerForm.getPhone());

        customerRepository.save(foundCustomer);
        Customer updatedCustomer = mapCustomerFormToEntity(updatedCustomerForm);
        return Optional.of(mapCustomerToDTO(updatedCustomer));
    }

    @Override
    public void deleteCustomer(String username) {
        Optional<CustomerDTO> customer = findCustomerByUsername(username);
        Customer foundCustomer = new Customer();

        if(customer.isPresent())
            foundCustomer = mapCustomerDTOToEntity(customer.get());

        customerRepository.deleteCustomerByUsername(foundCustomer.getUsername());
    }

    private CustomerDTO mapCustomerToDTO(Customer customer){
        return new CustomerDTO(customer.getUsername(), customer.getCustomerDetails().getFirstName(),
                customer.getCustomerDetails().getLastName(), customer.getCustomerDetails().getPhone());
    }

    private Customer mapCustomerDTOToEntity(CustomerDTO customerDTO){
        return new Customer(customerDTO.getUsername(), new CustomerDetails(customerDTO.getFirstName(),
                customerDTO.getLastName(), customerDTO.getPhone()));
    }

    private Customer mapCustomerFormToEntity(CustomerForm customerForm){
        return new Customer(customerForm.getUsername(), new CustomerDetails(customerForm.getFirstName(),
                customerForm.getLastName(), customerForm.getPhone()));
    }

}
