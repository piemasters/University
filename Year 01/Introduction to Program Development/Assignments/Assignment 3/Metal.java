package assignments.assignment3;

import java.util.*;
import java.io.*;

/*******************************************************************************
 *
 * Metal
 * - name : String
 * - costPerUnitWeight : int
 * + Metal(String, int )
 * + getName( ) : String
 * + setName(String) : void
 * + getCostPerUnitWeight( ) : int
 * + setCostPerUnitWeight (int) : void

 * In this system a type of product can be created from a particular metal 
 * and the total cost of the products metal (e.g Bronze) can be found from 
 * the weight of the product multiplied by the unit metal cost.
 * 
 * You are recommend to write a driver class (with a main method) to test 
 * your Product and Metal classes – but this will not be marked.
 * 
 *****************************************************************************/
public class Metal {

    private String name;
    private int costPerUnitWeight;

    //-------------------------------------------------------------------------
    // Constructor: Sets up Town object.
    //-------------------------------------------------------------------------
    public Metal(String called, int cpuw) {
    }
    
    //-------------------------------------------------------------------------
    // Name getter
    //-------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    //-------------------------------------------------------------------------
    // Name setter
    //-------------------------------------------------------------------------
    public void setName(String called) {
        name = called;
    }
    
    //-------------------------------------------------------------------------
    // CostPerUnitWeight getter
    //-------------------------------------------------------------------------
    public int getCostPerUnitWeight() {
        return costPerUnitWeight;
    }

    //-------------------------------------------------------------------------
    // CostPerUnitWeight setter
    //-------------------------------------------------------------------------
    public void setCostPerUnitWeight(int cpuw) {
        costPerUnitWeight = cpuw;
    }
}
