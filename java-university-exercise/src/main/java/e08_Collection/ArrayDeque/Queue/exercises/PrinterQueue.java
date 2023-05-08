package e08_Collection.ArrayDeque.Queue.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    //enter files to print -> cancel command == cancel the first file you entered; print command == print all files left
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> files = new ArrayDeque<>();

        while(!input.equals("print")){
            if(input.equals("cancel")){
                if(files.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    String canceledFile = files.poll();
                    System.out.println("Canceled " + canceledFile);
                }
            } else{
                files.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String file : files) {
            System.out.println(file);
        }
    }
}
