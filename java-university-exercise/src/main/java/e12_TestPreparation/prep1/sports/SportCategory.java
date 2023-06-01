package e12_TestPreparation.prep1.sports;

public enum SportCategory {
    FOOTBALL(10),
    VOLLEYBALL(12),
    BASKETBALL(15);

    private double increasePercentage;

    SportCategory(double increasePercentage) {
        this.increasePercentage = increasePercentage;
    }

    public double getIncreasePercentage() {
        return increasePercentage;
    }

    public void setIncreasePercentage(double increasePercentage) {
        this.increasePercentage = increasePercentage;
    }
}
