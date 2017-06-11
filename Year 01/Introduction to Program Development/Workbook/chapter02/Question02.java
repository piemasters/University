package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.2 (page 134)     
 * Write an application that reads five scores (in integers) and prints the 
 * total and average of those scores.
******************************************************************************/
public class Question02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int score1, score2, score3, score4, score5, numscores =5;

        System.out.print("Enter score 1: ");
        score1 = scan.nextInt();
        System.out.print("Enter score 2: ");
        score2 = scan.nextInt();
        System.out.print("Enter score 3: ");
        score3 = scan.nextInt();
        System.out.print("Enter score 4: ");
        score4 = scan.nextInt();
        System.out.print("Enter score 5: ");
        score5 = scan.nextInt();

        double total = score1 + score2 + score3 + score4 + score5;
        double average = total / numscores;

        System.out.println("Total of Scores = " + (int)(total));
        System.out.println("Average of Scores = " + (average));
                  
    }
}
