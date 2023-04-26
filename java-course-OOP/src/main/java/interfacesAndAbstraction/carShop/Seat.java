package interfacesAndAbstraction.carShop;

public class Seat extends CarImpl implements Sellable{
    private double price;

    public Seat(String model, String color, int horsePower,
                String countryProduced, double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }


    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                this.getModel() + " sells for " + price;
    }
}