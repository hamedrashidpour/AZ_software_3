import calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your inputs (sample: integer integer ( ^ or * or /))");
        System.out.println("enter exit to end");
        Calculator calculator = new Calculator();
        while (true){
            String input = scanner.nextLine();
            if (input.matches("exit"))
                break;
            try {
                System.out.println(calculator.calculate(Integer.parseInt(input.split(" ")[0]) , Integer.parseInt(input.split(" ")[1]), input.split(" ")[2]));
            }
            catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }

    }
}