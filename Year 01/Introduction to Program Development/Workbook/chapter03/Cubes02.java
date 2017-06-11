package chapter03;

import java.util.Scanner;

/*******************************************************************************
 * Question  3.2 (page 183)     
 * Write an application that prints the sum of cubes. Prompt for and read two
 * integer values and print the sum of each value raised to the third power.
 ******************************************************************************/
public class Cubes02 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1, num2;

        System.out.print("Enter Number 1: ");
        num1 = scan.nextInt();
        System.out.print("Enter Number 2: ");
        num2 = scan.nextInt();

        num1 = num1 * num1 * num1;
        num2 = num2 * num2 * num2;

        System.out.println("Value of Number 1 Cubed: " + num1);
        System.out.println("Value of Number 2 Cubed: " + num2);
    }
}