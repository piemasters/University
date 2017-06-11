package year2.SD.Week2;

import java.util.*;
import java.math.*;
import java.text.*;

public class Converter {

    public static void main(String[] args) {
        ConvLogic u1 = new ConvLogic();
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the GBP - EURO convertor");
        System.out.println("-------------------------------------------------");
        System.out.print("What is the current exchange rate GBP -> Euro: ");


        u1.setExchangeRate(scan.nextDouble());

        System.out.print("-------------------------------------------------\n"
                + "Please select one of the following options:\n"
                + "\tExchange £ to € (1)\n"
                + "\tExchange € to £ (2)\n\t");

        u1.setCurrencyType(scan.nextInt());
        System.out.print("-------------------------------------------------\n");

        if (u1.currencyType == 1 || u1.currencyType == 2) {

            System.out.print("Enter the amount you would like to convert: ");
            if (u1.currencyType == 1) {
                System.out.print("£");
            }
            if (u1.currencyType == 2) {
                System.out.print("€");
            }
            u1.setAmount(scan.nextDouble());
            System.out.println("The converted amount is: " + u1.getFinalConversion());
        } else {
            System.out.println("\nInvalid input. Please Enter '1' or '2' next time.");
        }
    }
}
