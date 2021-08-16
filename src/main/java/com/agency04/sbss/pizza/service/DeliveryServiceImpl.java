package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.converter.DeliveryToCustomerConverter;
import com.agency04.sbss.pizza.converter.DeliveryToPizzaOrderConverter;
import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final CustomerService customerService;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, CustomerService customerService) {
        this.deliveryRepository = deliveryRepository;
        this.customerService = customerService;
    }


    @Override
    public List<Delivery> getOrders() {
        return deliveryRepository.findAll();
    }

  @Override
    public Optional<Delivery> order(DeliveryForm deliveryForm) {

      DeliveryToCustomerConverter deliveryToCustomerConverter = new DeliveryToCustomerConverter(customerService);
      DeliveryToPizzaOrderConverter deliveryToPizzaOrderConverter = new DeliveryToPizzaOrderConverter();

      Customer customer = deliveryToCustomerConverter.convert(deliveryForm);
      List<PizzaOrder> pizzaOrders = deliveryToPizzaOrderConverter.convert(deliveryForm);

      Delivery delivery = new Delivery();
      delivery.setCustomer(customer);
      delivery.setPizzaOrders(pizzaOrders);
      delivery.setSubmissionDate(deliveryForm.getSubmissionDate());

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
