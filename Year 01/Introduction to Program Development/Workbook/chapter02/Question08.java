package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.8 (page 135)     
 * Write an application that reads values representing a time duration in hours,
 * minutes, and seconds and then prints the equivalent total number of seconds.
******************************************************************************/

public class Question08 {
   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int hours, minutes, seconds,time;
        
        System.out.print("Enter the number of hours: "); 
        hours = scan.nextInt();
        System.out.print("Enter the number of minutes: "); 
        minutes = scan.nextInt();
        System.out.print("Enter the number of seconds: "); 
        seconds = scan.nextInt();
               
        time = hours * 60*60 + minutes * 60 + seconds;
        
        System.out.println("Time in seconds = " + time + "s");
         
}
}
