package com.agency04.sbss.pizza.converter;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.OrderedPizza;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public class DeliveryToOrderedPizzaConverter implements Converter<DeliveryOrderForm, List<OrderedPizza>> {

    @Override
    public List<OrderedPizza> convert(DeliveryOrderForm source) {
        List<OrderedPizza> orderedPizzas = source.getOrderedPizzas();

        return orderedPizzas;
    }
}
