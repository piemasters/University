package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.5 (page 135)     
 * Write an application that converts feet into centimeters. (One foot equals
 * 30.48 centimeters.) Read the feet value from the user as a floating point
 * value and convert it.
******************************************************************************/

public class Question05 {
   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Float feet, centimeters;
        final double FEET_TO_CENT = 30.48;
        
        System.out.print("Enter number of feet to convert to centimeters: "); 
        feet = scan.nextFloat();
        
        centimeters = feet * (float) FEET_TO_CENT;
        System.out.println("Number of centimeters = " + centimeters);
         
}
}
