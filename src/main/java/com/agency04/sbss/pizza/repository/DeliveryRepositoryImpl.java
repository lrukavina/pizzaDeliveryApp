package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.enumeration.PizzaSize;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class DeliveryRepositoryImpl implements DeliveryRepository {

    @Autowired
    private PizzeriaService pizzeriaService;

    private List<DeliveryOrderForm> orders = new ArrayList<>();

    @Override
    public PizzeriaService getCurrentPizzeria() {
        return pizzeriaService;
    }

    @Override
    public List <DeliveryOrderForm> getOrders() {
        return orders;
    }

   @Override
    public Optional<DeliveryOrderForm> saveOrder(DeliveryOrderForm deliveryOrder) {
        Boolean deliveryExists = false;

        for(DeliveryOrderForm order: orders){
            if (order.equals(deliveryOrder)){
                deliveryExists = true;
            }
        }

        if(!deliveryExists){
            orders.add(deliveryOrder);
            return Optional.of(deliveryOrder);
        }
        else {
            return Optional.empty();
        }
    }


}
