package chapter05;

import java.util.Scanner;

/*******************************************************************************
 * Question  5.3 (page 289)     
 * Design and implement an application that reads an input sentence from the 
 * user and prints it, with one word per line.
 ******************************************************************************/
public class WordPerLine {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String sentence;

        System.out.print("Enter a sentence: ");
        sentence = scan.nextLine();
        
        sentence = sentence.replace(" ", "\n");
        
        System.out.println("Your sentence is: \n" + sentence);
        
//        while character (!= "")
//                {
//                    if (character = " ")
//                    {
//                        replace with "\n"
//                    }
//                    move to next character
//                }
        
        

    }
}
