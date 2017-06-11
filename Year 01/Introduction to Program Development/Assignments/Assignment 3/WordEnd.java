package assignments.assignment3;

import java.util.*;
import java.io.*;

/*******************************************************************************
 *
 * Program Name : WordEnd.java
 * Example Input/Output: 
 * Enter a word: gland
 * d,nd,and,land,gland,
 * 
 * Program reads in a word and outputs the last character then a "," then the 
 * last 2 characters of the word etc ... (as shown in example above using 
 * the word gland). 
 * Note: Don't forget the final newline!
 * 
 *****************************************************************************/
public class WordEnd {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        String word;
        int wordLength, charCount = 0, incCount, forCharCount;

        //--------------- Input Word ------------------
        System.out.print("Enter a word: ");
        word = scan.next();

        wordLength = word.length();
        charCount = wordLength;
        forCharCount = charCount;
        //---------------------------------------------

        //------------ Add String to Array ------------
        String reverse = new StringBuffer(word).reverse().toString();
        char[] wordArray = reverse.toCharArray();
        //---------------------------------------------
        
        //--------------- Print Result ----------------
        while (charCount > 0) {
            for (incCount = forCharCount - wordLength + 1; incCount > 0; incCount--) {
                System.out.print(wordArray[incCount - 1]);
            }
            forCharCount += 1;
            charCount -= 1;
            System.out.print(",");
        }  
        //---------------------------------------------
        
        System.out.println("\n");
    }
}