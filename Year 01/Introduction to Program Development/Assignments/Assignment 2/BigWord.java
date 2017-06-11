package assignments.assignment2;

import java.util.*;

/*******************************************************************************
 * Question  1 - Big Word    
 * Program requests and reads three words and outputs the longest word 
 * (plus a final newline). If there is more than one word of the longest length 
 * then print the first word of this length. The words may be entered over one 
 * or more lines.
 *******************************************************************************

 * Enter first word
 * Make first word the longest word
 * For number of words entered = 3
 * if next word is greater than longest word
 *      next word = longest word
 * Print result
 * Print blank line

 *****************************************************************************/
public class BigWord {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String longestWord, nextWord;

        System.out.print("Please enter 3 words: ");
        longestWord = scan.next();

        for (int wordCount = 1; wordCount <= 2; wordCount++) {
            nextWord = scan.next();
//            if (nextWord.length() > longestWord.length()) {
//                longestWord = nextWord;
//            }
            longestWord = longestWord.length() >= nextWord.length() ? longestWord : nextWord;
        }
        System.out.println((longestWord) + "\n");
    }
}