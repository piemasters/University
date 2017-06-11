package assignments.assignment3;

import java.util.*;
import java.io.*;

/*******************************************************************************
 *
 * Program Name: Longer.java 
 * Example Output/Input: 	
 * Enter 2 words: rabbit pie
 * rabbit
 * 
 * Write a main program which requests (as shown) 2 words then outputs the 
 * longest (exactly as shown). The program must use a public static method 
 * called longest which takes 2 string parameters (words) and returns the 
 * longest of these. If both words are the same length it should return
 * the first parameter.
 * 
 *****************************************************************************/
public class Longer {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String longestWord, nextWord;

        System.out.print("Enter 2 words: ");
        longestWord = scan.next();
        nextWord = scan.next();

        longest(nextWord, longestWord);

        System.out.println("");
    }

    public static void longest(String nextWord, String longestWord) {
        if (nextWord.length() > longestWord.length()) {
            longestWord = nextWord;
        }

        System.out.println(longestWord);
    }
}
