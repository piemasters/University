package chapter03;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Random;

/*******************************************************************************
 * Question  3.7 (page 184)     
 * Write an application that generates a random integer in the range of 20-40,
 * inclusive, and displays the sine, cosine, and tangent of that number.
 ******************************************************************************/
public class Trigonometry07 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Random rand = new Random();
        int randomInt;

        randomInt = rand.nextInt(21) + 20;
        
        double sine = Math.sin(randomInt);
        double cosine = Math.cos(randomInt);
        double tangent = Math.tan(randomInt);

        System.out.println("The random number generated is: " + randomInt);
        System.out.println("The Sine of the number is: " + sine);
        System.out.println("The Cosine of the number is: " + cosine);
        System.out.println("The Tangent of the number is: " + tangent);
    }
}
