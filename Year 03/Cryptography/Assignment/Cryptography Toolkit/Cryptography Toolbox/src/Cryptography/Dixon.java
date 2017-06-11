package Cryptography;

import java.util.*;
import java.util.Map.Entry;

/**
 * <h1>Dixon Factorising</h1>
 * Determines the factors of an integer using the Dixon Factorisation method.
 *
 * @author David Norton
 * @version 1.2
 * @since 19/11/2014
 */
public class Dixon {

    /**
     * Finds the roots of n if the exist.
     *
     * @param n User input integer.
     * @return Roots if they exist
     */
    public static String dixon2(double n) {

        boolean found = false, repByBase = false,
                pair1Added = false, pair2Added = false;
        HashMap<Double, Double> pairs = new HashMap<>();
        Random randomGenerator = new Random();
        int[] factorBase = {2, 3, 5, 7};
        String result = "";

        // Get square root of n
        long a = (long) Math.ceil(Math.sqrt(n));

        // While roots not found
        while (!found) {

            // Set lower and higher bound of possible value for x and generate randomly
            long low = a + 1;
            long high = (long) n;
            long x = low + ((long) (randomGenerator.nextDouble() * (high - low)));
            //long x = 80;
            //System.out.println("x: " + x);

            // Get value for z
            double z = Math.sqrt((x * x) % n);

            // Check that z can be represented by a base in the array
            for (int i : factorBase) {
                // If log(base)z returns an integer, z can be represented by the base
                if (Math.floor(logOfBase(i, z)) == logOfBase(i, z)) {
                    repByBase = true;
                }
            }

            // If z can be represented by a base
            if (repByBase) {

                // Restore boolean to default for next loop
                repByBase = false;

                // Calculate exponents
                double exp1 = x + z;
                double exp2 = x - z;

                // If exponents are prime add to list
                if (isPrime(exp1)) {
                    pairs.put(z, exp2);
                    pair1Added = true;
                } else if (isPrime(exp2)) {
                    pairs.put(z, exp1);
                    pair2Added = true;
                }

                // If a pair was added.
                if (pair1Added || pair2Added) {

                    // Get pair from list and find GCD of exponent
                    double key = z;
                    double value = pairs.get(key);
                    double gcd = gcd(value, n);

                    // If exponent gcd is prime roots found
                    if (isPrime(gcd)) {
                        if (pair1Added) {
                            result = "Roots: " + (long) gcd + ", " + (long) exp1;
                        } else {
                            result = "Roots: " + (long) gcd + ", " + (long) exp2;
                        }
                        found = true;
                    } else {

                        // Check if found pair can be combined with previously found pair
                        for (Entry<Double, Double> entry : pairs.entrySet()) {

                            // Multiply x values and exponent values
                            double tempKeys = key * entry.getKey();
                            double tempValues = Math.sqrt(value * pairs.get(entry.getKey()));

                            // Get total of both plus & minus GCD values
                            double minGCD = gcd(tempKeys - tempValues, n);
                            double posGCD = gcd(tempKeys + tempValues, n);
                            double total = minGCD * posGCD;

                            // If calculated total equals n, then roots found
                            if (total == n) {
                                result = "Roots: " + (long) minGCD + ", " + (long) posGCD;
                                found = true;
                            }
                        }
                    }
                    // Restore booleans to default for next loop
                    pair1Added = false;
                    pair2Added = false;
                }
            }
        }
        return result;
    }

    public static double logOfBase(int base, double num) {
        return Math.log(num) / Math.log(base);
    }

    /**
     * Finds the roots of n if the exist in a different way to above. This way
     * removes the random selection and comparison of previously found pairs to
     * simplify the process, but takes longer to generate an answer.
     *
     * @param n User input integer.
     * @return Roots if they exist
     */
    public static String dixon(double n) {

        String answer = "Something went wrong";
        // Get square root of n
        long a = (long) Math.ceil(Math.sqrt(n));

        // For every factor (x) between a+1 & n
        for (long x = a + 1; x <= n; x++) {

            // Generate guess for y.
            double y = Math.sqrt((x * x) % n);

            // If guess is a square.
            if (isSquare(y) == true) {

                // Get x+y & x-y values and determine if prime.
                double xAdd = x + y;
                double xMin = x - y;

                boolean addIsPrime = isPrime(xAdd);
                boolean minIsPrime = isPrime(xMin);

                // If x + y is prime
                if (addIsPrime == true) {

                    // Check gcd of xMin is prime
                    double gcd = gcd(xMin, n);

                    // If gcd is prime
                    if (isPrime(gcd)) {
                        answer = "Roots: " + (long) gcd + ", " + (long) xAdd;
                        break;
                    }

                    // If x - y is prime
                } else if (minIsPrime == true) {

                    // Check gcd of xAdd is prime
                    double gcd = gcd(xAdd, n);

                    // If gcd is prime
                    if (isPrime(gcd)) {
                        answer = "Roots: " + (long) gcd + ", " + (long) xMin;
                        break;
                    }

                    // Neither options are prime
                } else {
                    answer = "Neither factor is prime";
                }
            }
        }
        return answer;
    }

    /**
     * Euclid's Algorithm. Calculates the greatest common denominator.
     *
     * @param a First number.
     * @param b Second number.
     * @return Greatest common denominator.
     */
    public static double gcd(double a, double b) {

        // Once gcd found return value, else recurse after modding values.
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /**
     * Determines if number is prime.
     *
     * @param n Integer to check..
     * @return If number is prime
     */
    public static boolean isPrime(double n) {

        // For each number up to half on n
        for (int i = 2; i <= n / 2; i++) {
            // If divisible by that number it isn't a prime
            if (n % i == 0) {
                return false;
            }
        }
        // Else it is a prime
        return true;
    }

    /**
     * Checks if guess is a square or not
     *
     * @param y Guessed integer for y.
     * @return If guessed value is an integer.
     */
    public static boolean isSquare(double y) {

        // Assign temp value to guess rounded up
        double yRounded = Math.ceil(y);

        // If guess is an integer, then it's a square.
        if ((y - yRounded) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Test class to compare algorithms
     *
     * @param args
     */
    public static void main(String args[]) {

        int a = 299;

        String result = dixon(a);
        System.out.println("Dixon 1: " + result);
        String result2 = dixon2(a);
        System.out.println("Dixon 2: " + result2);

    }
}
