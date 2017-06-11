package assignments.assignment3;

import java.util.*;
import java.io.*;

/*******************************************************************************
 *
 *  Product
 * - type : String
 * - metal : Metal
 * - weight : int
 * + Product(String, Metal, int )
 * + getType( ) : String
 * + setType(String) : void
 * + getMetal( ) : Material
 * + setMetal (Material) : void
 * + getWeight( ) : int
 * + setWeight(int) : void
 * + calcMetalCost( ) : int
 * 
 * In this system a type of product can be created from a particular metal 
 * and the total cost of the products metal (e.g Bronze) can be found from 
 * the weight of the product multiplied by the unit metal cost.
 * 
 * You are recommend to write a driver class (with a main method) to test 
 * your Product and Metal classes – but this will not be marked.
 * 
 *****************************************************************************/
public class Product {

    private String type;
    private Metal metal;
    private int weight;

    //-------------------------------------------------------------------------
    // Constructor: Sets up Town object.
    //-------------------------------------------------------------------------
    public Product(String which, Metal element, int heavy) {
    }

    //-------------------------------------------------------------------------
    // Type getter
    //-------------------------------------------------------------------------
    public String getType() {
        return type;
    }

    //-------------------------------------------------------------------------
    // Type setter
    //-------------------------------------------------------------------------
    public void setType(String which) {
        type = which;
    }

    //-------------------------------------------------------------------------
    // Metal getter
    //-------------------------------------------------------------------------
    public Metal getMetal() {
        return metal;
    }

    //-------------------------------------------------------------------------
    // Metal setter
    //-------------------------------------------------------------------------
    public void setMetal(Metal element) {
        metal = element;
    }

    //-------------------------------------------------------------------------
    // Weight getter
    //-------------------------------------------------------------------------
    public int getWeight() {
        return weight;
    }

    //-------------------------------------------------------------------------
    // Weight setter
    //-------------------------------------------------------------------------
    public void setWeight(int heavy) {
        weight = heavy;
    }

    //-------------------------------------------------------------------------
    // calcMetalCost
    //-------------------------------------------------------------------------
    public int calcMetalCost() {
        int totalCost = weight * metal.getCostPerUnitWeight();
        return totalCost;
    }

}
