package General;

import Cryptography.Week04.SHA1;
import Cryptography.Week04.SHA1_Brute_Force;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by David on 20/08/2014.
 */
class HelloWorld {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        int[] test = convertToRadix(26, 27, 4);

        System.out.print(Arrays.toString(test));



    }

    private static int[] convertToRadix(int numOfPosChars, long currentCombo, int wordLength) {

        int[] indices = new int[wordLength];

        for (int i = wordLength - 1; i >= 0; i--) {

            System.out.print(Arrays.toString(indices));
            if (currentCombo > 0) {
                int rest = (int) (currentCombo % numOfPosChars);
                currentCombo /= numOfPosChars;
                indices[i] = rest;
            } else {
                indices[i] = 0;
            }
        }
        return indices;
    }
}
