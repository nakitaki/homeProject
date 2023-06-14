package ex1;

public class Rectangle {
    private final Point pointA;
    private final Point pointC;

    public Rectangle(Point A, Point C){
        this.pointA = A;
        this.pointC = C;
    }

    public boolean isInside(Point p){
        return p.isGreaterThanOrEqual(pointA) && p.isLessThanOrEqual(pointC);
    }
}
