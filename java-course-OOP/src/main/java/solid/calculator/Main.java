package solid.calculator;

import java.util.Scanner;
import java.util.Stack;

//2*4*3/6
//ms - saves the number in memory stack
//mr - gets the number from memory stack
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> memory = new Stack<>();

        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = Extensions.buildInterpreter(engine, memory);
        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            if (token.equals("end")) {
                break;
            }
            interpreter.interpret(token);
        }

        System.out.println(engine.getCurrentResult());
    }
}
