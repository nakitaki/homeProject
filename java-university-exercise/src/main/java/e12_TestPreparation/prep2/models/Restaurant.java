package e12_TestPreparation.prep2.models;

import java.util.*;

public class Restaurant {
    private UUID uuid;
    private String name;
    private Set<Pizza> pizzas;
    private Map<Pizza, Integer> soldPizzas;

    public Restaurant(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        this.pizzas = new HashSet<>();
        this.soldPizzas = new LinkedHashMap<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Set<Pizza> getPizzas() {
        return pizzas;
    }

    public Map<Pizza, Integer> getSoldPizzas() {
        return soldPizzas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }
}
