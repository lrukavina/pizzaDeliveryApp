package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.configuration.PizzaConfig;
import com.agency04.sbss.pizza.model.Calzone;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        SpringApplication.run(PizzaApp.class, args);
    }

}
