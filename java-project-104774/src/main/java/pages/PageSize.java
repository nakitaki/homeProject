package pages;

import java.math.BigDecimal;

public enum PageSize {
    A1(BigDecimal.valueOf(5)),
    A2(BigDecimal.valueOf(4)),
    A3(BigDecimal.valueOf(3)),
    A4(BigDecimal.valueOf(2)),
    A5(BigDecimal.valueOf(1));

    private BigDecimal priceForSheetSize;

    PageSize(BigDecimal priceForSheetSize) {
        this.priceForSheetSize = priceForSheetSize;
    }

    public BigDecimal getPriceForSheetSize() {
        return priceForSheetSize;
    }

    public void setPriceForSheetSize(BigDecimal priceForSheetSize) {
        this.priceForSheetSize = priceForSheetSize;
    }

    @Override
    public String toString() {
        return "PageSize{" +
                "priceForSheetSize=" + priceForSheetSize +
                '}';
    }
}
