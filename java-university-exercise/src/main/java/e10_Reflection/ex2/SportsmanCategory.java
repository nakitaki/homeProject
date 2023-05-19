package e10_Reflection.ex2;

public enum SportsmanCategory {
    FOOTBALL(10), VOLLEYBALL(12), BASKETBALL(15);

    private double increasePercentage;

    SportsmanCategory(double increasePercentage) {
        this.increasePercentage = increasePercentage;
    }

    public double getIncreasePercentage() {
        return increasePercentage;
    }

    public void setIncreasePercentage(double increasePercentage) {
        this.increasePercentage = increasePercentage;
    }

    @Override
    public String toString() {
        return "SportsmanCategory{" +
                "increasePercentage=" + increasePercentage +
                "} " + super.toString();
    }
}
