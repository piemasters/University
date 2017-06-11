package chapter06;

import java.util.*;

/*******************************************************************************
 * Question  6.3 (page 322)     
 * Design and implement an application that produces a multiplication
 * table, showing the results of multiplying the integers 1
 * through 12 by themselves.
 ******************************************************************************/
public class MultiplicationTable {
 
    public static void main(String[] args) {
        
        int num = 1, result;
        
        do {
        result = num*num;
            System.out.println(num + " x " + num + " = " + result);
        num = num+1;
    } while (num <= 12);
        
        
        
    }
}
