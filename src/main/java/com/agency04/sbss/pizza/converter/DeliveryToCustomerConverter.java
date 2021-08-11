package com.agency04.sbss.pizza.converter;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import org.springframework.core.convert.converter.Converter;

public class DeliveryToCustomerConverter implements Converter<DeliveryOrderForm, Customer> {

    @Override
    public Customer convert(DeliveryOrderForm source) {

        return new Customer(
                source.getCustomer().getUsername(),
                source.getCustomer().getName(),
                source.getCustomer().getSurname()
        );
    }
}
