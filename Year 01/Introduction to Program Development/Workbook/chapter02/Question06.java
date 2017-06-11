package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.6 (page 135)     
 * Write an application that converts miles to kilometers. (One mile equals
 * 1.60935 kilometers.) Read the miles value from the user as a floating
 * point value and convert it.
******************************************************************************/

public class Question06 {
   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        float miles; 
        double kilometers;
        final double MILES_TO_KILO = 1.60935;
        
        System.out.print("Enter number of miles to convert to kilometers: "); 
        miles = scan.nextFloat();
        double doublemiles = miles;
        
        kilometers = doublemiles * MILES_TO_KILO;
        System.out.println("Number of kilometers = " + kilometers);
         
}
}
