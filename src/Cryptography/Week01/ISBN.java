package Cryptography.Week01;

import Cryptography.SharedMethods;

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
public class ISBN {

    public static void main(String[] args) {

        // Get ISBN number
        String isbn = getISBN();

        // Remove Symbols
        String isbnFormat = removeSymbols(isbn);

        // Add ISBN to int array
        int[] intArray = SharedMethods.addToArray(isbnFormat);

        // Multiply ISBN values
        int ISBNTotal = multiplyISBNValues(intArray);

        // Mod ISBN Total
        int ISBNMod = modISBNTotal(ISBNTotal);

        // Get last Element Value
        int isbnLastElement = intArray[isbnFormat.length() - 1];

        // Check if ISBN is valid
        checkIfISBNIsValid(ISBNMod, isbnLastElement);

    }

    /**
     * Gets an ISBN number from the user.
     *
     * @return ISBN User inputted ISBN number.
     */
    private static String getISBN() {

        Scanner scan = new Scanner(System.in);
        boolean validInput = false;
        String isbn = "";

        // Ensure input is valid.
        while (!validInput) {

            System.out.print("Enter an ISBN (e.g. 0-19-853287-3): ");
            isbn = scan.nextLine();

            // If characters are correct
            if (isbn.matches("([0-9]+-?)+")) {

                // If length is correct
                if (isbn.length() == 10 || isbn.length() == 13) {
                    validInput = true;
                } else {
                    System.out.print("Invalid input. Ensure the value contains 10 numbers.\n");
                }

            } else {
                System.out.print("Invalid input. Contains incorrect characters\n");
            }

        }

        return isbn;
    }

    /**
     * Formats the ISBN number to remove the -'s.
     *
     * @param isbn User inputted ISBN number.
     * @return ISBN value with -'s removed.
     */
    private static String removeSymbols(String isbn) {
        return isbn.replaceAll("-", "");
    }

    /**
     * Uses the formula (d1 + 2d2 + 3d3 + …+ 9d9) to multiply each
     * value of the ISBN number.
     *
     * @param intArray int array of ISBN values.
     * @return ISBN values totaled.
     */
    private static int multiplyISBNValues(int[] intArray) {

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
    private static int modISBNTotal(int ISBNTotal) {
        return ISBNTotal % 11;
    }

    /**
     * Checks that the ISBN is valid.
     *
     * @param ISBNMod Mod value of totaled ISBN values.
     * @param isbnLastElement Check bit of the ISBN.
     */
    private static void checkIfISBNIsValid(int ISBNMod, int isbnLastElement) {

        if (ISBNMod == isbnLastElement) {
            System.out.println("------------------");
            System.out.println("The ISBN is valid.");
            System.out.println("------------------");
        } else {
            System.out.println("----------------------");
            System.out.println("The ISBN is not valid.");
            System.out.println("----------------------");
        }
    }
}
