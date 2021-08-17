package com.agency04.sbss.pizza.converter;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.DeliveryForm;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.core.convert.converter.Converter;

public class DeliveryToCustomerConverter implements Converter<DeliveryForm, Customer> {

    private final CustomerService customerService;

    public DeliveryToCustomerConverter(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public Customer convert(DeliveryForm source) {

       return customerService.findConvertedCustomer(source.getCustomerUsername()).get();
    }
}
