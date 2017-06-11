package Cryptography.Week02;

import Cryptography.SharedMethods;

/**
 * Created by David on 29/09/2014.
 */
public class ModularArithmetic {

    public static void main(String[] args) {

        // Get input values.
        int x = Integer.parseInt(SharedMethods.getVariableLengthNumber());
        int y = Integer.parseInt(SharedMethods.getVariableLengthNumber());

        // Calculate (x + y) mod 11
        int addResult = calcAddMod(x, y);

        // Calculate (x * y) mod 11
        int multiplyResult = calcMultiplyMod(x, y);

        // Calculate (x / y) mod 11
        int divideResult = calcDivideMod(x, y);

        // Print results
        printResults(x, y, addResult, multiplyResult, divideResult);

    }

    /**
     * Calculates the result of (x + y) mod 11.
     *
     * @param x First user input integer.
     * @param y Second user input integer.
     * @return Result of (x+y) mod 11.
     */
    private static int calcAddMod(int x, int y) {

        int addTemp = x + y;

        // Fixes negative numbers
        while ((addTemp) < 0) {
            addTemp += 11;
        }

        return addTemp % 11;
    }

    /**
     * Calculates the result of (x * y) mod 11.
     *
     * @param x First user input integer.
     * @param y Second user input integer.
     * @return Result of (x*y) mod 11.
     */
    private static int calcMultiplyMod(int x, int y) {

        int multiplyTemp = x * y;

        // Fixes negative numbers
        while (multiplyTemp < 0) {
            multiplyTemp += 11;
        }

        return multiplyTemp % 11;
    }

    /**
     * Calculates the result of (x / y) mod 11.
     *
     * @param x First user input integer.
     * @param y Second user input integer.
     * @return Result of (x/y) mod 11.
     */
    private static int calcDivideMod(int x, int y) {

        int divideTemp = x / y;

        // Fixes negative numbers
        while (divideTemp < 0) {
            divideTemp += 11;
        }

        return divideTemp % 11;
    }

    /**
     * Prints the calculated values of:
     * (x + y) mod 11
     * (x * y) mod 11
     * (x / y) mod 11
     *
     * @param x First user input integer.
     * @param y Second user input integer.
     * @param addResult  Result of (x+y) mod 11.
     * @param multiplyResult Result of (x*y) mod 11.
     * @param divideResult Result of (x/y) mod 11.
     */
    private static void printResults(int x, int y, int addResult, int multiplyResult, int divideResult) {
        System.out.println("(" + x + " + " + y + ") mod 11 = " + addResult);
        System.out.println("(" + x + " * " + y + ") mod 11 = " + multiplyResult);
        System.out.println("(" + x + " / " + y + ") mod 11 = " + divideResult);
    }

}
