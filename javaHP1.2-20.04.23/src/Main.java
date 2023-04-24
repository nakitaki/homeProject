import ex1.Triangle;

public class Main {
    public static void main(String[] args) {
        System.out.println("exercise 1");
        Triangle triangle1 = new Triangle(1,2,3);
        System.out.println(triangle1.isTriangle()); System.out.println();

        Triangle triangle2 = new Triangle(3,4,5);
        System.out.println(triangle2.isTriangle());
        System.out.println(triangle2.perimeter());
        System.out.println(triangle2.area());
        System.out.println(triangle2.isEquilateral());
        System.out.println(triangle2.isScalene()); System.out.println();

        Triangle triangle3 = new Triangle(2,2,2);
        System.out.println(triangle3.isEquilateral());
        System.out.println(triangle3.perimeter());
        triangle3.enlargeTheSides(1);
        System.out.println(triangle3.perimeter());
        //////////////////////////////////////////////////////


    }
}