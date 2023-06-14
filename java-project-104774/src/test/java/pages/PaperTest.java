package pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PaperTest {

    Paper paper1;

    @BeforeEach
    void init(){
        paper1 = new Paper(PageSize.A1, PageType.PLAIN_PAPER);
    }

    //TODO bez getter
    @Test
    void pricePerSheet() throws NoSuchFieldException, IllegalAccessException {
        BigDecimal expected = BigDecimal.valueOf(2.5);
        BigDecimal actual = paper1.pricePerSheet();

        assertEquals(expected, actual);
    }


}