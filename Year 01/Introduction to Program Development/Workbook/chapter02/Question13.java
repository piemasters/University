package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.13 (page 136)     
 * Write an application that prompts for and reads the numerator and denominator
 * of a fraction as integers, then prints the decimal equivalent of the 
 * fraction.
******************************************************************************/

public class Question13 {
   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int denominator, numerator;
        double decimal;
        
        System.out.print("Enter the numerator of a fraction: "); 
        numerator = scan.nextInt();
         System.out.print("Enter the denominator of a fraction: "); 
        denominator = scan.nextInt();      

        decimal = (double)numerator / (double)denominator;
        
        System.out.println("Your fraction is: " + numerator + "/"
                + denominator);
        System.out.println("The decimal equivalent is: " + decimal);
         
}
}
