import exceptions.NegativeOverchargePercentageException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item item;

    @BeforeEach
    void init(){
        item = new Item(1,"book", 10);
    }

    @Test
    void testSellingPricePositivePercentage() throws NegativeOverchargePercentageException {
        assertEquals(11, item.sellingPrice(10));
    }

    @Test
    void testSellingPriceNegativePercentage(){
        assertThrows(NegativeOverchargePercentageException.class,
                () -> item.sellingPrice(-1));
    }


}