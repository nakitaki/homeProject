package printMedia;

import pages.PageSize;
import pages.PageType;
import pages.Paper;

import java.math.BigDecimal;

public class PrintMedia implements Printable{
    private String name;
    private MediaType mediaType;
    private int pagesNumber;
    private Paper paper;
    private boolean isColored;

    public PrintMedia(String name, MediaType mediaType, int pagesNumber, Paper paper, boolean isColored) {
        this.name = name;
        this.mediaType = mediaType;
        this.pagesNumber = pagesNumber;
        this.paper = paper;
        this.isColored = isColored;
    }

    public PrintMedia(String name, MediaType mediaType, int pagesNumber, PageType pageType, PageSize pageSize, boolean isColored) {
        this.name = name;
        this.mediaType = mediaType;
        this.pagesNumber = pagesNumber;
        this.isColored = isColored;
        paper = new Paper(pageSize, pageType);
    }

    public String getName() {
        return name;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public Paper getPaper() {
        return paper;
    }

    public boolean isColored() {
        return isColored;
    }

    //price for one issue -> number of pages multiplied by price for one page
    @Override
    public BigDecimal priceForPrinting() {
        return this.paper.pricePerSheet().multiply(BigDecimal.valueOf(this.pagesNumber));
    }

    @Override
    public String toString() {
        return "PrintMedia{" +
                "name='" + name + '\'' +
                ", mediaType=" + mediaType +
                ", pagesNumber=" + pagesNumber +
                ", paper=" + paper +
                ", isColored=" + isColored +
                '}';
    }
}
