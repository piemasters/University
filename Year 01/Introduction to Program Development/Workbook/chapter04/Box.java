package chapter04;

import java.util.Scanner;

/*******************************************************************************
 * Question  4.4 (page 228)     
 * Design and implement a class called Box that contains instance data that 
 * represents the height, width and depth of the box. Also include a boolean 
 * variable called full as instance data that represents whether the box is full 
 * or not. Define the Box constructor to initialize the height, width and depth 
 * of the box. Each newly created Box is empty (the constructor should 
 * initialize full to false). Include getter and setter methods for all instance
 * data. Include a toString method that returns a one-line description of the 
 * box. Create a driver class called BoxTest, whose main method instantiates and 
 * updates several Box objects.
 ******************************************************************************/
//box
//===============
//- height: int
//- width: int
//- depth: int
//- full: boolean
//===============
//+ setHeight(): int
//+ getHeight(): int
//+ setWidth(): int
//+ getWidth(): int
//+ setDepth(): int
//+ getDepth(): int
//+ toString(): String
//+ BoxTest - main method

public class Box {
  
    private int height, width, depth;
    private boolean full;
   
    public static void main (String[] args)
    {
        Box box1, box2;
        
        box1 = new Box(1, 2, 3, false);
        box2 = new Box(4, 5, 6, false);
        
        Scanner scan = new Scanner(System.in);
        boolean scannedValue = false;
        
        System.out.println(box1);
        System.out.println(box2);
        
        //Change box1's depth
        System.out.println("");
        System.out.println("Updating Box 1's Depth to fill it...");
        box1.setDepth(1);
        //Fill box 1
        box1.full = true;
                
        
        //Fill box 2
        System.out.print("Set if box is full (true/false): ");
               
        scannedValue = scan.nextBoolean();
        box2.full = scannedValue;
        System.out.println("");
        
        System.out.println("Updated Box Values...");
        
        System.out.println(box1);
        System.out.println(box2);
  
        
    }
    //-------------------------------------------------------------------------
    // Constructor: Sets up this box object.
    //-------------------------------------------------------------------------
    public Box(int h, int w, int d, boolean filled) 
    {
        height = h;
        width = w;
        depth = d;
        full = filled;
        full = false;
        
    }
    
    //-------------------------------------------------------------------------
    // Height getter
    //-------------------------------------------------------------------------
    public int getHeight() 
    {
        return height;
    }
    
    //-------------------------------------------------------------------------
    // Height setter
    //-------------------------------------------------------------------------
    public void setHeight(int h) 
    {
        height = h;
    }
    
    //-------------------------------------------------------------------------
    // Width getter
    //-------------------------------------------------------------------------
    public int getWidth() 
    {
        return width;
    }
    
    //-------------------------------------------------------------------------
    // Width setter
    //-------------------------------------------------------------------------
    public void setWidth(int w) 
    {
        width = w;
    }
    
    //-------------------------------------------------------------------------
    // Depth getter
    //-------------------------------------------------------------------------
    public int getDepth() 
    {
        return depth;
    }
    
    //-------------------------------------------------------------------------
    // Depth setter
    //-------------------------------------------------------------------------
    public void setDepth(int d) 
    {
        depth = d;
    }
    
    //-------------------------------------------------------------------------
    // toString
    //-------------------------------------------------------------------------
    public String toString() 
    {
        return "Box:\t Height: " + height + "\tWidth: " + width + "\tDepth: " 
                + depth + "\tFull: " + full;
    }
            
    }
