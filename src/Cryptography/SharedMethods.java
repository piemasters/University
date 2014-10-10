package Cryptography;

import java.util.Scanner;

/**
 * <h1>Lecture 01 Shared Methods</h1>
 * Any shared methods for lecture 01.
 *
 * @author David Norton
 * @version 1.2
 * @since 23/09/2014
 */
public class SharedMethods {

    /**
     * Adds each character of a String into an element
     * of an int array.
     *
     * @param inputString String to be moved into int array..
     * @return int array containing each character in a String in a seperate element.
     */
    public static int[] addToArray(String inputString) {

        // Add to String array
        String[] strArray = inputString.split("");

        // Set int array to length of ISBN
        int[] intArray = new int[strArray.length];

        // Move values from String array to int array
        for(int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        return intArray;
    }

    /**
     * Gets an integer number from the user in String format.
     *
     * @param length Length of the number.
     * @return User input integer as a String.
     */
    public static String getFixedLengthNumber(int length) {

        Scanner scan = new Scanner(System.in);
        String inputNum = "";
        boolean validInput = false;

        // Ensure input is valid.
        while (!validInput) {

            System.out.print("Enter a " + length + " digit number: ");
            inputNum = scan.nextLine();

            // If characters are correct
            if (inputNum.matches("([0-9]+)")) {

                // If length is correct
                if (inputNum.length() == length) {
                    validInput = true;
                } else {
                    System.out.print("Invalid input. Ensure the value contains " + length + " numbers.\n\n");
                }

            } else {
                System.out.print("Invalid input. Contains incorrect characters\n");
            }

        }

        return inputNum;
    }

    /**
     * Gets an integer number from the user in String format.
     *
     * @return User input integer as a String.
     */
    public static String getVariableLengthNumber() {

        Scanner scan = new Scanner(System.in);
        String inputNum = "";
        boolean validInput = false;

        // Ensure input is valid.
        while (!validInput) {

            System.out.print("Enter an integer: ");
            inputNum = scan.nextLine();

            // If characters are correct
            if (inputNum.matches("(([-]?[0-9]+))")) {

               validInput = true;

            } else {
                System.out.print("Invalid input. Contains incorrect characters\n");
            }

        }

        return inputNum;
    }

    /**
     *
     * @param intArray encodedInput in array form.
     * @return Array as a String.
     */
    public static String convertArrayToString (int[] intArray) {

        String convertedString = "";

        for (int anIntArray : intArray) {
            convertedString += anIntArray + "";
        }

        return convertedString;
    }

    /**
     * If x is a negative number, convert it
     * to the correct positive value.
     *
     * @param x Negative value.
     * @return Correct positive value of x.
     */
    public static int getNegativeX(int x) {

        while (x < 0) {

            // Convert to positive value.
            x = -x;

            // Subtract 11 and convert back to positive.
            x = (x - 11) * -1;
        }

        return x;
    }

    /**
     * Finds the power of X.
     *
     * @param x Negative value.
     * @return Correct positive value of x.
     */
    public static int getPowerX(int x) {

        // Multiple x * x then take mod 11.
        x = (x * x) % 11;

        return x;
    }

    /**
     * Finds the square root of X.
     *
     * @param x Value to be square rooted.
     * @return Square rooted value.
     */
    public static int sqrtX(int x) {

        switch (x) {
            case 1:
                x = 1;
                break;
            case 3:
                x = 5;
                break;
            case 4:
                x = 2;
                break;
            case 5:
                x = 4;
                break;
            case 9:
                x = 3;
                break;
            default:
                x = 0;
        }

        return x;
    }

    /**
     * Finds the power to -1 of X.
     *
     * @param x Value to power of -1.
     * @return Integer value of x^-1.
     */
    public static int getNegativePowerOld (int x) {

        // 1/5 = ?	1 = 5x

        int numerator = 1;
        int counter = 1;

        // Increment the numerator by 11 until its mod 11 = 0.
        // 1, 12, 23, 34, 45
        while (numerator % x != 0) {
            numerator += 11;
            counter ++;
        }

        // Divide the new numerator by the counter to find x.
        // 45 = 5x = 9
        x = numerator / counter;

        return x;

    }

    /**
     * Finds the power to -1 of X.
     *
     * @param x Value to power of -1.
     * @return Integer value of x^-1.
     */
    public static int getNegativePower(int x) {

        int n = 11, t = 0, newt = 1, r = n, newr = x, q, temp;

        while(newr != 0) {

            q = r / newr;  /* integer division */
            temp = newt;   /* remember newt    */
            newt = t - q * newt;
            t = temp;
            temp = newr;   /* remember newr    */
            newr = r - q * newr;
            r = temp;
        }

        if(r > 1) return -1; /* not invertible */

        if(t < 0) t = t + n; /* change to positive */

        return t;
    }

}
