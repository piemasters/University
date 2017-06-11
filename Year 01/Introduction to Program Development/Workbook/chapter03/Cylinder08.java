package chapter03;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Random;

/*******************************************************************************
 * Question  3.8 (page 184)     
 * Write an application that generates a random integer radius, (r) and height
 * (h) for a cylinder in the range 1-10, inclusive, and then compute the volume
 * and surface area of the cylinder.
 * Volume = pi*r^2*h
 * Area = 2*pi*r*h
 ******************************************************************************/
public class Cylinder08 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Random rand = new Random();

        int radius = rand.nextInt(10) + 1;
        int height = rand.nextInt(10) + 1;
        
        double pi = 3.14159265;


        double volume = pi * Math.pow(radius, 2) * height;

        double surfaceArea = 2 * pi * radius * height;

        System.out.println("The random radius is: " + radius + 
                " and height is: " + height);
        System.out.println("The volume of the cylinder is: " + volume);
        System.out.println("The surface area of the cylinder is: " 
                + surfaceArea);
    }
}
