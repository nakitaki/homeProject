import exceptions.NegativeOverchargePercentageException;

import java.io.Serializable;

public class Item implements Sellable, Serializable {
    private final long inventoryNumber;
    private String name;
    private double deliveryPrice;

    public Item(long inventoryNumber, String name, double deliveryPrice) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.deliveryPrice = deliveryPrice;
    }

    public long getInventoryNumber() {
        return inventoryNumber;
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
    public double sellingPrice(double overchargePercentage) throws NegativeOverchargePercentageException {
        if (overchargePercentage < 0){
            throw new NegativeOverchargePercentageException(overchargePercentage);
        }
        else{
            return deliveryPrice*(overchargePercentage/100) + deliveryPrice;
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "inventoryNumber=" + inventoryNumber +
                ", name='" + name + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                '}';
    }
}