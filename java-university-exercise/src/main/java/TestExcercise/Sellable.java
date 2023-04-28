package TestExcercise;

import TestExcercise.Exception.NegativeOverchargePercentageException;

public interface Sellable {
    double sellingPrice(int overchargePercentage) throws NegativeOverchargePercentageException;
}
