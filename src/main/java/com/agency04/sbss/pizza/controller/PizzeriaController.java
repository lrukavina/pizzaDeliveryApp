package com.agency04.sbss.pizza.controller;


import com.agency04.sbss.pizza.Pizza;
import com.agency04.sbss.pizza.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pizzeria/")
public class PizzeriaController {

    private final DeliveryService deliveryService;
    private final PizzeriaService pizzeriaService;

    public PizzeriaController(DeliveryService deliveryService, PizzeriaService pizzeriaService) {
        this.deliveryService = deliveryService;
        this.pizzeriaService = this.deliveryService.getCurrentPizzeria();
    }

    @GetMapping
    public PizzeriaService getPizzaDeliveryService(){
        return deliveryService.getCurrentPizzeria();
    }

    @GetMapping("menu")
    public List<Pizza> getMenu(){
        return pizzeriaService.getPizzas();
    }
}
