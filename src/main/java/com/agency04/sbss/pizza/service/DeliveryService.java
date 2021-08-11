package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.dto.DeliveryOrderFormDTO;
import com.agency04.sbss.pizza.model.DeliveryOrderForm;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {

    PizzeriaService getCurrentPizzeria();
    List<DeliveryOrderForm> getOrders();
    Optional<DeliveryOrderForm> order(DeliveryOrderFormDTO deliveryOrderFormDTO);
}
