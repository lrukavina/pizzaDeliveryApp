package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.dto.DeliveryDTO;
import com.agency04.sbss.pizza.model.DeliveryForm;
import com.agency04.sbss.pizza.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    @PostMapping("/order")
    public ResponseEntity<DeliveryDTO> orderPizza(@RequestBody final DeliveryForm deliveryForm){
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
    public Optional<List<DeliveryDTO>> getOrders(){
        return deliveryService.getOrders();
    }

}
