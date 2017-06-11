package assignments.assignment2;

import java.util.*;

/*******************************************************************************
 * Question  6 - Book  
 * Write the Java class called Book which is shown in the UML class 
 * diagram below.
 * 
 * •	All the instance data (properties) also have conventionally named 
 *      accessors & mutators (getters & setters) although these are not shown 
 *      in the diagram. 
 * 
 * •	The constructor is used to initialize the name property. 
 * 
 * •	The calcTotalValue method returns the total value of the stock 
 *      (i.e. price * number of items). 
 * 
 * You should write a driver class (with a main method) to test your 
 * class – but this will not be marked.


 *******************************************************************************

  Book
- name : String
- price : int
- number : int
+ Book(String)
+ calcTotalValue( ) : int

 *****************************************************************************/
public class Book {
  
    private String name; 
    private int price, number;
    
    public static void main (String[] args)
    {
        Book book1, book2;
        
        book1 = new Book("Harry Potter", 15, 5);
        book2 = new Book("Lord of the Rings", 12, 4);
         
        System.out.println("----------Books----------\n");
        System.out.println(book1);
        System.out.println(book2);
        
        System.out.println("-----Total Stock Value-----\n");
        System.out.println(book1.getName() + ":\t\t" + book1.calcTotalValue());
        System.out.println(book2.getName() + ":\t" + book2.calcTotalValue());
        System.out.println("");
        
               
    }
    //-------------------------------------------------------------------------
    // Constructor: Sets up this book object.
    //-------------------------------------------------------------------------
    public Book(String title, int value, int total) 
    {
        name = title;
        price = value;
        number = total;   
    }
    
    //-------------------------------------------------------------------------
    // calcTotalValue
    //-------------------------------------------------------------------------
    public int calcTotalValue() 
    {
        return price * number;
    }
    
    //-------------------------------------------------------------------------
    // Name getter
    //-------------------------------------------------------------------------
    public String getName() 
    {
        return name;
    }
    
    //-------------------------------------------------------------------------
    // Name setter
    //-------------------------------------------------------------------------
    public void setName(String title) 
    {
        name = title;
    }
    
    //-------------------------------------------------------------------------
    // Price getter
    //-------------------------------------------------------------------------
    public int getPrice() 
    {
        return price;
    }
    
    //-------------------------------------------------------------------------
    // Price setter
    //-------------------------------------------------------------------------
    public void setPrice(int value) 
    {
        price = value;
    }
    
    //-------------------------------------------------------------------------
    // Number getter
    //-------------------------------------------------------------------------
    public int getNumber() 
    {
        return number;
    }
    
    //-------------------------------------------------------------------------
    // Number setter
    //-------------------------------------------------------------------------
    public void setNumber(int total) 
    {
        number = total;
    }
        
    //-------------------------------------------------------------------------
    // toString
    //-------------------------------------------------------------------------
    public String toString() 
    {
        return "Name: " + name + "\nPrice: " + price + 
                "\nNumber: " + number + "\n";
        
    }
            
    }

