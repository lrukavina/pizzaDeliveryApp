package com.agency04.sbss.pizza.dto;

import java.util.List;

public class DeliveryDTO {

    private CustomerDTO customerDTO;
    private List<PizzaOrderDTO> pizzaOrderDTOS;

    public DeliveryDTO(CustomerDTO customerDTO, List<PizzaOrderDTO> pizzaOrderDTOS) {
        this.customerDTO = customerDTO;
        this.pizzaOrderDTOS = pizzaOrderDTOS;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<PizzaOrderDTO> getPizzaOrderDTOS() {
        return pizzaOrderDTOS;
    }

    public void setPizzaOrderDTOS(List<PizzaOrderDTO> pizzaOrderDTOS) {
        this.pizzaOrderDTOS = pizzaOrderDTOS;
    }
}
