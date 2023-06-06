package e12_TestPreparation.prep2.service;

import e12_TestPreparation.prep2.models.Pizza;

public class PizzaServiceImpl implements PizzaService{
    private Pizza pizza;

    @Override
    public boolean arePizzasSame(Pizza pizza) {
        return this.pizza.getPizzaType().equals(pizza.getPizzaType());
    }

    @Override
    public double differenceBetweenProductionAndSellingPrices() {
        return pizza.getSellingPrice() - pizza.getProductionPrice();
    }

    @Override
    public Pizza pizzaWithBiggerSellingPrice(Pizza pizza) {
        return null;
    }
}
