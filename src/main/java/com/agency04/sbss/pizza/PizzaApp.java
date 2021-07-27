package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Calzone;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        PizzaDeliveryServiceImpl pizzaDelivery = context.getBean("pizzaDeliveryServiceImpl", PizzaDeliveryServiceImpl.class);


        //printing values from order part 2
        System.out.println(pizzaDelivery.orderPizza(new Margherita()) +" from "
                + pizzaDelivery.getPizzeriaService().getName() +" located on "+pizzaDelivery.getPizzeriaService().getAddress());

        context.close();

    }

}
