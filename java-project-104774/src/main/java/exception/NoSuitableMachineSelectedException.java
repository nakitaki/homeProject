package exception;

import machines.PrintingMachine;

public class NoSuitableMachineSelectedException extends Exception {
    private PrintingMachine printingMachine;

    public NoSuitableMachineSelectedException(PrintingMachine printingMachine) {
        this.printingMachine = printingMachine;
    }

    @Override
    public String toString() {
        return "NoSuitableMachineSelectedException{" +
                "printingMachine=" + printingMachine +
                "} " + super.toString();
    }
}
