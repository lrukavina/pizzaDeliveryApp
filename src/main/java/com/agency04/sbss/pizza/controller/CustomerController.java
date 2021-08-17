package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.dto.CustomerDTO;
import com.agency04.sbss.pizza.model.CustomerForm;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{username}")
    public Optional<CustomerDTO> getCustomerByUsername(@PathVariable final String username){
        return customerService.findCustomerByUsername(username);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody final CustomerForm customerForm){
        return customerService.saveCustomer(customerForm)
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
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody final CustomerForm customerForm){
        return customerService.updateCustomer(customerForm)
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
