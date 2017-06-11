package chapter05;

import java.util.Scanner;
import java.util.Random;

/*******************************************************************************
 * Question  5.4 (page 289)     
 * Design and implement an application that plays the Hi-Lo guessing game with
 * numbers. The program should pick a random number between 1 and 100 
 * (inclusive), then repeatedly prompt the user to guess the number. On each
 * guess, report to the user that he or she is correct or that the guess is high
 * or low.
 ******************************************************************************/
public class HiLo {

    public static void main(String[] args) {
        final int MAX = 100;
        String again;
        int target, guess, count = 0;

        Scanner scan = new Scanner(System.in);

        do 
        {

            // pick a target value

            System.out.println("Guess a number between 1 and " + MAX);
            target = (int) (Math.random() * MAX) + 1;
            count = 0;

            do 
            {
                System.out.print("Enter your guess (0 to quit): ");
                guess = Integer.parseInt(scan.nextLine());
                count = count + 1;
                if (guess > 0) {
                    if (guess == target) {
                        System.out.println("Right! Guesses: " + count);
                    } else if (guess < target) {
                        System.out.println("Your guess was LOW.");
                    } else {
                        System.out.println("Your guess was HIGH.");
                    }
                }

            } while (guess != target && guess > 0);

            System.out.println();
            System.out.println("Play again (y/n)?: ");
            again = scan.nextLine();

        } while (again.equalsIgnoreCase("y"));



    }
}
