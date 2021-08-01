package com.agency04.sbss.pizza.configuration;

import com.agency04.sbss.pizza.service.PizzaHutPizzeria;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.agency04.sbss.pizza")
@PropertySource("classpath:application.properties")
public class PizzaConfig {


    @Bean
    @Primary
    public PizzaHutPizzeria pizzaHutPizzeria(){
        return new PizzaHutPizzeria();
    }
}
