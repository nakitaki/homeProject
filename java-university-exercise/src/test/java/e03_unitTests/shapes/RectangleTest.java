package e03_unitTests.shapes;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private Rectangle rectangle;
    private static Rectangle rectangleStatic;

    @BeforeAll //use with static
    static void initAll() {
        rectangleStatic = new Rectangle(2, 4);
    }

    @BeforeEach
        //before each test
    void init() {
        rectangle = new Rectangle(3, 6);
    }

    @RepeatedTest(3)
    void increasedSide11() {
        List<Integer> expected = Arrays.asList(3, 13, 23, 33, 43, 53, 63, 73, 83, 93);
        List<Integer> actual = rectangle.increasedSide1();
        assertIterableEquals(expected, actual, "The list is not the one expected");
    }

    @Test
    public void testArea() {
        assertEquals(18, rectangle.area());
    }

    @Test
    public void testIncreaseSidesNegativeValue() {
        assertThrows(ArithmeticException.class, () -> rectangle.increaseSides(-1));
    }

    @Nested
    class TestPerimeter {
        @Test
        public void testPerimeterPositiveValues() {
            assertEquals(18, rectangle.perimeter());
        }

        @Test
        public void testPerimeterWithZeroValue() {
            Rectangle rectangle = new Rectangle(0,6);
            assertEquals(12, rectangle.perimeter());
        }
    }
}