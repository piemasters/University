package chapter03;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

/*******************************************************************************
 * Question  3.6 (page 184)     
 * Write an application that reads the lengths of the sides of a triangle from
 * the user. Compute the area of the triangle using Herons formula listed below,
 * in which s represents half of the perimeter of the triangle and a,b, and c
 * represent the lengths of the three sides. Print the area to three decimal
 * places.
 * Area = sqrt(s(s - a) (s - b) (s - c))
 ******************************************************************************/
public class Triangle06 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter the lengths of a triangle: ");
        System.out.print("Length 1: ");
        double length1 = scan.nextDouble();
        System.out.print("Length 2: ");
        double length2 = scan.nextDouble();
        System.out.print("Length 3: ");
        double length3 = scan.nextDouble();
        
        double s = (length1 + length2 + length3) /2;
        
        double area = Math.sqrt(s * (s - length1) * 
                (s - length2) * (s - length3));
        

        DecimalFormat dfArea = new DecimalFormat("#.###");

        System.out.println("The area of the triangle is: " 
                + dfArea.format(area));

    }
}
