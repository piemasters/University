package Cryptography.Week01;

import Cryptography.SharedMethods;

/**
 * <h1>Credit Card Validators</h1>
 * Takes a Credit Card number from the user and determines
 * if it is valid or not.
 *
 * @author David Norton
 * @version 1.3
 * @since 22/09/2014
 */
public class Credit_Card_Validator {

    public static void main(String[] args) {

        System.out.println("---- Credit Card Validator ----");
        // Get Credit Card Number number
        String cardNumber = SharedMethods.getFixedLengthNumber(16);

        // Add Credit Card number to int array
        int[] intArray = SharedMethods.addToArray(cardNumber);

        // Multiply alternate values
        multiplyAlternateValues(intArray);

        // Total values
        int creditCardTotal = totalValues(intArray);

        // Mod Credit Card Total
        int creditCardMod = modCreditCardTotal(creditCardTotal);

        // Check if ISBN is valid
        checkIfValid(creditCardMod);

    }

    /**
     * Doubles alternative characters in the Credit Card number
     * and subtracts 9 from any value that goes into double
     * digits.
     *
     * @param intArray int array of Credit Card characters.
     */
    private static void multiplyAlternateValues(int[] intArray) {

        // For every other item in the array
        for(int i = 0; i < intArray.length; i+=2) {

            // Double the value
            intArray[i] *= 2;

            // Fix values over 10
            if  (intArray[i] > 9) {
                intArray[i] -= 9;
            }
        }
    }

    /**
     * Adds together all the individual numbers in the
     * Credit Card number.
     *
     * @param intArray int array of Credit Card characters.
     * @return The sum of all characters in the Credit Card number.
     */
    private static int totalValues(int[] intArray) {

        int total = 0;

        for (int anIntArray : intArray) {
            total += anIntArray;
        }

        return total;
    }

    /**
     * Mods the total of all the individual numbers in the
     * Credit Card number.
     *
     * @param creditCardTotal All Credit Card characters added together.
     * @return Mod of Credit Card total.
     */
    private static int modCreditCardTotal(int creditCardTotal) {
        return creditCardTotal % 10;
    }

    /**
     * Checks if the Credit Card number is a valid or invalid.
     *
     * @param creditCardMod Mod of Credit Card total.
     */
    private static void checkIfValid(int creditCardMod) {

        if (creditCardMod == 0) {
            System.out.println("--------------------------------");
            System.out.println("The Credit Card number is valid.");
            System.out.println("--------------------------------");
        } else {
            System.out.println("------------------------------------");
            System.out.println("The Credit Card number is not valid.");
            System.out.println("------------------------------------");
        }
    }
}
