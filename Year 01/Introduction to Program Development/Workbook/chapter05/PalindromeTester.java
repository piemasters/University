package chapter05;

import java.util.Scanner;

/*******************************************************************************
 * Question  5.5 (page 290)     
 * Create a modified version of the PalindromeTester program so that the spaces,
 * punctuation, and changes in uppercase and lowercase are not considered when
 * determining whether a string is a palindrome. HINT: These issues can be
 * handled in several ways. Think carefully about your design.
 ******************************************************************************/
// Demonstates the use of nested while loops.
//******************************************************************************
public class PalindromeTester {
    
    //--------------------------------------------------------------------------
    // Tests to see if they are palindromes.
    //--------------------------------------------------------------------------

    public static void main(String[] args) {
        
        //Ignore case
        //ignore spaces
        //ignore puncuation

        String str, another = "y";
        int left, right;
        
        Scanner scan = new Scanner(System.in);

        while (another.equalsIgnoreCase("y")) // allows Y or y
        {
            System.out.println("Enter a potential palindrome:");
            str = scan.nextLine();
            
            //Edit
            str = str.toLowerCase();
            str = str.replace(" ", "");
            
            //
            
            left = 0;
            right = str.length() -1;
            
            while (str.charAt(left) == str.charAt(right) && left < right)
            {
                left++;
                right--;
            }
            
            System.out.println();
            
            if (left < right)
            {
                System.out.println("That string is NOT a palindrome.");
            }
            else
            {
                System.out.println("That string IS a palindrome.");    
            }
       
            System.out.println();
            System.out.println("Test another palindrome (y/n)? ");
            another = scan.nextLine();
        
        }

    }
}
