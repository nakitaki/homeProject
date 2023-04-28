import exceptions.NegativeOverchargePercentageException;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    private double overchargePercentage;
    private List<Sellable> sellables;

    public Pharmacy(double overchargePercentage) {
        this.overchargePercentage = overchargePercentage;
        sellables = new ArrayList<>();
    }

    public boolean addSellable(Sellable sellable){
        if(!sellables.contains(sellable)){
            return sellables.add(sellable);
        }
        else{
            return false;
        }
    }
    public double totalIncome() throws NegativeOverchargePercentageException {
        double sum = 0;
        for(Sellable sellable: this.sellables){
            sum += sellable.sellingPrice(this.overchargePercentage);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "overchargePercentage=" + overchargePercentage +
                ", sellables=" + sellables +
                '}';
    }
}
