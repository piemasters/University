package chapter05;

import java.util.*;

/*******************************************************************************
 * Question  5.8 (page 290)     
 * Design and implement an application that simulates a simple slot machine in 
 * which three numbers between 0 and 9 are randomly selected and printed side by 
 * side. Print an appropriate statement if all three of the numbers are the 
 * same, or if two of the numbers are the same. Continue playing until the user 
 * chooses to stop.
 ******************************************************************************/
public class SlotMachine {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random generator = new Random();

        String spinAgain = "y";
        int first, second, third, spinResult;

        System.out.println(
                "----------Slot Machine----------\n"
                + "Type 'Y' to spin again, or 'N' to stop\n");

        do {

            first = generator.nextInt(10);
            second = generator.nextInt(10);
            third = generator.nextInt(10);

            
            System.out.println("\t----------" + first + " " + second + " "
                    + third + "----------");
            
            if (first == second && second == third) {
                System.out.println("JACKPOT! All three of the same");
            }
            else if (first == second || first == third || second == third) {
                System.out.println("Close, you got two of the same!!");
            } else {
                System.out.println("Not a winner");
            }
            
            System.out.print("\nSpin again?: ");
            spinAgain = scan.nextLine();

        } while (spinAgain.equalsIgnoreCase(
                "y"));


    }
}
