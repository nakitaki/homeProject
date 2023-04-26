package interfacesAndAbstraction.carShop;

public class Audi extends CarImpl implements Rentable {
    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, int horsePower,
                String countryProduced, int minRentDay, double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return minRentDay;
    }

    @Override
    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Minimum rental period of " + minRentDay + " days. Price per day"
                + this.pricePerDay;
    }
}

