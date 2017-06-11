package Cryptography;

import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * <h1>Lecture 04 SHA1 Brute Force</h1>
 * Brute forces a generated SHA1 value.
 *
 * @author David Norton
 * @version 1.2
 * @since 14/10/2014
 */

public class SHA1_Brute_Force_v2 {

    static char charSet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9'};
    static String answer = "";
    static final int MAX_WORD_LENGTH = 8;
    static final int CHARSETLENGTH = charSet.length;

    /**
     * Generates all password possibilities for the given word length
     * and checks each to see if it matches the hash.
     *
     * @param wordLength The word length currently being checked.
     * @param charSet The set of possible characters.
     * @param encodedHash The hash to test against.
     * @return The matched word if it exists.
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static boolean generate(int wordLength, char[] charSet, String encodedHash)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {

        // Total number of combinations for the word length.
        final long MAX_WORDS = (long) Math.pow(CHARSETLENGTH, wordLength);

        // For the number of possible combinations.
        for (long currentCombo = 0; currentCombo < MAX_WORDS; currentCombo++) {

            // Calculate int values of characters in each position. e.g. [0, 0, 1, 1].
            int[] indices = getCharSetPositions(CHARSETLENGTH, currentCombo, wordLength);

            // Check to see if there are exactly 2 numbers.
            int counter = 0;
            for(int i=0; i < indices.length; i++){
                if (indices[i] > 25) {
                    counter ++;
                }
            }

            // If there are two numbers run as normal.
            if (counter == 2) {

                // Create array 'word' the length of the word length currently being tested.
                char[] word = new char[wordLength];

                // For each char position, assign the corresponding character in 'charSet' to the int value in 'indices'.
                for (int charPosition = 0; charPosition < wordLength; charPosition++) {
                    word[charPosition] = charSet[indices[charPosition]];
                }

                // Convert character array to String to test.
                String possiblePassword = new String(word);

                // Print out current word  - TEST LINE
                //System.out.print(possiblePassword + ", ");

                // Compare encrypted possible solution with the encoded hash.
                if (compare(SHA1.SHA1(possiblePassword), encodedHash)) {
                    answer = possiblePassword;
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     *
     * @param charSetLength Number of possible characters.
     * @param currentCombo The combination currently being tested.
     * @param wordLength The word length currently being checked.
     * @return Integer values of the chars in the charSet to test.
     */
    public static int[] getCharSetPositions(int charSetLength, long currentCombo, int wordLength) {

        // Set array for length of word
        int[] indices = new int[wordLength];

        // For the number of characters in the word
        for (int i = wordLength - 1; i >= 0; i--) {

            // If left most character is unchanged (a) set to 0.
            if (currentCombo == 0) {
                indices[i] = 0;
            } else {
                /* Finds the char position value using mod as counter goes above charSet length.
                /* e.g. 36 = 1, 37 = 2 etc.*/
                int position = (int) (currentCombo % charSetLength);
                indices[i] = position;

                /* CurrentCombo counts the number of changes made to the selected position.
                 * As there are 35 characters, for a 2 char word the currentCombo calculates as follows:
                 * [0, 34], [0, 35], [1, 36], [1, 37].
                 * Dividing the right side results in the correct value for the left. */
                currentCombo /= charSetLength;
            }
        }
        return indices;
    }

    /**
     * If string are the same return true, else return false.
     *
     * @param possiblePassword Test password.
     * @param encodedHash Encoded hash value.
     * @return If test value matches hash value.
     */
    public static boolean compare(String possiblePassword, String encodedHash) {

        if (encodedHash.contains(possiblePassword))
            return true;
        else {
            return false;
        }
    }

}