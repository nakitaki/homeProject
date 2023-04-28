import exceptions.NegativeOverchargePercentageException;

public interface Sellable {
    double sellingPrice(double overchargePercentage) throws NegativeOverchargePercentageException;
}