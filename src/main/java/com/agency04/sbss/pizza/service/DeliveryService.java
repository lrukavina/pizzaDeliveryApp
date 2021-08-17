package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.dto.DeliveryDTO;
import com.agency04.sbss.pizza.model.DeliveryForm;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {

    Optional<List<DeliveryDTO>> getOrders();
    Optional<DeliveryDTO> order(DeliveryForm deliveryForm);
}
