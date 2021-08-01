package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.Pizza;
import com.agency04.sbss.pizza.enumeration.PizzaIngredient;
import com.agency04.sbss.pizza.model.Calzone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {

    @Autowired
    @Qualifier("dominosPizzeria")
    private PizzeriaService pizzeriaService;

    private PizzeriaService initializedPizzeria;

    public PizzeriaService getPizzeriaService() {
        return pizzeriaService;
    }

    public PizzeriaService getInitializedPizzeria() {
        return initializedPizzeria;
    }

    public void setInitializedPizzeria(PizzeriaService initializedPizzeria) {
        this.initializedPizzeria = initializedPizzeria;
    }

    @PostConstruct
    public void initializeData(){
        this.setInitializedPizzeria(pizzeriaService);
        System.out.println("Data has been initialized");
        System.out.println(this.initializedPizzeria.getName() + " " + this.initializedPizzeria.getAddress());
    }

    @PreDestroy
    public void printOrders(){
        System.out.println(this.orderPizza(new Calzone()) +" from "
        + this.getPizzeriaService().getName() +" located on "+this.getPizzeriaService().getAddress());
    }

    @Override
    public String orderPizza(Pizza pizza) {
        return "You've ordered "+pizza.getName()+" pizza with "+getIngredientsDescription(pizza.getIngredients());
    }

    private String getIngredientsDescription(List<PizzaIngredient> pizzaIngredients){
        StringBuilder ingredients = new StringBuilder();

        for(int i = 0; i < pizzaIngredients.size(); i++){

            if(i >= pizzaIngredients.size() -1)
                ingredients.append(" and ");

            ingredients.append(pizzaIngredients.get(i).getDescription());

            if(i < pizzaIngredients.size() - 2){
                ingredients.append(", ");
            }
        }

        return ingredients.toString();
    }
}
