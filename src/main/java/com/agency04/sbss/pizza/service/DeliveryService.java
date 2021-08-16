package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.dto.DeliveryOrderFormDTO;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.DeliveryForm;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {

    //PizzeriaService getCurrentPizzeria();
    List<Delivery> getOrders();
    Optional<Delivery> order(DeliveryForm deliveryForm);
}
