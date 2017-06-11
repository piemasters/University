package Cryptography.Week03;

import Cryptography.SharedMethods;
import Cryptography.Week02.BCH_Generator;
import Cryptography.Week02.Hamming_Generator;

/**
 * <h1>Lecture 03 - Implementing BHC(10,6)</h1>
 * Takes a 10 digit number and corrects up to
 * 2 errors,, or detects 3+ errors.
 *
 * @author David Norton
 * @version 1.0
 * @since 06/10/2014
 */
public class BCH_Decoder {

    public static void main(String[] args) {

        // Initialise Variables
        int d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, s1, s2, s3, s4, p = 0, q = 0, r = 0, i=0, j=0, a=0, b=0;
        int error = 10;
        String decodedValue, encodedInput;
        int[] intArray;

        // Get input
        encodedInput = getInput();

        // Add number to int array
        intArray = SharedMethods.addToArray(encodedInput);

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
        s1 = BCH_Generator.getFirstParityBit(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);
        s2 = BCH_Generator.getSecondParityBit(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);
        s3 = BCH_Generator.getThirdParityBit(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);
        s4 = BCH_Generator.getForthParityBit(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);

        // Check No Error
        if (s1 == 0 && s2 == 0 && s3 == 0 && s4 == 0) {
            error = 0;
        }

        // Check Single Error
        if (error != 0) {

            // Get P, Q & R
            p = getP(s1, s2, s3);
            q = getQ(s1, s2, s3, s4);
            r = getR(s2, s3, s4);

            // Check Single Error
            if (p == 0 && q == 0 && r == 0) {
                error = 1;
            }
        }

        // Check Double Error
        if (error != 0 && error != 1) {

            // Get Quadratic Equation Result
            int quadraticResult = getQuadraticResult(p, q, r);

            // Get i & j
            i = getI(p, q, quadraticResult);
            j = getJ(p, q, quadraticResult);

            // Get a & b
            b = getB(s1, s2, i, j);
            a = getA(s1, b);

            // Check Double or Larger Error
            if (i != 0 && j != 0 && quadraticResult != 0) {
                error = 2;
            } else {
                error = 3;
            }
        }

        //Output Result.
        outputResult(s1, s2, s3, s4, p, q, r, i, j, a, b, error, encodedInput, intArray);
    }

    /**
     * Gets an input value to be decoded.
     *
     * @return Encoded input
     */
    private static String getInput() {
        String encodedInput;// Get valid encoded 10 digit value.
        //encodedInput = getEncodedInput();

        // Get invalid encoded 10 digit value.
        //encodedInput = SharedMethods.getFixedLengthNumber(10);

        // No Errors
        //encodedInput = "3745195876";

        // Single Errors
        //encodedInput = "3945195876";
        //encodedInput = "3645195876";
        //encodedInput = "3745195877";


        // Double Errors
        //encodedInput = "8883880744";
        //encodedInput = "8899880747";
        //encodedInput = "3715195076";
        //encodedInput = "0743195876";
        //encodedInput = "3745195840";
        //encodedInput = "8745105876";
        //encodedInput = "3745102876";
        //encodedInput = "1145195876";
        //encodedInput = "3745191976";
        //encodedInput = "3745190872";
        //encodedInput = "0745195877";

        // Bigger Error
        encodedInput = "2745795878";
        //encodedInput = "3742102896";
        //encodedInput = "1115195876";
        //encodedInput = "3121195876";
        //encodedInput = "0888888074";

        return encodedInput;
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
            encodedInput = Hamming_Generator.getTenDigitEncodedValue();
            System.out.println("Encoded Value: " + encodedInput);

        } while (encodedInput.equals("Unusable Number"));

