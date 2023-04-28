package SOLID.Food;

public interface Deliverable {
    default boolean delivery(double maxMinutes, double minutes){
        return minutes <= maxMinutes;
    }
}
