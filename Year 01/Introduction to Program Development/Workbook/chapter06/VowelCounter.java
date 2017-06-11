package chapter06;

import java.util.*;

/*******************************************************************************
 * Question  6.9 (page 323)     
 * Design and implement an application that reads a string from
 * the user, then determines and prints how many of each lowercase
 * vowel (a, e, i, o, and u) appear in the entire string. Have a separate
 * counter for each vowel. Also count and print the number of
 * non-vowel characters..
 ******************************************************************************/
public class VowelCounter {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0;

        System.out.println("Enter a paragraph: \n");
        String paragraph = scan.nextLine();
        

        for (int i = 0; i < paragraph.length(); i ++) {         
            
            switch (paragraph.charAt(i)) {
                case 'a':
                    aCount++;
                    break;
                case 'e':
                    eCount++;
                    break;
                case 'i':
                    iCount++;
                    break;
                case 'o':
                    oCount++;
                    break;
                case 'u':
                    uCount++;
                    break;
                case 'A':
                    aCount++;
                    break;
                case 'E':
                    eCount++;
                    break;
                case 'I':
                    iCount++;
                    break;
                case 'O':
                    oCount++;
                    break;
                case 'U':
                    uCount++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("\n'A' Count: \t" + aCount);
        System.out.println("'E' Count: \t" + eCount);
        System.out.println("'I' Count: \t" + iCount);
        System.out.println("'O' Count: \t" + oCount);
        System.out.println("'U' Count: \t" + uCount);
    }
}