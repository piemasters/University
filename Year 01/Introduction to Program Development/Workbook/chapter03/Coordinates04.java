package chapter03;

import java.util.Scanner;
import java.lang.Math;


/*******************************************************************************
 * Question  3.4 (page 183)     
 * Write an application that reads the (x,y) coordinates for two points.
 * Compute the distance between the two points using the following formula:
 * Distance = sqrt(x2 -x1)sqd + (y2 -y1)sqd
 ******************************************************************************/
public class Coordinates04 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter two pairs of co-ordinates");
        System.out.println("First co-ordinates: ");
        System.out.print("x: ");
        double x1 = scan.nextDouble();
        System.out.print("y: ");
        double y1 = scan.nextDouble();
        System.out.println("Second co-ordinates: ");
        System.out.print("x: ");
        double x2 = scan.nextDouble();
        System.out.print("y: ");
        double y2 = scan.nextDouble();

        double distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));

        System.out.println("The distance between the two "
                + "co-ordinates is: " + distance);
    }
}
