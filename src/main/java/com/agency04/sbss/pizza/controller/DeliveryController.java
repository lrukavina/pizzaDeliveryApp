package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.dto.DeliveryOrderFormDTO;
import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.DeliveryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/delivery")
public class DeliveryController {

    private final DeliveryServiceImpl deliveryService;

    public DeliveryController(DeliveryServiceImpl deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/order")
    public ResponseEntity<DeliveryOrderForm> orderPizza(@RequestBody final DeliveryOrderFormDTO deliveryOrderFormDTO){
        return deliveryService.order(deliveryOrderFormDTO)
                .map(
                        vaccineDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(vaccineDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @GetMapping("/list")
    public List<DeliveryOrderForm> getOrders(){
        return deliveryService.getOrders();
    }

}
