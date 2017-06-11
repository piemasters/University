package chapter06;

import java.util.*;

/*******************************************************************************
 * Question  6.2 (page 322)     
 * Design and implement an application that reads a string from the
 * user and prints it one character per line.
 ******************************************************************************/
public class CharPerLine {

    public static void main(String[] args) {
        
      
        Scanner scan = new Scanner(System.in);
        String sentence;

        System.out.print("Enter a sentence: ");
        sentence = scan.nextLine();
        
        sentence = sentence.replace("", "\n");
        
        System.out.println("Your sentence is: \n" + sentence);
        
    }
}
