package e03_unitTests.testExcercise.exception;

import e03_unitTests.testExcercise.Item;
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
    void testSellingPriceZeroPercentage(){
        assertThrows(NegativeOverchargePercentageException.class, () -> item.sellingPrice(-3));
    }
}