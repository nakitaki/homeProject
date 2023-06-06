package e12_TestPreparation.prep2.service;

import e12_TestPreparation.prep2.models.PizzaType;
import e12_TestPreparation.prep2.models.Restaurant;

import java.util.Map;

public interface RestaurantService {
    int numberOfSoldPizzas(Restaurant restaurant);
    double totalValueOfPizzasSoldByType(Restaurant restaurant, PizzaType pizzaType);
}
