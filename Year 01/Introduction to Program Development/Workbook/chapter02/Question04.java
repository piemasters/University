package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.4 (page 135)     
 * Write an application that reads two floating point numbers and prints their
 * sum, difference, and product.
******************************************************************************/

public class Question04 {
   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Float number1, number2, sum, difference, product;
        
        System.out.print("Enter Number 1: "); 
        number1 = scan.nextFloat();
        System.out.print("Enter Number 2: ");
        number2 = scan.nextFloat();
        
        sum = number1 + number2;
        difference = number2 - number1;
        product = number1 * number2;
        
        System.out.println("Their Sum = " + sum);
        System.out.println("Their difference = " + difference);
        System.out.println("Their product = " + product);       
}
}
