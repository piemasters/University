package chapter05;

import java.util.*;

/*******************************************************************************
 * Question  5.6 (page 290)     
 * Using the FlipRace class defined in this chapter, design and implement a driver 
 * class called FlipRace whose main method creates two FlipRace objects, then 
 * continually flips them both to see which coin first comes up heads three 
 * flips in a row. Continue flipping the coins until one of the coins wins the 
 * race, and consider the possibility that they might tie. Print the results of 
 * each turn, and at the end print the winner and total number of flips that 
 * were required.
 ******************************************************************************/
public class FlipRace {

    //################ Global Variables ##################
    Scanner scan = new Scanner(System.in);
    private final int HEADS = 0;
    private final int TAILS = 1;
    private int face;
    //####################################################

    public static void main(String[] args) {

        //##### Set up Objects, Arrays and Variables #####
        FlipRace myCoin = new FlipRace();
        FlipRace hisCoin = new FlipRace();

        ArrayList<Integer> myRolls = new ArrayList<Integer>();
        ArrayList<Integer> hisRolls = new ArrayList<Integer>();

        int myCount = 0, hisCount = 0;
        int totalFlips = 0;

        //################################################
        
        System.out.println("The first to flip three heads in a row wins!");
        System.out.println("Flipping.....\n");
        
        //###### Roll each dice till a head is flipped 3 times in a row #######

        while (myCount < 3 && hisCount < 3) {

            totalFlips = totalFlips + 1;

            //--------MyFlip----------
            myCoin.flip();
            myCoin.flip();
            myRolls.add(myCount);

            if (myCoin.isHeads()) {
                myCount = myCount + 1;
            } else {
                myCount = 0;
            }
            //-------------------------
            
            //--------HisFlip----------
            hisCoin.flip();
            hisRolls.add(hisCount);

            if (hisCoin.isHeads()) {
                hisCount = hisCount + 1;
            } else {
                hisCount = 0;
            }
            //-------------------------
        }

        //######################################################################
        
        // ##### Add last roll to array ######
       
        myRolls.add(myCount);
        hisRolls.add(hisCount);
        
        //####################################

        //############## Determine winner ###############
        
        if (myCount > hisCount) {
            System.out.println("My coin wins!");
        } else if (myCount < hisCount) {
            System.out.println("His coin wins!");
        } else {
            System.out.println("It was a tie!");
        }
        
        //###############################################

        System.out.println("\nTotal number of flips: " + totalFlips);
        System.out.println("My Results: " + myRolls);
        System.out.println("His Results: " + hisRolls);
    }

    //-----------------------------------------------------------------
    //  Sets up the coin by flipping it initially.
    //-----------------------------------------------------------------
    public FlipRace() {
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
