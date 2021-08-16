package com.agency04.sbss.pizza.controller;


import com.agency04.sbss.pizza.model.PizzaInterface;
import com.agency04.sbss.pizza.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pizzeria/")
public class PizzeriaController {

    private final DeliveryService deliveryService;
    @Autowired
    private final PizzeriaService pizzeriaService;

    public PizzeriaController(DeliveryService deliveryService, PizzeriaService pizzeriaService) {
        this.deliveryService = deliveryService;
        this.pizzeriaService = pizzeriaService;
    }

    @GetMapping
    public PizzeriaService getPizzaDeliveryService(){
        return pizzeriaService;
    }

    @GetMapping("menu")
    public List<PizzaInterface> getMenu(){
        return pizzeriaService.getPizzas();
    }
}
