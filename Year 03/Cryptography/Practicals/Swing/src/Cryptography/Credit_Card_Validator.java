package Cryptography;

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

    /**
     * Doubles alternative characters in the Credit Card number
     * and subtracts 9 from any value that goes into double
     * digits.
     *
     * @param intArray int array of Credit Card characters.
     */
    public static void multiplyAlternateValues(int[] intArray) {

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
    public static int totalValues(int[] intArray) {

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
    public static int modCreditCardTotal(int creditCardTotal) {
        return creditCardTotal % 10;
    }

}
