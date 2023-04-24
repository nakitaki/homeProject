package ex1;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;
    private static double hugeNumber = 100;

    public Triangle() {
    }

    public Triangle(double side) {
        this.side1 = side;
        this.side2 = side;
        this.side3 = side;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public static double getHugeNumber() {
        return hugeNumber;
    }

    public static void setHugeNumber(double hugeNumber) {
        Triangle.hugeNumber = hugeNumber;
    }

    public boolean isTriangle(){
        return (side1 < (side2 + side3)) && (side2 < (side1+side3)) && (side3 < (side1+side2));
    }

    public double perimeter(){
        return side1 + side2 + side3;
    }
    public double area(){
        double p = this.perimeter()/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    public boolean enlargeTheSides(double n){
        if(n>0) {
            this.side1 += n;
            this.side2 += n;
            this.side3 += n;
            return true;
        }
        return false;
    }

    public boolean isEquilateral(){
        return (side1==side2) && (side1==side3);
    }

    public boolean isScalene(){
       return side1*side1==side2*side2+side3*side3 || side2*side2==side1*side1+side3*side3 || side3*side3==side1*side1+side2*side2;
    }

    public boolean HugeNumber(){
        return this.perimeter()>hugeNumber;
    }

    @Override
    public String toString() {
        return "triangle.Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}
