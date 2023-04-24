import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Rhombus rhombus = new Rhombus(n);
        System.out.println(rhombus.getFigure());
    }
}