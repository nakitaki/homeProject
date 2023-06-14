package pages;

import java.math.BigDecimal;

public class Paper {
    private PageSize pageSize;
    private PageType pageType;

    public Paper(PageSize pageSize, PageType pageType) {
        this.pageSize = pageSize;
        this.pageType = pageType;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public PageType getPageType() {
        return pageType;
    }

    public BigDecimal pricePerSheet(){
        return this.getPageSize().getPriceForSheetSize().multiply(this.getPageType().getPriceForSheetType());
    }

    @Override
    public String toString() {
        return "Paper{" +
                "pageSize=" + pageSize +
                ", pageType=" + pageType +
                '}';
    }
}
