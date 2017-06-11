package assignments.assignment2;

import java.util.*;

/*******************************************************************************
 * Question  4 - Oddy    
 * Write a program which requests and reads two positive integers (on one line) 
 * representing a range. The program should output the sum of all odd numbers 
 * in the range (inclusive). 
 *******************************************************************************

 * Enter num1 and num2
 * 
 * Find larger number and subtract the smaller away from the larger:
 * 
 * If num1 > num 2
 * total = num1-num2
 * elseif num1 < num2
 * total = num2-num1
 * else total = 0
 * 
 
 *****************************************************************************/
public class Oddy {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int high, low, temp, sum = 0;

        System.out.print("Please enter two integers: ");
        high = scan.nextInt();
        low = scan.nextInt();

        if (high < low) {
            temp = high;
            high = low;
            low = temp;
        }
        
        while(low <= high){
            if(low%2!=0){
                sum = sum + low;
            }
            low += 1;
        } 
        
        System.out.println(sum + "\n");
    }
}