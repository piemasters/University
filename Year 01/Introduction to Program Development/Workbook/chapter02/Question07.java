package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.7 (page 135)     
 * Write an application that prompts for and reads integer values for speed
 * and distance traveled, then prints the time required for the trip as a
 * floating point result.
******************************************************************************/

public class Question07 {
   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int speed, distance; 
        float time;
        
        System.out.print("Enter your speed (in miles per hour): "); 
        speed = scan.nextInt();
        System.out.print("Enter your distance (in miles): "); 
        distance = scan.nextInt();
               
        time = (float)distance / (float)speed;
        
        System.out.println("Time required = " + time + " hours");
         
}
}
