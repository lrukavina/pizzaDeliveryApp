package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.converter.DeliveryToCustomerConverter;
import com.agency04.sbss.pizza.converter.DeliveryToPizzaOrderConverter;
import com.agency04.sbss.pizza.dto.CustomerDTO;
import com.agency04.sbss.pizza.dto.DeliveryDTO;
import com.agency04.sbss.pizza.dto.PizzaOrderDTO;
import com.agency04.sbss.pizza.enumeration.PizzaSize;
import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final CustomerService customerService;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, CustomerService customerService) {
        this.deliveryRepository = deliveryRepository;
        this.customerService = customerService;
    }


    @Override
    public Optional<List<DeliveryDTO>> getOrders() {
        return Optional.of(deliveryRepository.findAll().stream().map(this::mapDeliveryToDTO)
                .collect(Collectors.toList()));
    }

  @Override
    public Optional<DeliveryDTO> order(DeliveryForm deliveryForm) {

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

        deliveryRepository.save(delivery);
        return Optional.of(mapDeliveryToDTO(delivery));
    }

    private DeliveryDTO mapDeliveryToDTO(Delivery delivery){

        String username = delivery.getCustomer().getUsername();
        String firstName = delivery.getCustomer().getCustomerDetails().getFirstName();
        String lastName = delivery.getCustomer().getCustomerDetails().getLastName();
        String phone = delivery.getCustomer().getCustomerDetails().getPhone();

        CustomerDTO customerDTO = new CustomerDTO(username, firstName, lastName, phone);

        List<PizzaOrderDTO> pizzaOrderDTOS = new ArrayList<>();

        for (PizzaOrder pizzaOrder: delivery.getPizzaOrders()){
            String pizzaName = pizzaOrder.getPizza().getName();
            String quantity = pizzaOrder.getQuantity();
            PizzaSize pizzaSize = pizzaOrder.getSize();

            PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO(pizzaName, quantity, pizzaSize);
            pizzaOrderDTOS.add(pizzaOrderDTO);
        }

        return new DeliveryDTO(customerDTO, pizzaOrderDTOS);
    }

}
