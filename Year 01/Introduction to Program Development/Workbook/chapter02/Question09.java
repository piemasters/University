package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.9 (page 135)     
 * Create a version of the previous project that reverses the computation.
 *  THis is, read a value representing a number of seconds, then print the
 * equivalent amount of time as a combination of hours, minutes, and seconds.
******************************************************************************/

public class Question09 {
   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int hours, minutes, seconds,time;
        
        System.out.print("Enter a large number of seconds: "); 
        time = scan.nextInt();
        
        hours = time / (60*60);
        minutes = time % hours / 60;
        seconds = time % 60;
        
        System.out.println("This is equal to '" + hours + "' hours '" + minutes + 
                "' minutes '" + seconds + "' seconds");
         
}
}

