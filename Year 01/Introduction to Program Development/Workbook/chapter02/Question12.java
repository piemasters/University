package chapter02;
import java.util.Scanner;

/*******************************************************************************
 * Question  2.12 (page 136)     
 * Write an application that prompts for and reads an integer representing
 * the length of a squares side, then prints the squares perimeter and area.
******************************************************************************/

public class Question12 {
   public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int length, perimeter, area;
        
        System.out.print("Enter the length of a squares side: "); 
        length = scan.nextInt();
        
        perimeter = length * 4;
        area = length * length;
        
        System.out.println("Perimeter = " + perimeter);
        System.out.println("Area = " + area);
         
}
}

