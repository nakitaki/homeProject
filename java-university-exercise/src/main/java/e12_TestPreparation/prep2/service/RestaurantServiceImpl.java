package e12_TestPreparation.prep2.service;

import e12_TestPreparation.prep2.models.PizzaType;
import e12_TestPreparation.prep2.models.Restaurant;

import java.util.Map;

public class RestaurantServiceImpl implements RestaurantService{
    @Override
    public int numberOfSoldPizzas(Restaurant restaurant) {
        return restaurant
                .getSoldPizzas()
                .values()
                .stream()
                .reduce(0, Integer::sum);
    }

    @Override
    public double totalValueOfPizzasSoldByType(Restaurant restaurant, PizzaType pizzaType) {
        return restaurant
                .getSoldPizzas()
                .entrySet()
                .stream()
                .filter(entry-> entry.getKey().getPizzaType().equals(pizzaType))
                .mapToDouble(entry-> entry.getValue() * entry.getKey().getSellingPrice())
                .reduce(0., Double::sum);
    }
}
