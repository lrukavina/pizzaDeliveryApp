package com.agency04.sbss.pizza.configuration;

import com.agency04.sbss.pizza.service.PizzaDeliveryServiceImpl;
import com.agency04.sbss.pizza.service.PizzaHutPizzeria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
public class PizzaConfig {

    @Autowired
    ApplicationContext context;

    @Autowired
    public PizzaDeliveryServiceImpl getPizzaDeliveryServiceImplBean() {
        return context.getBean(PizzaDeliveryServiceImpl.class);
    }


    @Bean
    @Primary
    public PizzaHutPizzeria pizzaHutPizzeria(){
        return new PizzaHutPizzeria();
    }
}
