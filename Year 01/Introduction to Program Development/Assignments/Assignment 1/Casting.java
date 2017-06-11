package assignments.assignment1;
import java.util.Scanner;

/* Author: David Norton, ID: 10005864
 * Program Creation Date: 10/10/2011
 * Program Version Number: 1.2 
 *      <Changes to version 1.1:>
 *      <* Changed the two 'Enter' prompt outputs from '.println' to '.print'.
 *          <Changes to version 1.0:>
 *          <* Print values of Number1 & Number2 after converting to integer to 
 *           ensure they are converted correctly.
 *          <* Print values of Number1 & Number2 after converting back to double 
 *             to ensure they are converted correctly.
 *          <* Add '(int)' into the first divison output command to convert the 
 *            value returned as an Integer.
 */

public class Casting {
    public static void main (String[] args){
     
     //Assignments
     Scanner scan = new Scanner (System.in);
     double number1, number2;
        
        //Prompt user to enter two values as data type double
        System.out.print("Enter number 1: ");
        number1 = scan.nextDouble();
        System.out.print("Enter number 2: ");
        number2 = scan.nextDouble();
        
        //Cast numbers to Integers
        number1 = (int) number1;
        number2 = (int) number2;
        
        //System.out.println(Number1);
        //System.out.println(Number2);
        
        //Print division of second number by first number as an Integer
        System.out.println("Integer result = " + (int) (number2 / number1));
        
        //Cast numbers back to Double
        number1 = (double) number1;
        number2 = (double) number2;
        
        //System.out.println(Number1);
        //System.out.println(Number2);
        
        //Print division of second number by first number as a Double
        System.out.println("Double result = " + number2 / number1);
    }
}
