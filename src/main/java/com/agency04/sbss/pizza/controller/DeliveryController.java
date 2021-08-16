package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.DeliveryForm;
import com.agency04.sbss.pizza.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    @PostMapping("/order")
    public ResponseEntity<Delivery> orderPizza(@RequestBody final DeliveryForm deliveryForm){
        return deliveryService.order(deliveryForm)
                .map(
                        newDelivery -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(newDelivery)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @GetMapping("/list")
    public List<Delivery> getOrders(){
        return deliveryService.getOrders();
    }

}
