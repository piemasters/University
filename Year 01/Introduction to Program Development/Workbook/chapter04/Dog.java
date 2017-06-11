package chapter04;

import java.util.Scanner;

/*******************************************************************************
 * Question  4.2 (page 228)     
 * Design and implement a class called Dog that contains instance data that
 * represents the dog's name and age. Define the Dog constructor to accept and
 * initialize instance data. Include getter and setter methods for the name and
 * age. Include a method to compute and return the age of the dog in 
 * "person years" (seven times the dogs age). Include a toString method that
 * returns a one-line description of the dog. Create a driver class called 
 * Kennel, whose main method instantiates and updates several Dog objects.
 ******************************************************************************/
//Dog
//===============
//- name: String
//- age: int
//===============
//+ setName(): String
//+ getName(): String
//+ setAge(int): int
//+ getAge(int): int
//+ humanYears(): int
//+ toString(): String
//+ Kennel - main method

public class Dog {

    private String name;
    private int age;
    
    //-------------------------------------------------------------------------
    // Kennel - instantiates and updates several Dog objects.
    //-------------------------------------------------------------------------
    
    public static void main (String[] args)
    {
        Dog dog1, dog2;
        int sum, humanSum;
        
        dog1 = new Dog("Bob", 8);
        dog2 = new Dog("Fred", 2);
        
        System.out.println(dog1);
        System.out.println(dog2);  
        
        //Rename Bob
        System.out.println("");
        System.out.println("Rename Bob:");
        dog1.setName("Bobington");
        System.out.println(dog1);
        
        //Rename Fred
        System.out.println("");
        System.out.println("Rename Fred:");
        dog2.setName("Freddington");
        dog2.getName();
        System.out.println(dog2);
        
        //Total Ages
        sum = dog1.getAge() + dog2.getAge();
        System.out.println("");
        System.out.println("Combined ages: " + sum);
        humanSum = dog1.personYears() + dog2.personYears();
        System.out.println("Combined Human ages: " + humanSum);
        
        
    }
    
    //-------------------------------------------------------------------------
    // Constructor: Sets up this Dog object.
    //-------------------------------------------------------------------------
    public Dog(String called, int years) 
    {
        name = called;
        age = years;
    }
    
    //-------------------------------------------------------------------------
    // Name accessor - allows world access to get the name.
    //-------------------------------------------------------------------------
    public String getName() 
    {
        return name;
    }
    
    //-------------------------------------------------------------------------
    // Name mutator - allows world to change the name.
    //-------------------------------------------------------------------------
    public void setName(String called) 
    {
        name = called;
    }
    
    //-------------------------------------------------------------------------
    // Age accessor - allows world access to get the age.
    //-------------------------------------------------------------------------
    public int getAge() 
    {
        return age;
    }
    
    //-------------------------------------------------------------------------
    // Age mutator - allows world to change the age.
    //-------------------------------------------------------------------------
    public void setAge(int years) 
    {
        age = years;
    }
    
    //-------------------------------------------------------------------------
    // personYears - Returns the age of the Dog in "person" years
    //-------------------------------------------------------------------------
    public int personYears() 
    {
        return age * 7;
    }
    
    //-------------------------------------------------------------------------
    // toString - Retrun a summary of the Dog as a string
    //-------------------------------------------------------------------------
    public String toString() 
    {
        return "Dog: " + name + ", Age: " + age + ", Person-Years: " 
                + personYears();
    }
            
    }
