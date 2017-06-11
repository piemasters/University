package chapter05;

import java.util.*;

/*******************************************************************************
 * Question  5.9 (page 290)     
 * Design and implement an application that takes a paragraph of text from the 
 * user and prints the total number of words and characters present in that 
 * paragraph by properly tokenizing the words. (Hint: Spaces can be used as a 
 * delimiter for tokenization.)
 ******************************************************************************/
public class WordCounter {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int wordCount = 0, charCount = 0;
        String word;

        System.out.println("Enter a paragraph: \n");
        String paragraph = scan.nextLine();

        StringTokenizer st = new StringTokenizer(paragraph);


        while (st.hasMoreTokens()) {
            word = st.nextToken();
            wordCount = wordCount + 1;
        }
        charCount = charCount + paragraph.length();
        
        System.out.println("\nWord Count: \t" + wordCount);
        System.out.println("Char Count: \t" + charCount);


    }
}
