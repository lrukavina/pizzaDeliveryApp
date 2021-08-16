package com.agency04.sbss.pizza.configuration;

import com.agency04.sbss.pizza.converter.DeliveryToCustomerConverter;
import com.agency04.sbss.pizza.converter.DeliveryToPizzaOrderConverter;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CustomerService customerService;

    public WebConfig(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DeliveryToCustomerConverter(customerService));
        registry.addConverter(new DeliveryToPizzaOrderConverter());
    }
}
