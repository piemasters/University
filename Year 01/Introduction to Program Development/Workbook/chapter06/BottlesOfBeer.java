package chapter06;

import java.util.*;

/*******************************************************************************
 * Question  6.4 (page 322)     
 * Design and implement an application that prints the first few
 * verses of the traveling song "One Hundred Bottles of Beer" Use
 * a loop such that each iteration prints one verse. Read the number
 * of verses to print from the user. Validate the input. The following
 * are the first two verses of the song:
 * 
 * 100 bottles of beer on the wall
 * 100 bottles of beer
 * If one of those bottles should happen to fall
 * 99 bottles of beer on the wall
 * 99 bottles of beer on the wall
 * 99 bottles of beer
 * If one of those bottles should happen to fall
 * 98 bottles of beer on the wall
 ******************************************************************************/
public class BottlesOfBeer {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num = 0;
        System.out.print("Enter how many verses of \"One Hundred B"
                + "ottles of Beer\" you would like to hear: ");
        
        while (num < 1) {
            num = scan.nextInt();
            if (num < 2) {
                System.out.print("Please enter a valid number: ");
            }
        }
        
        System.out.println("");
        
        do {
            System.out.println(num + " bottles of beer on the wall");
            System.out.println(num + " bottles of beer");
            System.out.println("If one of those bottles should happen to fall");
            num = num - 1;
            System.out.println(num + " bottles of beer on the wall\n");
        } while (num >= 1);

    }
}