package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.configuration.PizzaConfig;
import com.agency04.sbss.pizza.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);
        PizzaDeliveryServiceImpl pizzaDelivery = context.getBean("pizzaDeliveryServiceImpl", PizzaDeliveryServiceImpl.class);

        context.close();

    }

}
