package e06_SOLID.food;

public interface Deliverable {
    default boolean delivery(double maxMinutes, double minutes){
        return minutes <= maxMinutes;
    }
}
