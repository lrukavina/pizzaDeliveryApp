package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.Pizza;
import com.agency04.sbss.pizza.converter.DeliveryToCustomerConverter;
import com.agency04.sbss.pizza.converter.DeliveryToOrderedPizzaConverter;
import com.agency04.sbss.pizza.dto.DeliveryOrderFormDTO;
import com.agency04.sbss.pizza.dto.OrderedPizzaDTO;
import com.agency04.sbss.pizza.enumeration.PizzaSize;
import com.agency04.sbss.pizza.exception.PizzaNotOnMenuException;
import com.agency04.sbss.pizza.exception.PizzaQuantityException;
import com.agency04.sbss.pizza.exception.PizzaSizeException;
import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public PizzeriaService getCurrentPizzeria() {
        return deliveryRepository.getCurrentPizzeria();
    }

    @Override
    public List<DeliveryOrderForm> getOrders() {
        return deliveryRepository.getOrders();
    }

    @Override
    public Optional<DeliveryOrderForm> order(DeliveryOrderFormDTO deliveryOrderFormDTO) {

        DeliveryOrderForm deliveryOrderForm = mapToDeliveryOrderForm(deliveryOrderFormDTO);

        Optional<DeliveryOrderForm> deliveryOrder = deliveryRepository.saveOrder(deliveryOrderForm);

        if(deliveryOrder.isPresent()){
            convertToCustomer(deliveryOrderForm);
            convertToOrderedPizza(deliveryOrderForm);
            return Optional.of(deliveryOrderForm);
        }
        else {
            return Optional.empty();
        }
    }

    private DeliveryOrderForm mapToDeliveryOrderForm(DeliveryOrderFormDTO deliveryOrderFormDTO){

        List<OrderedPizza> orderedPizzas = new ArrayList<>();

        for (OrderedPizzaDTO orderedPizzaDTO: deliveryOrderFormDTO.getOrderedPizzas()){

            Pizza pizza;
            switch (orderedPizzaDTO.getPizzaName()){
                case "Calzone": pizza = new Calzone(); break;
                case "Margherita": pizza = new Margherita(); break;
                case "Marinara": pizza = new Marinara(); break;
                default:
                    throw new PizzaNotOnMenuException(orderedPizzaDTO.getPizzaName() + " pizza is not on the menu");
            }

            switch (orderedPizzaDTO.getPizzaSize()){
                case SMALL: pizza.setSize(PizzaSize.SMALL); break;
                case MEDIUM: pizza.setSize(PizzaSize.MEDIUM); break;
                case LARGE: pizza.setSize(PizzaSize.LARGE); break;
                default:
                    throw new PizzaSizeException(orderedPizzaDTO.getPizzaSize() + " is not available pizza size. " +
                            "Sizes are: SMALL, MEDIUM or LARGE");
            }

            Integer numberOfPizzas = orderedPizzaDTO.getNumberOfPizzas();
            if (numberOfPizzas < 0){
                throw new PizzaQuantityException("Number of ordered pizzas cannot be "+ numberOfPizzas +"." +
                        " It must be a positive number");
            }

            orderedPizzas.add(new OrderedPizza(pizza, numberOfPizzas));
        }

        return new DeliveryOrderForm(deliveryOrderFormDTO.getCustomer(), orderedPizzas);

    }

    private void convertToCustomer(DeliveryOrderForm deliveryOrderForm){

        DeliveryToCustomerConverter customerConverter = new DeliveryToCustomerConverter();
        Customer convertedCustomer = customerConverter.convert(deliveryOrderForm);

        if(convertedCustomer != null){
            System.out.println("\nConverted customer:");
            System.out.println("Username: " + convertedCustomer.getUsername());
            System.out.println("Name: " + convertedCustomer.getName());
            System.out.println("Surname: "+ convertedCustomer.getSurname());
        }
    }

    private void convertToOrderedPizza(DeliveryOrderForm deliveryOrderForm){

        DeliveryToOrderedPizzaConverter pizzaConverter = new DeliveryToOrderedPizzaConverter();
        List<OrderedPizza> convertedOrderedPizzas = pizzaConverter.convert(deliveryOrderForm);

        if(convertedOrderedPizzas != null){
            System.out.println("\nConverted ordered pizzas: ");
            for (OrderedPizza orderedPizza: convertedOrderedPizzas){
                System.out.println("Pizza name: " + orderedPizza.getPizza().getName());
                System.out.println("Pizza size: " + orderedPizza.getPizza().getSizes());
                System.out.println("Pizza ingredients: " + orderedPizza.getPizza().getIngredients());
                System.out.println("Number of pizzas: " + orderedPizza.getNumberOfPizzas());
                System.out.println("------------");
            }
        }
    }
}
