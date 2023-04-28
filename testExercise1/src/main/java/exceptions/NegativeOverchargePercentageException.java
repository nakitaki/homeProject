package exceptions;

public class NegativeOverchargePercentageException extends Exception {
    private double overchargePercentage;

    public NegativeOverchargePercentageException(double overchargePercentage) {
        this.overchargePercentage = overchargePercentage;
    }

    @Override
    public String toString() {
        return "NegativeOverchargePercentageException{" +
                "OverchargePercentage=" + overchargePercentage +
                "} ";
    }
}