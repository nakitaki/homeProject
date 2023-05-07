package e03_unitTests.shapes;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {
    private int side1;
    private int side2;

    public Rectangle(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) throws ArithmeticException {
        if (side2 < 0) {
            throw new ArithmeticException("The side has to be non negative number!");
        }
        this.side2 = side2;
    }

    public int perimeter() {
        return 2 * (side1 + side2);
    }

    public int area() {
        return side1 * side2;
    }

    public List<Integer> increasedSide1() {
        List increasedSide = new ArrayList();
        for (int i = 0; i < 100; i += 10) {
            increasedSide.add(side1 + i);
        }
        return increasedSide;
    }

    public void increaseSides(int increase) throws ArithmeticException {
        if (increase < 0) {
            throw new ArithmeticException("The increase has to be non negative number!");
        }
    }
}
