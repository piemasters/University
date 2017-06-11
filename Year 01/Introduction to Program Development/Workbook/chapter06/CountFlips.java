package chapter06;

import java.util.*;

/*******************************************************************************
 * Question  6.6 (page 322)     
 * Using the Coin class defined in this chapter, design and implement 
 * a driver class called CountFlips whose main method flips a
 * coin 100 times and counts how many times each side comes up.
 * Print the results.
 ******************************************************************************/
public class CountFlips {

    private final int HEADS = 0;
    private final int TAILS = 1;
    private int face;

    public static void main(String[] args) {

        CountFlips coin1;
        int i = 0, heads = 0, tails = 0;

        coin1 = new CountFlips();


        do {
            coin1.flip();
            if (coin1.isHeads() == true) {
                heads += 1;
            } else {
                tails += 1;
            }
            i += 1;
        } while (i < 100);
        
        System.out.println("Flip the coin 100 times!");
        System.out.println("Number of heads: " + heads);
        System.out.println("Number of tails: " + tails);

    }
    //-----------------------------------------------------------------
    //  Sets up the coin by flipping it initially.
    //-----------------------------------------------------------------

    public CountFlips() {
        flip();
    }

    //-----------------------------------------------------------------
    //  Flips the coin by randomly choosing a face value.
    //-----------------------------------------------------------------
    public void flip() {
        face = (int) (Math.random() * 2);
    }

    //-----------------------------------------------------------------
    //  Returns true if the current face of the coin is heads.
    //-----------------------------------------------------------------
    public boolean isHeads() {
        return (face == HEADS);
    }

    //-----------------------------------------------------------------
    //  Returns the current face of the coin as a string.
    //-----------------------------------------------------------------
    public String toString() {
        String faceName;

        if (face == HEADS) {
            faceName = "Heads";
        } else {
            faceName = "Tails";
        }

        return faceName;
    }
}
