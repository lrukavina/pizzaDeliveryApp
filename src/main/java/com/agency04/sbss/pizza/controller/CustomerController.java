package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.service.CustomerService;
import com.agency04.sbss.pizza.service.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{username}")
    public Customer getCustomerByUsername(@PathVariable final String username){
        return customerService.findCustomerByUsername(username);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody final Customer customer){
        return customerService.saveCustomer(customer)
                .map(
                        newCustomer -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(newCustomer)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody final Customer customer){
        return customerService.updateCustomer(customer)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @DeleteMapping("/{username}")
    public void deleteCustomer(@PathVariable final String username){
        customerService.deleteCustomer(username);
    }

}
