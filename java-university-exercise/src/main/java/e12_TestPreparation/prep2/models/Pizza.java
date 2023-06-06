package e12_TestPreparation.prep2.models;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

public class Pizza implements Comparable<Pizza> {
    private UUID uuid;
    private String name;
    private PizzaType pizzaType;
    private double productionPrice;
    private double sellingPrice;

    public Pizza(String name, PizzaType pizzaType, double productionPrice, double sellingPrice) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.pizzaType = pizzaType;
        this.productionPrice = productionPrice;
        this.sellingPrice = sellingPrice;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public double getProductionPrice() {
        return productionPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", pizzaType=" + pizzaType +
                ", productionPrice=" + productionPrice +
                ", sellingPrice=" + sellingPrice +
                '}';
    }

    @Override
    public int compareTo(Pizza o) {
        return this.uuid.compareTo(o.uuid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(uuid, pizza.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

}
