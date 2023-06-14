package machines;

import exception.ExceededPageCountException;
import printMedia.PrintMedia;

public class PrintingMachineServiceImp implements PrintingMachineService{
    public PrintingMachineServiceImp() {
    }

    public void addPages(PrintingMachine printingMachine, int pages) throws ExceededPageCountException {
        if (hasEnoughSpaceForPages(printingMachine, pages)) {
            printingMachine.setAvailablePages(pages);
        } else {
            throw new ExceededPageCountException(printingMachine.getMaxPages());
        }
    }

    public boolean hasEnoughSpaceForPages(PrintingMachine printingMachine, int pages){
        return printingMachine.getMaxPages() >= printingMachine.getAvailablePages() + pages;
    }

    public String print(PrintMedia printMedia, int times) {
        return printMedia.toString() + " -> " + times + " times";
    }

    public boolean hasEnoughPages(PrintingMachine printingMachine, PrintMedia printMedia, int times) {
        return this.totalPages(printMedia, times) <= printingMachine.getAvailablePages();
    }

    public int totalPages(PrintMedia printMedia, int times){
        return times * printMedia.getPagesNumber();
    }

}
