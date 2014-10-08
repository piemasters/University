package Cryptography.Week03;

import Cryptography.SharedMethods;
import Cryptography.Week02.CheckSixDigitNumber;
import Cryptography.Week02.CheckTenDigitNumber;

import java.util.Scanner;

/**
 * <h1>Lecture 03 - Implementing BHC(10,6)</h1>
 * Takes a 10 digit number and corrects up to
 * 2 errors,, or detects 3+ errors.
 *
 * @author David Norton
 * @version 1.0
 * @since 06/10/2014
 */
public class DecodeCheckSixDigitNumber {

    public static void main(String[] args) {

        int d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, s1, s2, s3, s4, p, q, r;
        String decodedValue, encodedInput;

        // Get valid encoded 10 digit value.
        //encodedInput = getEncodedInput();

        // Get invalid encoded 10 digit value.
        encodedInput = SharedMethods.getFixedLengthNumber(10);

        // Add number to int array
        int[] intArray = SharedMethods.addToArray(encodedInput);

        // Assign user input to variables
        d1 = intArray[0];
        d2 = intArray[1];
        d3 = intArray[2];
        d4 = intArray[3];
        d5 = intArray[4];
        d6 = intArray[5];
        d7 = intArray[6];
        d8 = intArray[7];
        d9 = intArray[8];
        d10 = intArray[9];

        // Get parity bits
        s1 = CheckTenDigitNumber.getFirstParityBit(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);
        s2 = CheckTenDigitNumber.getSecondParityBit(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);
        s3 = CheckTenDigitNumber.getThirdParityBit(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);
        s4 = CheckTenDigitNumber.getForthParityBit(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);

        if (s1 == 0 && s2 == 0 && s3 == 0 && s4 == 0) {
            decodedValue = encodedInput;
            System.out.println("Decoded Value: " + decodedValue);
            System.out.println("No Error");
        } else {
            Math.pow ( s2,2 );
            p = ((s2 * s2) - (s1 * s3))  % 11;
            q = ((s1 * s4) - (s2 * s3)) % 11;
            r = ((s3 * s3) - (s2 * s4)) % 11;
            //System.out.println("P: " + p + " Q: " + q + " R: " + r);

            if (p == 0 && q == 0 && r == 0) {

                System.out.println("Single Error");
                int position = s2/s1;
                int magnitude = s1;
                //System.out.println("Position: " + decodedValue);
                //sSystem.out.println("Decoded Value: " + decodedValue);

            }

        }

    }

    /**
     * Gets a valid or invalid 10 digit encoded
     * value from a user input 6 digit value.
     *
     * @return Encoded 10 digit value.
     */
    public static String getEncodedInput() {

        String encodedInput = "Unusable Number";

        do {

            // Get 6 digit user input and encode it to a 10 digit String.
            encodedInput = CheckSixDigitNumber.getTenDigitEncodedValue();
            System.out.println("Encoded Value: " + encodedInput);

        } while (encodedInput.equals("Unusable Number"));

        return encodedInput;
    }

}
