package e03_unitTests.testExcercise;

import e03_unitTests.testExcercise.exception.NegativeOverchargePercentageException;

public interface Sellable {
    double sellingPrice(int overchargePercentage) throws NegativeOverchargePercentageException;
}