        return encodedInput;
    }

    /**
     * Gets the value of P
     *
     * @param s1 First syndrome.
     * @param s2 Second syndrome.
     * @param s3 Third syndrome.
     * @return P.
     */
    private static int getP(int s1, int s2, int s3) {

        int p = ((SharedMethods.getPowerX(s2)) - (s1 * s3))  % 11;
        while ( p < 0) {p += 11;}

        return p;
    }

    /**
     *  Gets the value of Q.
     * @param s1 First syndrome.
     * @param s2 Second syndrome.
     * @param s3 Third syndrome.
     * @param s4 Forth syndrome.
     * @return Q.
     */
    private static int getQ(int s1, int s2, int s3, int s4) {

        int q = ((s1 * s4) - (s2 * s3)) % 11;
        while ( q < 0) {q += 11;}

        return q;
    }

    /**
     * Gets the value of R.
     * @param s2 Second syndrome.
     * @param s3 Third syndrome.
     * @param s4 Forth syndrome.
     * @return R.
     */
    private static int getR(int s2, int s3, int s4) {

        int r = ((SharedMethods.getPowerX(s3)) - (s2 * s4)) % 11;
        while ( r < 0) {r += 11;}

        return r;
    }

    /**
     * Gets the value for i.
     *
     * @param p P.
     * @param q Q.
     * @param quadraticResult Quadratic result.
     * @return Value of I.
     */
    public static int getI(int p, int q, int quadraticResult) {

        // Get i Numerator
        int iNumerator = -q + quadraticResult;
        iNumerator = SharedMethods.getNegativeX(iNumerator);

        // Get Denominator
        int denominator = getDenominator(p);

        // Get i
        int i = (iNumerator * denominator) % 11;

        return i;
    }

    /**
     * Gets the value for j.
     *
     * @param p P.
     * @param q Q.
     * @param quadraticResult Quadratic result.
     * @return Value of J.
     */
    public static int getJ(int p, int q, int quadraticResult) {

        // Get j Numerator
        int jNumerator = -q - quadraticResult;
        jNumerator = SharedMethods.getNegativeX(jNumerator);

        // Get Denominator
        int denominator = getDenominator(p);

        // Get j
        int j = (jNumerator * denominator) % 11;

        return j;
    }

    /**
     * Get i & j denominator.
     * @param p P.
     * @return Denominator of i & j.
     */
    private static int getDenominator(int p) {

        int denominator = (2 * p) % 11;

        denominator = SharedMethods.getNegativePower(denominator);

        return denominator;
    }

    /**
     * Works out the quadratic equation needed for i & j.
     *
     * @param p P.
     * @param q Q.
     * @param r R.
     * @return Quadratic equation result.
     */
    private static int getQuadraticResult(int p, int q, int r) {
        //(- Q ± √(Q2-4*P*R)) / 2*P

        // (Q ^ 2) - (4 * P * R)
        int quadraticResult = (q * q) - (4 * p * r);

        // quadraticResult mod 11
        quadraticResult = quadraticResult % 11;
        quadraticResult = SharedMethods.getNegativeX(quadraticResult);

        // Square root result.
        quadraticResult = SharedMethods.sqrtX(quadraticResult);

        return quadraticResult;
    }

    /**
     * Get value of a.
     *
     * @param s1 First syndrome.
     * @param b B.
     * @return Value of a.
     */
    public static int getA(int s1, int b) {

        //a = s1 – b
        int a = (s1 - b);
        a = SharedMethods.getNegativeX(a);

        return a;
    }

    /**
     *
     * @param s1 First syndrome.
     * @param s2 Second syndrome.
     * @param i I.
     * @param j J.
     * @return Value of B.
     */
    public static int getB(int s1, int s2, int i, int j) {

        //b = (i*s1- s2) / (i - j)

        // Calculate Numerator
        int bNumerator = ((i*s1)- s2) % 11;
        bNumerator = SharedMethods.getNegativeX(bNumerator);

        // Calculate Denominator
        int bDenominator = (i - j);
        bDenominator = SharedMethods.getNegativeX(bDenominator);

        // Get b.
        int b = getPosition(bDenominator, bNumerator);

        return b;
    }

    /**
     * Gets the position of the incorrect bit.
     *
     * @param denominator Value denominator.
     * @param numerator Second syndrome.
     * @return Position of incorrect bit.
     */
    private static int getPosition(int denominator, int numerator) {

        // s2/s1 =8/5 = 8*5^-1 =8*9 = 6

        // Convert s1 to correct value (e.g. 5 -> 5^-1 -> 9).
        int newDenominator = SharedMethods.getNegativePower(denominator);

        // Multiple correct s1 & s2 values and mod 11.
        int position = (numerator * newDenominator) % 11;
        position = SharedMethods.getNegativeX(position);

        return position;
    }

    /**
     * Gets the correct value of an incorrect bit.
     *
     * @param intArray encodedInput in array form.
     * @param position Position of incorrect bit.
     * @param magnitude Magnitude of error.
     * @return Correct bit value.
     */
    public static int getCorrectBitValue (int[] intArray, int position, int magnitude) {

        // Incorrect bit - magnitude
        int tempArrayValue = intArray[position -1] - magnitude;

        // If result is less than 0 find matching positive value.
        tempArrayValue = SharedMethods.getNegativeX(tempArrayValue);

        // Mod result by 11.
        int correctBitValue = tempArrayValue % 11;

        return correctBitValue;
    }

    /**
     * Displays result when there are no errors
     * in the original encoded input.
     *
     * @param encodedInput Original encoded input.
     */
    public static void outputNoError(String encodedInput) {

        String decodedValue = encodedInput;

        System.out.println("\nEncoded Value: " + encodedInput);
        System.out.println("Decoded Value: " + decodedValue);
        System.out.println("No Error");
    }

    /**
     * Displays result when there is a single error
     * in the original encoded input.
     *
     * @param encodedInput Original encoded input.
     * @param s1 First syndrome.
     * @param s2 Second syndrome.
     * @param s3 Third syndrome.
     * @param s4 Forth syndrome.
     * @param intArray encodedInput in array form.
     */
    public static void outputSingleError(String encodedInput, int s1, int s2, int s3, int s4, int[] intArray) {

        // Get position & magnitude.
        int position = getPosition(s1, s2);
        int magnitude = s1;

        // Special case if position is 0 then there is more than 2 errors.
        if (position < 1 || position > 10) {
            outputLargeError(encodedInput, s1, s2, s3, s4, 0, 0, 0);

        } else {

            // Get correct bit value
            intArray[position - 1] = getCorrectBitValue(intArray, position, s1);

            // Convert array to String
            String decodedValue = SharedMethods.convertArrayToString(intArray);

            // Print Result
            System.out.println("\nEncoded Value: " + encodedInput);
            System.out.println("Decoded Value: " + decodedValue);
            System.out.print("Single Error | ");
            System.out.print("Position [i]: " + position + " | ");
            System.out.print("Magnitude [a]: " + magnitude + " | ");
            System.out.print("Syn (" + s1 + ", " + s2 + ", " + s3 + ", " + s4 + ")");
        }
    }

    /**
     * Displays result when there are two errors
     * in the original encoded input.
     *
     * @param s1 First syndrome.
     * @param s2 Second syndrome.
     * @param s3 Third syndrome.
     * @param s4 Forth syndrome.
     * @param p P.
     * @param q Q.
     * @param r R.
     * @param encodedInput Original encoded input.
     * @param intArray encodedInput in array form.
     * @param i I.
     * @param j J.
     * @param a A.
     * @param b B.
     */
    public static void outputDoubleError(int s1, int s2, int s3, int s4, int p, int q, int r,
                                         String encodedInput, int[] intArray, int i, int j, int a, int b) {

        // Get position & magnitude.
        String decodedValue;
        int position1 = i, magnitude1 = a ,position2 = j ,magnitude2 = b;


        // Special case if position is 0 then there is more than 2 errors.
        if ((position1 < 1 || position1 > 10) || (position2 < 1 || position2 > 10)) {
            outputLargeError(encodedInput, s1, s2, s3, s4, 0, 0, 0);

        } else {

            // Get correct bit value
            intArray[position1 - 1] = getCorrectBitValue(intArray, i, a);
            intArray[position2 - 1] = getCorrectBitValue(intArray, j, b);

            // Convert array to String
            decodedValue = SharedMethods.convertArrayToString(intArray);

            // Print Result
            System.out.println("\nEncoded Value: " + encodedInput);
            System.out.println("Decoded Value: " + decodedValue);
            System.out.print("Double Error | ");
            System.out.print("Position [i]: " + position1 + " | ");
            System.out.print("Magnitude [a]: " + magnitude1 + " | ");
            System.out.print("Position [j]: " + position2 + " | ");
            System.out.print("Magnitude [b]: " + magnitude2 + " | ");
            System.out.print("Syn (" + s1 + ", " + s2 + ", " + s3 + ", " + s4 + ") | ");
            System.out.println("pqr (" + p + ", " + q + ", " + r + ")");
        }
    }

    /**
     * Outputs an error when there are more
     * than two errors.
     *
     * @param encodedInput Original encoded input.
     * @param s1 First syndrome.
     * @param s2 Second syndrome.
     * @param s3 Third syndrome.
     * @param s4 Forth syndrome.
     * @param p P.
     * @param q Q.
     * @param r R.
     */
    public static void outputLargeError(String encodedInput, int s1, int s2, int s3, int s4, int p, int q, int r) {

        // Print Result
        System.out.println("\nEncoded Value: " + encodedInput);
        System.out.print("Large Error - No Square Root | ");
        System.out.print("Syn (" + s1 + ", " + s2 + ", " + s3 + ", " + s4 + ") | ");
        System.out.println("pqr (" + p + ", " + q + ", " + r + ")");
    }


    /**
     * Determines which set of results to output.
     *
     * @param s1 First syndrome.
     * @param s2 Second syndrome.
     * @param s3 Third syndrome.
     * @param s4 Forth syndrome.
     * @param p P.
     * @param q Q.
     * @param r R.
     * @param i I.
     * @param j J.
     * @param a A.
     * @param b B.
     * @param error How many errors.
     * @param encodedInput Original encoded input.
     * @param intArray encodedInput in array form.
     */
    public static void outputResult(int s1, int s2, int s3, int s4, int p, int q, int r, int i, int j, int a, int b, int error, String encodedInput, int[] intArray) {

        switch (error) {
            case 0:
                outputNoError(encodedInput);
                break;
            case 1:
                outputSingleError(encodedInput, s1, s2, s3, s4, intArray);
                break;
            case 2:
                outputDoubleError(s1, s2, s3, s4, p, q, r, encodedInput, intArray, i, j, a, b);
                break;
            case 3:
                outputLargeError(encodedInput, s1, s2, s3, s4, p, q, r);
            default:
                System.out.println("Something has gone wrong!");
        }
    }

}
