package e08_Collection.ArrayDeque.Queue.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    //hot potato -> rmeove the person on the last turn(numberOfTurns)
    //Maria Ana John with number of turns 2; first will remove ana, after that Maria and John is the wiinner
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split(" ");
        int numberOfTurns = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (String child : children) {
            childrenQueue.offer(child);
        }

        while (childrenQueue.size() != 1) {
            for (int i = 1; i < numberOfTurns; i++) {
                String currentChild = childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }
            String childRemove = childrenQueue.poll();
            System.out.println("Removed " + childRemove);
        }
        String lastChild = childrenQueue.peek();
        System.out.println("Last is " + lastChild);

    }
}
