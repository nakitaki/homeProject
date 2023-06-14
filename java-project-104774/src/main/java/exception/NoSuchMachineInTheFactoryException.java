package exception;

import machines.PrintingMachine;

public class NoSuchMachineInTheFactoryException extends Exception{
    private PrintingMachine printingMachine;

    public NoSuchMachineInTheFactoryException(PrintingMachine printingMachine) {
        this.printingMachine = printingMachine;
    }

    @Override
    public String toString() {
        return "NoSuchMachineInTheFactoryException{" +
                "printingMachine=" + printingMachine +
                "} " + super.toString();
    }
}
