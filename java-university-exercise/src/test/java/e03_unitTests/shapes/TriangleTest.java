package e03_unitTests.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void testPerimeter(){
        Triangle triangle = new Triangle(1,2,3);
        assertEquals(6, triangle.perimeter());
    }

    @Test
    void testPerimeterZeroValue(){
        Triangle triangle = new Triangle(0,0,0);
        assertEquals(0, triangle.perimeter());
    }
}