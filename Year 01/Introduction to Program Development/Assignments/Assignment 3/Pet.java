package assignments.assignment3;

import java.util.*;
import java.io.*;

/*******************************************************************************
 *
 * This exercise is based on Student and Address classes showing Aggregation 
 * in chapter 6 of Lewis and Loftus.
 * The toString( ) method of Pet will return a String with the 
 * animal's name (xxx), species (yyy) and age (zzz) in this format 
 * (including the final newline):
 * xxx (yyy) aged zzz
 * for example: 
 * Harry (otter) aged 13
 * 
 * You are advised to test your program using a driver/main class 
 * (c.f. StudentBody in Lewis and Loftus). 
 * 
 * Pet
 * - name : String
 * - species : String
 * - age : int
 * + Pet (String, String, int )
 * + toString( ) : String
 * 
 * Note that the Pet class has conventionally named getters and setters for
 * all properties.
 * 
 * Notes
 * •	An ArrayList is shown but you could use an array – assume a 
 * maximum of 10 pets.
 * o	This problem is MUCH easier using an ArrayList – read the API.
 * •	The method replacePet replaces an old pet (first argument) with a 
 * new pet (second argument). It does nothing if the old pet doesn't exist.
 * •	The method removePet returns true if the pet removed (else false).
 * •	 The oldest method should return null if there are no pets
 * o	This is the most difficult method – so ... pseudocode before you code
 * 
 *****************************************************************************/
public class Pet {

    private String name;
    private String species;
    private int age;

    //-------------------------------------------------------------------------
    // Constructor: Sets up Town object.
    //-------------------------------------------------------------------------
    public Pet(String called, String type, int old) {
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
    // Species getter
    //-------------------------------------------------------------------------
    public String getSpecies() {
        return species;
    }

    //-------------------------------------------------------------------------
    // Species setter
    //-------------------------------------------------------------------------
    public void setSpecies(String type) {
        species = type;
    }

    //-------------------------------------------------------------------------
    // Age getter
    //-------------------------------------------------------------------------
    public int getAge() {
        return age;
    }

    //-------------------------------------------------------------------------
    // Age setter
    //-------------------------------------------------------------------------
    public void setAge(int old) {
        age = old;
    }

    //-------------------------------------------------------------------------
    // toString
    //-------------------------------------------------------------------------
    public String toString() {
        return "Name: \t" + name + " Species: \t" + " Age: \t" + age;

    }
}
