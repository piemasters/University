package Cryptography.Week01;

import java.util.Scanner;

/**
 * <h1>ISBN Validator</h1>
 * Takes a Credit Card number from the user and determines
 * if it is valid or not.
 *
 * @author David Norton
 * @version 1.2
 * @since 22/09/2014
 */
public class CreditCard {

    public static void main(String[] args) {

        // Get Credit Card Number number
        String cardNumber = getCardNumber();

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
     * Gets a Credit Card number from the user.
     *
     * @return User input Credit Card number.
     */
    private static String getCardNumber() {

        Scanner scan = new Scanner(System.in);
        String cardNumber = "";
        boolean validInput = false;

        // Ensure input is valid.
        while (!validInput) {

            System.out.print("Enter a Credit Card Number (e.g. 4552 7204 1234 5698): ");
            cardNumber = scan.nextLine();

            // If characters are correct
            if (cardNumber.matches("([0-9]+)")) {

                // If length is correct
                if (cardNumber.length() == 16) {
                    validInput = true;
                } else {
                    System.out.print("Invalid input. Ensure the value contains 16 numbers.\n");
                }

            } else {
                System.out.print("Invalid input. Contains incorrect characters\n");
            }

        }

        return cardNumber;
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
