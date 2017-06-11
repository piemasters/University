package chapter02;

import java.util.Scanner;

/*******************************************************************************
 * Question  2.11 (page 135)     
 * Write an application that prompts for and reads a double value representing a
 * monetary amount. Then determine the fewest number of each bill and coin
 * needed to represent that amount, starting with the highest (assume that a 
 * ten-dollar bill is the maximum size needed).
 ******************************************************************************/
public class Question11 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        final int TENDOLLAR = 1000, FIVEDOLLAR = 500, ONEDOLLAR = 100,
                QUARTER = 25, DIME = 10, NICKEL = 5, PENNY = 1;
        int numtendollar, numfivedollar, numonedollar, numquarter, numdime,
                numnickel, numpenny;
        double entered;


        System.out.print("Enter a monetary amount: ");
        entered = scan.nextDouble();


        entered = entered * 100;
        int value = (int) entered;

        numtendollar = value / TENDOLLAR;
        value = value - (numtendollar * TENDOLLAR);
        numfivedollar = value / FIVEDOLLAR;
        value = value - (numfivedollar * FIVEDOLLAR);
        numonedollar = value / ONEDOLLAR;
        value = value - (numonedollar * ONEDOLLAR);
        numquarter = value / QUARTER;
        value = value - (numquarter * QUARTER);
        numdime = value / DIME;
        value = value - (numdime * DIME);
        numnickel = value / NICKEL;
        value = value - (numnickel * NICKEL);
        numpenny = value / PENNY;
        value = value - (numpenny * PENNY);

        System.out.println("The equivalent amount is: ");
        System.out.println(numtendollar + " ten dollar bills");
        System.out.println(numfivedollar + " five dollar bills");
        System.out.println(numonedollar + " one dollar bills");
        System.out.println(numquarter + " quarters");
        System.out.println(numdime + " dimes");
        System.out.println(numnickel + " nickels");
        System.out.println(numpenny + " pennies"); 
    }
}
