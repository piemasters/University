package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.10 (page 135)     
 * Write an application that determines the value of the coins in a jar and 
 * prints the total in dollars and cents. Read integer values that represent
 * the number of quarters, dimes, nickels, and pennies.
 ******************************************************************************/
public class Question10 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        int quarters, dimes, nickels, pennies;
        int dollars, cents, total;

        System.out.print("Enter the number of quarters: ");
        quarters = scan.nextInt();
        System.out.print("Enter the number of dimes: ");
        dimes = scan.nextInt();
        System.out.print("Enter the number of nickels: ");
        nickels = scan.nextInt();
        System.out.print("Enter the number of pennies: ");
        pennies = scan.nextInt();
        
        total = quarters * 25 + dimes * 10 + nickels * 5 + pennies;
        
        dollars = total / 100;
        cents = total % 100;
        
        System.out.println("Total value: " + dollars + " dollars and " + 
                cents + " cents. ");
    }
}
