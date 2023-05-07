package e07_Generics.basicExamples.restaurant;

public class Drink {
    private boolean isSparkling;

    public Drink(boolean isSparkling) {
        this.isSparkling = isSparkling;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "isSparkling=" + isSparkling +
                '}';
    }
}
