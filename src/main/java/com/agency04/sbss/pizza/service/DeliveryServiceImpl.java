package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }


    @Override
    public List<Delivery> getOrders() {
        return deliveryRepository.findAll();
    }

  @Override
    public Optional<Delivery> order(Delivery delivery) {
        for(PizzaOrder pizzaOrder: delivery.getPizzaOrders()){
            pizzaOrder.setDelivery(delivery);
        }

        for (int i = 0; i < delivery.getPizzaOrders().size(); i++){
            Pizza pizza = delivery.getPizzaOrders().get(i).getPizza();
            for (PizzaIngredient pizzaIngredient: pizza.getPizzaIngredients()){
                pizzaIngredient.setPizza(pizza);
            }
        }

        return Optional.of(deliveryRepository.save(delivery));

    }

}
