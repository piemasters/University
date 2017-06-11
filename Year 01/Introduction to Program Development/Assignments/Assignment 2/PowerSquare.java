package assignments.assignment2;

import java.util.*;
import java.math.*;
import java.text.DecimalFormat;

/*******************************************************************************
 * Question  3 - PowerSquare   
 * Request and read two real (double) numbers and use Math methods to calculate 
 * the cube of the first number and the square root of the second number. 
 * Output the largest of the 2 calculated values. 
 * 
 * Use DecimalFormat so that the answer has:
 * •	at least 1 number in the integer part 
 * •	always 2 numbers in the decimal part
 * 
 * •	Do not take the square root of a negative number – make sure you use 
 *      the absolute (positive) value. 
 * •	Use a Math method (not an if statement) to find the largest value.


 *******************************************************************************
 
 * Input num1
 * Input num2
 * Convert num2 to positive
 * num1 = num1^3
 * num2 = sqrt(num2)
 * Math ( find largest (num1 or num2))
 * Print largest

 *****************************************************************************/
public class PowerSquare {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double num1, num2, largest;
        
        System.out.print("Enter 2 numbers: ");
        num1 = Math.abs(scan.nextDouble());
        num2 = Math.abs(scan.nextDouble());

        num1 = Math.pow(num1, 3);
        num2 = Math.sqrt(num2);
        
        largest = Math.max(num1, num2);
        
        DecimalFormat fmt1 = new DecimalFormat("0.00");
        
        System.out.println(fmt1.format(largest) + "\n");
    }
}
