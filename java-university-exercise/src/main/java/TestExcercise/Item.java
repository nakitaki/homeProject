package TestExcercise;

import TestExcercise.Exception.NegativeOverchargePercentageException;
import TestExcercise.Sellable;

public class Item implements Sellable {
    private final long ID;
    private String name;
    private double deliveryPrice;

    public Item(long ID, String name, double deliveryPrice) {
        this.ID = ID;
        this.name = name;
        this.deliveryPrice = deliveryPrice;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public double sellingPrice(int overchargePercentage) throws NegativeOverchargePercentageException {
        if (overchargePercentage < 0){
            throw new NegativeOverchargePercentageException(overchargePercentage);
        }
        else{
            return deliveryPrice*(overchargePercentage/100) + deliveryPrice;
        }
    }
}
