package Cryptography;

/**
 * <h1>Check Ten Digit Number</h1>
 * Takes a ten digit value and calculates an additional
 * 4 parity bits and appends them to the value.
 *
 * @author David Norton
 * @version 1.1
 * @since 29/09/2014
 */
public class BCH_Generator {
     
    /**
     * Calculates the first parity bit for (10,6).
     * 
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @return The first parity bit.
     */
    public static int getD7(int d1, int d2, int d3, int d4, int d5, int d6) {

        int d7 = (4 * d1 + 10 * d2 + 9 * d3 + 2 * d4 + d5 + 7 * d6) % 11;

        return d7;
    }
      
    /**
     * Calculates the second parity bit for (10,6).
     * 
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @return The second parity bit.
     */
    public static int getD8(int d1, int d2, int d3, int d4, int d5, int d6) {

        int d8 = (7 * d1 + 8 * d2 + 7 * d3 + d4 + 9 * d5 + 6 * d6) % 11;

        return d8;
    }
       
    /**
     * Calculates the third parity bit for (10,6).
     * 
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @return The third parity bit.
     */
    public static int getD9(int d1, int d2, int d3, int d4, int d5, int d6) {

        int d9 =  (9 * d1 + d2 + 7 * d3 + 8 * d4 + 7 * d5 + 7 * d6) % 11;

        return d9;
    }
        
    /**
     * Calculates the fourth parity bit for (10,6).
     * 
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @return The fourth parity bit.
     */
    public static int getD10(int d1, int d2, int d3, int d4, int d5, int d6) {

        int d10 = (d1 + 2 * d2 + 9 * d3 + 10 * d4 + 4 * d5 + d6) % 11;

        return d10;
    }
    
    /**
     * Calculates the first parity bit for (14,10).
     *
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @param d7 Calculated parity bit.
     * @param d8 Calculated parity bit.
     * @param d9 Calculated parity bit.
     * @param d10 Calculated parity bit.
     * @return The first parity bit.
     */
     public static int getFirstParityBit(int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int d10) {

        int s1 = (d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10) % 11;

        return s1;
    }

    /**
     * Calculates the first parity bit for (14,10).
     *
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @param d7 Calculated parity bit.
     * @param d8 Calculated parity bit.
     * @param d9 Calculated parity bit.
     * @param d10 Calculated parity bit.
     * @return The second parity bit.
     */
    public static int getSecondParityBit(int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int d10) {

        int s2 = (d1 + 2*d2 + 3*d3 + 4*d4 + 5*d5 + 6*d6 + 7*d7 + 8*d8 + 9*d9 + 10*d10) % 11;

        return s2;
    }

    /**
     * Calculates the first parity bit for (14,10).
     *
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @param d7 Calculated parity bit.
     * @param d8 Calculated parity bit.
     * @param d9 Calculated parity bit.
     * @param d10 Calculated parity bit.
     * @return The third parity bit.
     */
    public static int getThirdParityBit(int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int d10) {

        int s3 = (d1 + 4*d2 + 9*d3 + 5*d4 + 3*d5 + 3*d6 + 5*d7 + 9*d8 + 4*d9 + d10) % 11;

        return s3;
    }

    /**
     * Calculates the first parity bit for (14,10).
     *
     * @param d1 User input single digit number.
     * @param d2 User input single digit number.
     * @param d3 User input single digit number.
     * @param d4 User input single digit number.
     * @param d5 User input single digit number.
     * @param d6 User input single digit number.
     * @param d7 Calculated parity bit.
     * @param d8 Calculated parity bit.
     * @param d9 Calculated parity bit.
     * @param d10 Calculated parity bit.
     * @return The forth parity bit.
     */
    public static int getForthParityBit(int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int d10) {

        int s4 = (d1 + 8*d2 + 5*d3 + 9*d4 + 4*d5 + 7*d6 + 2*d7 + 6*d8 + 3*d9 + 10*d10) % 11;

        return s4;
    }

    /**
     * Checks if the final value is valid and prints the result.
     *
     * @param s1 First parity bit.
     * @param s2 Second parity bit.
     * @param s3 Third parity bit.
     * @param s4 Forth parity bit.
     * @param initialNumber Initial user input number.
     */
    public static String addParityBits(int s1, int s2, int s3, int s4, String initialNumber) {
            String finalValue = initialNumber + "" + s1 + "" + s2 + "" + s3 + "" +s4;
            return finalValue;
    }

}


