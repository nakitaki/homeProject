package e09_StreamAPI_Lambda.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        IntStream.range(10, 51)
                .filter(a -> a % 3 != 0)
                .forEach(a -> System.out.print(a + " "));

        System.out.println();
        System.out.println();

        IntStream.range(5, 26)
                .filter(number -> number % 5 == 0)
                .forEach(System.out::println);

        System.out.println();

        List<Integer> myListOfNumbers = new ArrayList<>();
        myListOfNumbers.add(9);
        myListOfNumbers.add(16);
        myListOfNumbers.add(25);

        Stream<Double> sqrtRootStrm = myListOfNumbers.stream()
                .map((a) -> Math.sqrt(a)); //for every element of myListOfNumbers we do Math.sqrt

        double productOfSqrtRoots = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);// 1:1; (3*4)*5; reduce from list of elements to one element
        System.out.println("Product of square roots is " + productOfSqrtRoots);
        myListOfNumbers.forEach(System.out::println); //it doesn't change form the stream


    }

}
