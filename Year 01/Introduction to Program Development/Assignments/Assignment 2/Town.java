package assignments.assignment2;

import java.util.*;

/*******************************************************************************
 * Question  7 - Town  
Write the Java class called Town which is shown in the UML class diagram below. 
 * 
 * •	The first (default) constructor should instantiate a Town with a 
 *      population of 10000 and set the name to "AnyTown". 
 * 
 * •	The second constructor is used to instantiate an object with name and 
 *      population passed as parameters. 
 * 
 * •	The calcBiggest() method takes a single parameter (date type Town) and 
 * returns the Town with the largest population.
 * 
 * You should write a driver class (with a main method) to test your 
 * Town class – but this will not be marked.
 *******************************************************************************

Town
- name : String
- population : int
+ Town ( )
+ Town ( String, int ) 
+ getPopulation ( ) : int
+ setPopulation (int) : void
+ getName ( ) : String
+ setName ( String ) : void
+ calcBiggest( Town ) : Town

 *****************************************************************************/
public class Town {

    private String name;
    private int population;

    public static void main(String[] args) {
        
        Town town, smallTown, largeTown;
        
        town = new Town ("Guildford", 3000);
        smallTown = new Town ("Cranleigh", 1000);
        largeTown = new Town ("London", 2000);
        
        System.out.println("----------All Towns----------\n");
        
        System.out.println(town);
        System.out.println(smallTown);
        System.out.println(largeTown);
        System.out.println("-----------------------------\n");
        
        
        System.out.println("Is " + town.getName() + " or " + smallTown.getName() 
                + " the largest?\n");
        System.out.println(town.calcBiggest(smallTown));
                System.out.println("Is " + smallTown.getName() + " or " 
                        + largeTown.getName() + " the largest?\n");
        System.out.println(smallTown.calcBiggest(largeTown));

        
    }
    //-------------------------------------------------------------------------
    // Constructor: Sets up Town object.
    //-------------------------------------------------------------------------

    public Town() {
        population = 10000;
        name = "AnyTown";
    }

    //-------------------------------------------------------------------------
    // Constructor: Sets up Town object.
    //-------------------------------------------------------------------------
    public Town(String location, int number) {
        name = location;
        population = number;
    }

    //-------------------------------------------------------------------------
    // Population getter
    //-------------------------------------------------------------------------
    public int getPopulation() {
        return population;
    }

    //-------------------------------------------------------------------------
    // Population setter
    //-------------------------------------------------------------------------
    public void setPopulation(int number) {
        population = number;
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
    public void setName(String location) {
        name = location;
    }
    
    //-------------------------------------------------------------------------
    // calcTotalValue
    //-------------------------------------------------------------------------

    public Town calcBiggest(Town town) {
        if (town.getPopulation() > population) {
            return town;
        } else {
            return this;
        }
    }
    
    //-------------------------------------------------------------------------
    // toString
    //-------------------------------------------------------------------------
    public String toString() {
        return "Name: " + name + "\nLocation: " + population + "\n";

    }
}
