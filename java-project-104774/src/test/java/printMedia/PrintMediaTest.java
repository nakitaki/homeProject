package printMedia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PageSize;
import pages.PageType;
import pages.Paper;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PrintMediaTest {

    PrintMedia printMedia;
    Paper paper1;

    @BeforeEach
    void init(){
        paper1 = new Paper(PageSize.A1, PageType.PLAIN_PAPER);
        printMedia = new PrintMedia("pm1", MediaType.BOOK, 200, paper1, true);
    }
    @Test
    void priceForPrinting() {
         //(0.5*5)*200 = 500
        BigDecimal expected = BigDecimal.valueOf(500).setScale(1);
        BigDecimal actual = printMedia.priceForPrinting();

        assertEquals(expected, actual);
    }
}