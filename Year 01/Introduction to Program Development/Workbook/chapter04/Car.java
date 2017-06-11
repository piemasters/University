package chapter04;

import java.util.Scanner;

/*******************************************************************************
 * Question  4.3 (page 228)     
 * Design and implement a class called Car that contains instance data that 
 * represents the make, model, and year of the car. Define the Car constructor
 * to initialize these values.Include getter and setter methods for all instance
 * data, and a toString method that returns a one-line description of the car.
 * Create a driver class called CarTest, whose main method instantiates and 
 * updates several Car objects.
 ******************************************************************************/
//Car
//===============
//- make: String
//- model: String
//- year: String
//===============
//+ setMake(): String
//+ getMake(): String
//+ setModel(): String
//+ getModel(): String
//+ setYear(): String
//+ getYear(): String
//+ toString(): String
//+ CarTest - main method
public class Car {

    private String make, model, year;

    public static void main(String[] args) {
        Car car1, car2;

        car1 = new Car("Ford", "Escort", "2010");
        car2 = new Car("Honda", "Civic", "2003");

        System.out.println(car1);
        System.out.println(car2);

        //Rename car1
        System.out.println("");
        System.out.println("Update Car 1's Year:");
        car1.setYear("2011");
        car1.getYear();
        System.out.println(car1);
    }
    //-------------------------------------------------------------------------
    // Constructor: Sets up this Car object.
    //-------------------------------------------------------------------------

    public Car(String company, String version, String age) {
        make = company;
        model = version;
        year = age;
    }

    //-------------------------------------------------------------------------
    // Make getter
    //-------------------------------------------------------------------------
    public String getMake() {
        return make;
    }

    //-------------------------------------------------------------------------
    // Make setter
    //-------------------------------------------------------------------------
    public void setMake(String company) {
        make = company;
    }

    //-------------------------------------------------------------------------
    // Model getter
    //-------------------------------------------------------------------------
    public String getModel() {
        return model;
    }

    //-------------------------------------------------------------------------
    // Model setter
    //-------------------------------------------------------------------------
    public void setModel(String version) {
        model = version;
    }

    //-------------------------------------------------------------------------
    // Year getter
    //-------------------------------------------------------------------------
    public String getYear() {
        return year;
    }

    //-------------------------------------------------------------------------
    // Year setter
    //-------------------------------------------------------------------------
    public void setYear(String age) {
        year = age;
    }

    //-------------------------------------------------------------------------
    // toString
    //-------------------------------------------------------------------------
    public String toString() {
        return "Car:\t Make: " + make + "\tModel: " + model + "\tYear: " + year;
    }
}
