package chapter03;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

/*******************************************************************************
 * Question  3.5 (page 183)     
 * Write an application that reads the radius of a sphere and prints its volume
 * and surface area. Use the following formulas. Print the output to four
 * decimal places. r represents the radius.
 * Volume = (4/3)*pi*r^3
 * Surface Area = 4*pi*r^2
 ******************************************************************************/
public class Sphere05 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pi = 3.14159265;

        System.out.println("Enter the radius of a sphere: ");
        double radius = scan.nextDouble();


        double volume = (4/3) * pi * Math.pow(radius, 3);
        DecimalFormat dfVolume = new DecimalFormat("Rs .####");
        double surfaceArea = 4 * pi * Math.pow(radius, 2);
        DecimalFormat dfSurfaceArea = new DecimalFormat("Rs .####");

        System.out.println("The volume of the sphere is: " + dfVolume.format(volume));
        System.out.println("The surface area of the sphere is: " + dfSurfaceArea.format(surfaceArea));
    }
}
