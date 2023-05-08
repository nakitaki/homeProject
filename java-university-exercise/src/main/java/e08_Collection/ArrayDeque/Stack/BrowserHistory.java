package e08_Collection.ArrayDeque.Stack;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    //enter urls; if you write back it will print the previous one, if you write home it will stop the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browseHistory = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentUrl = "";
        while (!input.equals("home")) {
            {
                if (input.equals("back")) {
                    if (browseHistory.size() > 1) {
                        browseHistory.pop();
                        currentUrl = browseHistory.peek();
                        System.out.println(currentUrl);
                    } else {
                        System.out.println("no previous URLs");
                    }
                } else {
                    browseHistory.push(input);
                    currentUrl = browseHistory.peek();
                    System.out.println(currentUrl);
                }
                input = scanner.nextLine();
            }
        }

    }
}
