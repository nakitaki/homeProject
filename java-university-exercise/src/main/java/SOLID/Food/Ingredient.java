package SOLID.Food;

public class Ingredient implements Eatable, Deliverable {
    private String name;
    private boolean isSpicy;
    private FoodCategory foodCategory;

    @Override
    public boolean delivery(double maxMinutes, double minutes) {
        return Deliverable.super.delivery(maxMinutes, minutes);
    }
}
