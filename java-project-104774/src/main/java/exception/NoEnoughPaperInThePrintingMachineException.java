package exception;

public class NoEnoughPaperInThePrintingMachineException extends Exception {
    private int neededPages;
    private int availablePages;

    public NoEnoughPaperInThePrintingMachineException(int neededPages, int availablePages) {
        this.neededPages = neededPages;
        this.availablePages = availablePages;
    }

    @Override
    public String toString() {
        return "NoEnoughPaperInThePrintingMachineException{" +
                "neededPages=" + neededPages +
                ", availablePages=" + availablePages +
                "} " + super.toString();
    }
}
