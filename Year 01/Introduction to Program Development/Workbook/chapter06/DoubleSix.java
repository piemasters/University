package chapter06;

import java.util.*;

/*******************************************************************************
 * Question  6.5 (page 322)     
 * Using the PairOfDice class from PP4'1, design and implement
 * an application that rolls a pair of dice 1000 times, counting the
 * number of box cars (two sixes) that occur.
 ******************************************************************************/

public class DoubleSix {
    private final int MAX = 6;      // Maximum face value
    private int faceValue;          // Current value showing on the die
    
    //-------------------------------------------------------------------------
    // Creates two Die objects and rolls them several times.
    //-------------------------------------------------------------------------
    public static void main (String[] args)
    {
        DoubleSix die1, die2;
        int i = 0, count = 0;
        
        die1 = new DoubleSix();
        die2 = new DoubleSix();
        
        do {
        die1.roll();
        die2.roll();
        i = i + 1;
            
        if (die1.faceValue == 6 && die2.faceValue == 6) {
            count += 1;
        }
        
        } while (i <1000);
        
        System.out.println("Rolling both dice 1000 times.....");
        System.out.println("The total number of box cars (two sixes) are: " + count);
       
    }
    
    //-------------------------------------------------------------------------
    // Constructor: Sets the initial face value.
    //-------------------------------------------------------------------------
    public DoubleSix()
    {
        faceValue = 1;
    }
    
    //-------------------------------------------------------------------------
    // Rolls the die and returns the result.
    //-------------------------------------------------------------------------
    public int roll()
    {
        faceValue = (int)(Math.random() * MAX) + 1;
        
        return faceValue;
    }
    
    //-------------------------------------------------------------------------
    // Face value mutator.
    //-------------------------------------------------------------------------
    public void setFaceValue (int value)
    {
        faceValue = value;
    }
    
    //-------------------------------------------------------------------------
    //Face value accessor.
    //-------------------------------------------------------------------------
            public int getFaceValue()
    {
        return faceValue;
    }
            
   //-------------------------------------------------------------------------
   // Returns a string representation of this die.
   //-------------------------------------------------------------------------
   public String toString()
   {
       String result = Integer.toString(faceValue);
       
       return result;
   }
}
