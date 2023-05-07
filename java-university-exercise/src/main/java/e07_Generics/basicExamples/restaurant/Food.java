package e07_Generics.basicExamples.restaurant;

public class Food {
    private boolean isVegetarian;

    public Food(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    @Override
    public String toString() {
        return "Food{" +
                "isVegetarian=" + isVegetarian +
                '}';
    }
}
