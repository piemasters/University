package chapter04;

import java.util.Scanner;

/*******************************************************************************
 * Question  4.7 (page 229)     
 * Design and implement a class called Bulb that represents a light bulb that 
 * can be turned on and off. Create a driver class called Lights, whose main 
 * method instantiates and turns on some Bulb objects.
 ******************************************************************************/
//bulb
//===============
//- bulbStatus: boolean
//===============
//+ setBulbStatus(): Boolean
//+ getBulbStatus(): Boolean
//+ toString(): String
//+ Lights - main method

public class Bulb {
  
    private boolean bulbStatus;
    
    public static void main (String[] args)
    {
        Bulb bulb1, bulb2;
        
        bulb1 = new Bulb(false);
        bulb2 = new Bulb(true);
        
        System.out.println(bulb1);
        System.out.println(bulb2);
        
        //Change bulb1's depth
        System.out.println("");
        System.out.println("Turn Bulb 1 On:");
        bulb1.setBulbStatus(true);
        System.out.println(bulb1);
        System.out.println(bulb2);
        
    }
    //-------------------------------------------------------------------------
    // Constructor: Sets up this bulb object.
    //-------------------------------------------------------------------------
    public Bulb(boolean lightOn) 
    {
        bulbStatus = lightOn;  
    }
    
    //-------------------------------------------------------------------------
    // BulbStatus getter
    //-------------------------------------------------------------------------
    public boolean getBulbStatus() 
    {
        return bulbStatus;
    }
    
    //-------------------------------------------------------------------------
    // BulbStatus setter
    //-------------------------------------------------------------------------
    public void setBulbStatus(boolean lightOn) 
    {
        bulbStatus = lightOn;
    }
    
    //-------------------------------------------------------------------------
    // toString
    //-------------------------------------------------------------------------
    public String toString() 
    {
        return "Bulb:\t On?: " + bulbStatus;
    }
            
    }
