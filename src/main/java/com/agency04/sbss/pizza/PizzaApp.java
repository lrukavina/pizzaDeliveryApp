package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        PizzaDeliveryServiceImpl pizzaDelivery = context.getBean("pizzaDeliveryServiceImpl", PizzaDeliveryServiceImpl.class);

        context.close();

    }

}
