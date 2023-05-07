package e08_Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("exercise 1");
            List<String> wordsList = new ArrayList<>();
            wordsList.add("swedish");
            wordsList.add("vegans");
            wordsList.add("marching");
            wordsList.add("ashore");

            System.out.println(wordsList.get(0)); //swedish
            wordsList.set(1, "pagans");

            List<String> someWords = wordsList.subList(0, 2);

            System.out.println(wordsList.contains("ashore"));//true

            wordsList.remove(2);
            for (String s : wordsList) { //swedish pagans ashore
                System.out.println(s);
            }
            System.out.println();
        }

        {
            //enter word on new line -> it will print words until .(dot) backwards
            System.out.println("exercise 2");
            List<String> words = new ArrayList<String>();

            Scanner scanner = new Scanner(System.in);

            String word = scanner.nextLine();
            while (!word.equals(".")) {
                words.add(word);
                word = scanner.nextLine();
            }

            for (int i = words.size() - 1; i >= 0; i--) {
                System.out.println(words.get(i));
            }

            System.out.println();
            //            a
            //            b
            //            .
            //            c
            //            prints:
            //            b
            //            a

        }
        {
            //difference between parameter type Integer and type int in List<Integer>.remove()
            System.out.println("exercise 3");
            List<Integer> numbers = new ArrayList<>();
            numbers.add(3);
            numbers.add(2);
            numbers.add(1);
            numbers.add(0);

            int index = 0;
            numbers.remove(index); //remove 3 => numbers[0]

            Integer x = 1;
            numbers.remove(x); //removes 1 => numbers[4]

            for (Integer number : numbers) {
                System.out.print(number + " "); //2 0
            }
            System.out.println();
            System.out.println();
        }
        {
            //remove all repetitions of a word in the List
            System.out.println("exercise 4");
            List<String> words = new ArrayList<>(Arrays.asList("abc", "def", "abc", "abc", "def"));
            removeAll(words, "def");

            for (String word : words) {
                System.out.print(word + " "); // abc abc abc
            }
            System.out.println();
            System.out.println();
        }
        {
            System.out.println("exercise 5");
            Scanner scanner = new Scanner(System.in);
            List<Integer> numbers = nextLineOfInteger(scanner);

            for (int number : numbers) {
                System.out.println(number);
            }
            System.out.println();
        }
        {
            //if two adjacent numbers are equal - sum them; do that until there are no more adjacent equal numbers
            //8 2 2 4 8 16 -> 8 4 4 8 16 -> 8 8 8 16 -> 16 8 16; do it from left to right  => 8 8 8 = 16 8
            System.out.println("exercise 6");
            Scanner scanner = new Scanner(System.in);
            //List<Integer> numbers = nextLineOfInteger(scanner);
            List<Integer> numbers = new ArrayList<>(Arrays.asList(8, 2, 2, 4, 8, 16));

            List<Integer> nextNumbers = sumAdjacentEqualNumbers(numbers);
            while (nextNumbers.size() != numbers.size()) {
                numbers = nextNumbers;
                nextNumbers = sumAdjacentEqualNumbers(numbers);
            }

            for (Integer number : numbers) {
                System.out.println(number + " ");
            }
            System.out.println();
        }
        {
            //merge 2 sorted lists in one (has to be sorted again)
            System.out.println("exercise 7");
            List<Integer> numbersA = new ArrayList<>(Arrays.asList(1, 4, 5, 7, 10));
            List<Integer> numbersB = new ArrayList<>(Arrays.asList(2, 3, 6, 8, 9, 11));

            List<Integer> merged = new ArrayList<>();
            int indexA = 0, indexB = 0;
            while (indexA < numbersA.size() || indexB < numbersB.size()) { //if the first list finishes or element of the first list is bigger then the element of the second one -> the block of code in the else condition will execute;
                if (indexA < numbersA.size() && numbersA.get(indexA) < numbersB.get(indexB)) {
                    merged.add(numbersA.get(indexA));
                    indexA++;

                } else {
                    merged.add(numbersB.get(indexB));
                    indexB++;
                }
            }

            for (Integer number : merged) {
                System.out.print(number + " ");
            }
            System.out.println();

        }
    }

    private static List<Integer> sumAdjacentEqualNumbers(List<Integer> numbers) {
        List<Integer> nextNumbers = new ArrayList<>();
        int i = 0;
        while (i < numbers.size()) {
            if (i < numbers.size() - 1 && numbers.get(i) == numbers.get(i + 1)) {
                nextNumbers.add(numbers.get(i) + numbers.get(i + 1));
                i += 2;
            } else {
                nextNumbers.add(numbers.get(i));
                i++;
            }
        }
        return nextNumbers;
    }

    private static void removeAll(List<String> elements, String value) {
        int i = 0;
        while (i < elements.size()) {
            if (elements.get(i).equals(value)) {
                elements.remove(i);
            } else {
                i++;
            }
        }
    }

    private static List<Integer> nextLineOfInteger(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        String lineOfNumbers = scanner.nextLine();
        String[] numbersAsStrings = lineOfNumbers.split(" ");

        for (String s : numbersAsStrings) {
            numbers.add(Integer.parseInt(s));
        }

        return numbers;
    }
}
