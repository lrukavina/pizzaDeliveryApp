package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.PizzeriaService;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository {

    PizzeriaService getCurrentPizzeria();
    List<DeliveryOrderForm> getOrders();
    Optional<DeliveryOrderForm> saveOrder(DeliveryOrderForm deliveryOrder);
}
