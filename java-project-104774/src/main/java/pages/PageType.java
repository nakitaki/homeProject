package pages;

import java.math.BigDecimal;

public enum PageType {
    PLAIN_PAPER(BigDecimal.valueOf(0.5)),
    GLOSSY_PAPER(BigDecimal.valueOf(1)),
    NEWSPAPER_PAPER(BigDecimal.valueOf(0.8));

    private BigDecimal priceForSheetType;

    PageType(BigDecimal priceForSheetType) {
        this.priceForSheetType = priceForSheetType;
    }

    public BigDecimal getPriceForSheetType() {
        return priceForSheetType;
    }

    public void setPriceForSheetType(BigDecimal priceForSheetType) {
        this.priceForSheetType = priceForSheetType;
    }

    @Override
    public String toString() {
        return "PageType{" +
                "priceForSheetType=" + priceForSheetType +
                '}';
    }
}
