package Cryptography.Week02;

import Cryptography.SharedMethods;

/**
 * <h1>Check Six Digit Number</h1>
 * Takes a six digit value and calculates an additional
 * 4 parity bits and appends them to the value.
 *
 * @author David Norton
 * @version 1.1
 * @since 29/09/2014
 */
public class CheckSixDigitNumber {

    public static void main(String[] args) {

        // Generate 10 digit number from user input.
        String finalValue = getTenDigitEncodedValue();

        // Print Result
        System.out.println(finalValue);

    }

    /**
     * Get a 10 digit encoded value from a six digit user input number.
     *
     * @return 10 digit encoded number.
     */
    public static String getTenDigitEncodedValue() {
        int d1, d2, d3, d4, d5, d6, d7, d8, d9, d10;

        // Get input values.
        String initialNumber = SharedMethods.getFixedLengthNumber(6);

        // Add number to int array
        int[] intArray = SharedMethods.addToArray(initialNumber);

        // Assign user input to variables
        d1 = intArray[0];
        d2 = intArray[1];
        d3 = intArray[2];
        d4 = intArray[3];
        d5 = intArray[4];
        d6 = intArray[5];

        // Get parity bits
        d7 = getFirstParityBit(d1, d2, d3, d4, d5, d6);
        d8 = getSecondParityBit(d1, d2, d3, d4, d5, d6);
        d9 = getThirdParityBit(d1, d2, d3, d4, d5, d6);
        d10 = getForthParityBit(d1, d2, d3, d4, d5, d6);

        // Add parity bits if valid and print result
        return addParityBits(d7, d8, d9, d10, initialNumber);
    }

    /**
     * Calculates the first parity bit.
     *
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @return The first parity bit.
     */
    public static int getFirstParityBit(int d1, int d2, int d3, int d4, int d5, int d6) {

        int d7 = (4 * d1 + 10 * d2 + 9 * d3 + 2 * d4 + d5 + 7 * d6) % 11;

        return d7;
    }

    /**
     * Calculates the second parity bit.
     *
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @return The second parity bit.
     */
    public static int getSecondParityBit(int d1, int d2, int d3, int d4, int d5, int d6) {

        int d8 = (7 * d1 + 8 * d2 + 7 * d3 + d4 + 9 * d5 + 6 * d6) % 11;

        return d8;
    }

    /**
     * Calculates the third parity bit.
     *
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @return The third parity bit.
     */
    public static int getThirdParityBit(int d1, int d2, int d3, int d4, int d5, int d6) {

        int d9 = (9 * d1 + d2 + 7 * d3 + 8 * d4 + 7 * d5 + 7 * d6) % 11;

        return d9;
    }

    /**
     * Calculates the forth parity bit.
     *
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @return The forth parity bit.
     */
    public static int getForthParityBit(int d1, int d2, int d3, int d4, int d5, int d6) {

        int d10 = (d1 + 2 * d2 + 9 * d3 + 10 * d4 + 4 * d5 + d6) % 11;

        return d10;
    }

    /**
     * Checks if the final value is valid and prints the result.
     *
     * @param d7 First parity bit.
     * @param d8 Second parity bit.
     * @param d9 Third parity bit.
     * @param d10 Forth parity bit.
     * @param initialNumber Initial user input number.
     */
    public static String addParityBits(int d7, int d8, int d9, int d10, String initialNumber) {

        String finalValue = "";

        if (d7 >= 10 || d8 >= 10 || d9 >= 10 || d10 >= 10) {
            finalValue ="Unusable Number";
        } else {
            finalValue = initialNumber + "" + d7 + "" + d8 + "" + d9 + "" + d10;
        }

        return finalValue;
    }

}