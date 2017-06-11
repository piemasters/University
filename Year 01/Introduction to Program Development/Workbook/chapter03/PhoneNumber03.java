package chapter03;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Random;
import java.text.NumberFormat;

/*******************************************************************************
 * Question  3.3 (page 183)     
 * Write an application that creates and prints a random phone number of the
 * form XXX-XXX-XXXX. Include dashed in output. Do not let the first three 
 * digits contain an 8 or 9 and make sure that the second set of three digits is
 * not greater than 742.
 ******************************************************************************/
public class PhoneNumber03 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("The First three digits must not contain an 8 or 9");
        System.out.println("The Second three digits must not be "
                + "greater than 742");
        System.out.print("Enter Telephone Number: ");

        String phonenumber = scan.next();
        
        String prt1 = phonenumber.substring(0, 3);
        String prt2 = phonenumber.substring(3, 6);
        String prt3 = phonenumber.substring(6, 10);
        
        System.out.print("Your formatted phone number is: ");
        System.out.println(prt1 + "-" + prt2 + "-" + prt3);

    }
}
