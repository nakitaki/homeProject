package e12_TestPreparation.prep2.service;

import e12_TestPreparation.prep2.models.Pizza;

public interface PizzaService {
    boolean arePizzasSame(Pizza pizza);
    double differenceBetweenProductionAndSellingPrices();
    Pizza pizzaWithBiggerSellingPrice(Pizza pizza);
}
