package machines;

import exception.ExceededPageCountException;
import exception.NoEnoughPaperInThePrintingMachineException;
import printMedia.PrintMedia;
import printMedia.Printable;

public class PrintingMachine {
    private int maxPages;
    private int availablePages;
    private boolean isColored;
    private int pagesPerMinute;

    public PrintingMachine(int maxPages, int availablePages, boolean isColored, int pagesPerMinute) {
        this.maxPages = maxPages;
        this.availablePages = availablePages;
        this.isColored = isColored;
        this.pagesPerMinute = pagesPerMinute;
    }

    public int getMaxPages() {
        return maxPages;
    }

    public int getAvailablePages() {
        return availablePages;
    }

    public boolean isColored() {
        return isColored;
    }

    public int getPagesPerMinute() {
        return pagesPerMinute;
    }

    public void setAvailablePages(int pages) {
        this.availablePages += pages;
    }

    @Override
    public String toString() {
        return "PrintingMachine{" +
                "maxPages=" + maxPages +
                ", availablePages=" + availablePages +
                ", isColored=" + isColored +
                ", pagesPerMinute=" + pagesPerMinute +
                '}';
    }
}
