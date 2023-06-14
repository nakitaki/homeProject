package machines;

import exception.ExceededPageCountException;
import printMedia.PrintMedia;

public interface PrintingMachineService {
    void addPages(PrintingMachine printingMachine, int pages) throws ExceededPageCountException;
    boolean hasEnoughSpaceForPages(PrintingMachine printingMachine, int pages);
    String print(PrintMedia printMedia, int times);
    boolean hasEnoughPages(PrintingMachine printingMachine, PrintMedia printMedia, int times);
    int totalPages(PrintMedia printMedia, int times);
}
