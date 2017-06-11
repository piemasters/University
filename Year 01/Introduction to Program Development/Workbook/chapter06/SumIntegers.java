package chapter06;

import java.util.*;

/*******************************************************************************
 * Question  6.1 (page 322)     
 * Design and implement an application that reads an integer value
 * and prints the sum of all even integers between 2 and the input
 * value, inclusive. Print an error message if the input value is less
 * than 2. Prompt accordingly.
 ******************************************************************************/
public class SumIntegers {

    public static void main(String[] args) {
        int userInt = 0, num = 0, sum = 0;
        
               
        System.out.print("Enter an integer greater than '2' : ");
        
        while (userInt < 2) {
        Scanner scan = new Scanner(System.in);
        userInt = scan.nextInt(); 
        if (userInt < 2) {
            System.out.print("Please enter a valid number: ");
        }
        
        }
        while(num <= userInt){
            if(num%2!=0){
                            }
            else
                sum = sum + num;
            num += 1;
        } 
    
        System.out.println("The total of all even numbers between 0-" 
                + userInt + " = " + sum);
        
    }
}