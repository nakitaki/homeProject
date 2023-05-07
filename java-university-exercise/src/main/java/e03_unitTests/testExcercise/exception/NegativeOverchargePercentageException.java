package e03_unitTests.testExcercise.exception;

public class NegativeOverchargePercentageException extends Exception {
    private int overchargePercentage;

    public NegativeOverchargePercentageException(int overchargePercentage) {
        this.overchargePercentage = overchargePercentage;
    }

    @Override
    public String toString() {
        return "NegativeOverchargePercentageException{" +
                "oOverchargePercentage=" + overchargePercentage +
                "} ";
    }
}
