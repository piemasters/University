package Cryptography;

/**
 * <h1>Fermat Factorising</h1>
 * Determines the factors of an integer
 * using the Fermat Factorisation method.
 *
 * @author David Norton
 * @version 1.2
 * @since 18/11/2014
 */
public class Fermat {
    
    /**
     * Calculates the first root.
     * 
     * @param n User input integer.
     * @return First root.
     */
    public static long calcR1(long n) {
        
        // Get square root of n
        long a = (long)Math.ceil(Math.sqrt(n));
        
        // Calculate bsq
        long bsq = a * a - n;
        
        // Loop until bsq is a perfect square
        while (!isSquare(bsq)) {
            a ++;
            bsq = a * a - n;
        }
        
        // Calculate firts root.
        long r1 = a - (long)Math.sqrt(bsq);
        
        return r1; 		
    }
    
    /**
     * Calculates the second root.
     * 
     * @param n User input integer.
     * @param r1 First root.
     * @return Second root.
     */
    public static long calcR2(long n, long r1) { 
        
        // Get second root
        long r2 = n / r1;
        
        return r2;
    }
    
    /**
     * Checks if bsq is a square or not
     * 
     * @param n User input integer.
     * @return If bsq is a square.
     */
    public static boolean isSquare(long n) {
        
        // Get square root of n
        long sqr = (long)Math.sqrt(n);
        
        // If sqrt of n / n(+1) multiplied by itself is n, then it's a square
        if (sqr * sqr == n || (sqr + 1) * (sqr + 1) == n) {
            return true;
        } else {
            return false;
        }
    }
    
}



