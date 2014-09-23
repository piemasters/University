package Cryptography.Week01;

/**
 * <h1>Lecture 01 Shared Methods</h1>
 * Any shared methods for lecture 01.
 *
 * @author David Norton
 * @version 1.1
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
}
