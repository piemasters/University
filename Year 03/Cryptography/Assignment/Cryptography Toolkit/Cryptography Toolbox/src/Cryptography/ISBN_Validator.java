package Cryptography;

import java.util.Scanner;

/**
 * <h1>ISBN Validator</h1>
 * Takes a ISBN number from the user and determines if it
 * is valid or not.
 *
 * @author David Norton
 * @version 1.1
 * @since 22/09/2014
 */
public class ISBN_Validator {

    /**
     * Formats the ISBN number to remove the -'s.
     *
     * @param isbn User inputted ISBN number.
     * @return ISBN value with -'s removed.
     */
    public static String removeSymbols(String isbn) {
        return isbn.replaceAll("-", "");
    }

    /**
     * Uses the formula (d1 + 2d2 + 3d3 + …+ 9d9) to multiply each
     * value of the ISBN number.
     *
     * @param intArray int array of ISBN values.
     * @return ISBN values totaled.
     */
    public static int multiplyISBNValues(int[] intArray) {

        int ISBNTotal = 0;

        // Multiply all but last value using formula and total them
        for(int i = 0; i < intArray.length -1; i++) {
            intArray[i] = intArray[i] * (i + 1);
            ISBNTotal += intArray[i];
        }

        return ISBNTotal;
    }

    /**
     * Mods the totalled values of the ISBN.
     *
     * @param ISBNTotal ISBN values totaled.
     * @return Mod value of ISBN total.
     */
    public static int modISBNTotal(int ISBNTotal) {
        return ISBNTotal % 11;
    }
}
