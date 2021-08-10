package com.agency04.sbss.pizza.configuration;

import com.agency04.sbss.pizza.converter.DeliveryToCustomerConverter;
import com.agency04.sbss.pizza.converter.DeliveryToOrderedPizzaConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DeliveryToCustomerConverter());
        registry.addConverter(new DeliveryToOrderedPizzaConverter());
    }
}
