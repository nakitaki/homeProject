package exception;

import machines.PrintingMachine;
import printMedia.PrintMedia;

public class NotPossiblePrinting extends Exception {
    private PrintingMachine printingMachine;
    private PrintMedia printMedia;
    public NotPossiblePrinting(PrintingMachine printingMachine, PrintMedia printMedia) {
        this.printingMachine = printingMachine;
        this.printMedia = printMedia;
    }

    public PrintingMachine getPrintingMachine() {
        return printingMachine;
    }

    public PrintMedia getPrintMedia() {
        return printMedia;
    }

    @Override
    public String toString() {
        return "NotPossiblePrinting{" +
                "printingMachine=" + printingMachine +
                ", printMedia=" + printMedia +
                "} " + super.toString();
    }
}
