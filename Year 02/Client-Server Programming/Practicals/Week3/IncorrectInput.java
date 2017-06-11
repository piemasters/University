package year2.CSP.Week3;

import java.util.*;
import java.math.*;

public class IncorrectInput {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Integer input = null;
        do {
            try {
                System.out.print("Please enter an Integer: ");
                input = scan.nextInt();
                double output = Math.sqrt(input);
                System.out.println("The Square Root is: " + output);
            } catch (InputMismatchException a) {
                System.out.println("You need to enter an integer.");
            }
        } while (input == null);
    }
}
