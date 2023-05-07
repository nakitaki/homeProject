package e06_SOLID.food;

import java.util.List;

public class Dish implements Deliverable, Eatable{
    private String name;
    private List<Ingredient> ingredientList;
    private double price;

    public double getPrice() {
        return price;
    }
}
