package Cryptography;

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

    /**
     * Gets the value of P
     *
     * @param s1 First syndrome.
     * @param s2 Second syndrome.
     * @param s3 Third syndrome.
     * @return P.
     */
    public static int getP(int s1, int s2, int s3) {

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
    public static int getQ(int s1, int s2, int s3, int s4) {

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
    public static int getR(int s2, int s3, int s4) {

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
    public static int getDenominator(int p) {

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
    public static int getQuadraticResult(int p, int q, int r) {
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
    public static int getPosition(int denominator, int numerator) {

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
    public static String outputNoError(String encodedInput) {

        String decodedValue = encodedInput;

        String result = "Encoded Value: " + encodedInput 
                + "\nDecoded Value: " + decodedValue 
                + "\nNo Error";
        
        return result;
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
    public static String outputSingleError(String encodedInput, int s1, int s2, int s3, int s4, int[] intArray) {

        // Get position & magnitude.
        String result;
        int position = getPosition(s1, s2);
        int magnitude = s1;

        // Special case if position is 0 then there is more than 2 errors.
        if (position < 1 || position > 10) {
            result = outputLargeError(encodedInput, s1, s2, s3, s4, 0, 0, 0);
            return result;
        } else {

            // Get correct bit value
            intArray[position - 1] = getCorrectBitValue(intArray, position, s1);

            // Convert array to String
            String decodedValue = SharedMethods.convertArrayToString(intArray);

            // Print Result
            result = "Encoded Value: " + encodedInput
                    + "\nDecoded Value: " + decodedValue
                    + "\nSingle Error | "
                    + "Position [i]: " + position + " | "
                    + "Magnitude [a]: " + magnitude
                    + "\nSyn (" + s1 + ", " + s2 + ", " + s3 + ", " + s4 + ")";
            
            return result;
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
    public static String outputDoubleError(int s1, int s2, int s3, int s4, int p, int q, int r,
                                         String encodedInput, int[] intArray, int i, int j, int a, int b) {

        // Get position & magnitude.
        String result;
        String decodedValue;
        int position1 = i, magnitude1 = a ,position2 = j ,magnitude2 = b;


        // Special case if position is 0 then there is more than 2 errors.
        if ((position1 < 1 || position1 > 10) || (position2 < 1 || position2 > 10)) {
            result = outputLargeError(encodedInput, s1, s2, s3, s4, 0, 0, 0);
            return result;
        } else {

            // Get correct bit value
            intArray[position1 - 1] = getCorrectBitValue(intArray, i, a);
            intArray[position2 - 1] = getCorrectBitValue(intArray, j, b);

            // Convert array to String
            decodedValue = SharedMethods.convertArrayToString(intArray);
            
            // Print Result
            result = "Encoded Value: " + encodedInput
                    + "\nDecoded Value: " + decodedValue
                    + "\nDouble Error"
                    + "\nPosition [i]: " + position1 + " | "
                    + "Magnitude [a]: " + magnitude1
                    + "\nPosition [j]: " + position2 + " | "
                    + "Magnitude [b]: " + magnitude2
                    + "\nSyn (" + s1 + ", " + s2 + ", " + s3 + ", " + s4 + ")"
                    + "\npqr (" + p + ", " + q + ", " + r + ")";
            
            return result;
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
    public static String outputLargeError(String encodedInput, int s1, int s2, int s3, int s4, int p, int q, int r) {

        // Print Result
        String result = "Encoded Value: " + encodedInput
                + "\nLarge Error - No Square Root"
                + "\nSyn (" + s1 + ", " + s2 + ", " + s3 + ", " + s4 + ")"
                + "\npqr (" + p + ", " + q + ", " + r + ")";
                
        return result;
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
    public static String outputResult(int s1, int s2, int s3, int s4, int p, int q, int r, int i, int j, int a, int b, int error, String encodedInput, int[] intArray) {

        String result;
        
        switch (error) {
            case 0:
                result = outputNoError(encodedInput);
                break;
            case 1:
                result = outputSingleError(encodedInput, s1, s2, s3, s4, intArray);
                break;
            case 2:
                result = outputDoubleError(s1, s2, s3, s4, p, q, r, encodedInput, intArray, i, j, a, b);
                break;
            default:
                result = outputLargeError(encodedInput, s1, s2, s3, s4, p, q, r);
        }
        return result;
    }

}
