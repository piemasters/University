package chapter04;

import java.util.Scanner;

/*******************************************************************************
 * Question  4.6 (page 228)     
 * Design and implement a class called Flight that represents an airline flight.
 * It should contain instance data that represents the airlineName, 
 * flightNumber, origin and destination cities. Define the Flight constructor to 
 * accept and initialize all instance data. Include getter and setter 
 * methods for all instance data. Include a toString method that returns a
 * one-line description of the flight. Create a driver class called FlightTest, 
 * whose main method instantiates and updates several Flight objects.
 ******************************************************************************/
//flight
//===============
//- airlineName: String
//- flightNumber: int
//- origin: String
//- destination: String
//===============
//+ setAirlineName(): String
//+ getAirlineName(): String
//+ setFlightNumber(): int
//+ getFlightNumber(): int
//+ setOrigin(): String
//+ getOrigin(): String
//+ setDestination(): String
//+ getDestination(): String
//+ toString(): String
//+ FlightTest - main method

public class Flight {
  
    private String airlineName, origin, destination;
    private int flightNumber;
    
    public static void main (String[] args)
    {
        Flight flight1, flight2;
        
        flight1 = new Flight("EasyJet", 90842365, "England", "France");
        flight2 = new Flight("British Airways", 95895302, 
                "Spain", "Australia");
        
        System.out.println(flight1);
        System.out.println(flight2);
        
        //Change Flight1's
        System.out.println("\nUpdate flight 1's Flight Number\n");
        flight1.setFlightNumber(85403286);
        System.out.println(flight1);
        
        
    }
    //-------------------------------------------------------------------------
    // Constructor: Sets up this flight object.
    //-------------------------------------------------------------------------
    public Flight(String name, int number, String home, String away) 
    {
        airlineName = name;
        flightNumber = number;
        origin = home;
        destination = away;
        
    }
    
    //-------------------------------------------------------------------------
    // AirlineName getter
    //-------------------------------------------------------------------------
    public String getAirlineName() 
    {
        return airlineName;
    }
    
    //-------------------------------------------------------------------------
    // AirlineName setter
    //-------------------------------------------------------------------------
    public void setAirlineName(String name) 
    {
        airlineName = name;
    }
    
    //-------------------------------------------------------------------------
    // FlightNumber getter
    //-------------------------------------------------------------------------
    public int getFlightNumber() 
    {
        return flightNumber;
    }
    
    //-------------------------------------------------------------------------
    // FlightNumber setter
    //-------------------------------------------------------------------------
    public void setFlightNumber(int number) 
    {
        flightNumber = number;
    }
    
    //-------------------------------------------------------------------------
    // Origin getter
    //-------------------------------------------------------------------------
    public String getOrigin() 
    {
        return origin;
    }
    
    //-------------------------------------------------------------------------
    // Origin setter
    //-------------------------------------------------------------------------
    public void setOrigin(String home) 
    {
        origin = home;
    }
    
    //-------------------------------------------------------------------------
    // Destination getter
    //-------------------------------------------------------------------------
    public String getDestination() 
    {
        return destination;
    }
    
    //-------------------------------------------------------------------------
    // Destination setter
    //-------------------------------------------------------------------------
    public void setDestination(String away) 
    {
        destination = away;
    }
    
    //-------------------------------------------------------------------------
    // toString
    //-------------------------------------------------------------------------
    public String toString() 
    {
        return "Flight:\tAirline Name: " + airlineName + "\tFlight Number: " + 
                flightNumber + "\tOrigin: " + origin + "\tDestination Date: " 
                + destination;
    }
            
    }
