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
}
