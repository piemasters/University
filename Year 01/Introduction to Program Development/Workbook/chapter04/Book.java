package chapter04;

import java.util.Scanner;

/*******************************************************************************
 * Question  4.5 (page 228)     
 * Design and implement a class called Book that contains instance data that 
 * represents the title, author, publisher and copyright date. Define the Book 
 * constructor to accept and initialize this data. Include getter and setter 
 * methods for all instance data. Include a toString method that returns a
 * multi-line description of the book. Create a driver class called Bookshelf, 
 * whose main method instantiates and updates several Book objects.
 ******************************************************************************/
//book
//===============
//- title: String
//- author: String
//- publisher: String
//- copyright: String
//===============
//+ setTitle(): String
//+ getTitle(): String
//+ setAuthor(): String
//+ getAuthor(): String
//+ setPublisher(): String
//+ getPublisher(): String
//+ setCopyright(): String
//+ getCopyright(): String
//+ toString(): String
//+ BookTest - main method

public class Book {
  
    private String title, author, publisher, copyright;
    
    public static void main (String[] args)
    {
        Book book1, book2;
        
        book1 = new Book("Harry Potter", "J.K Rowling", "Bloomsbury", "1997");
        book2 = new Book("Lord of the Rings", "J.R.R Tolkien", 
                "Geo. Allen & Unwin", "1954");
        
        System.out.println(book1);
        System.out.println(book2);
        
        //Change Book1's
        System.out.println("Update book 1's Title\n");
        book1.setTitle("Harry Potter & The Chamber of Secrets");
        book1.setCopyright("1999");
        System.out.println(book1);
        
        
    }
    //-------------------------------------------------------------------------
    // Constructor: Sets up this book object.
    //-------------------------------------------------------------------------
    public Book(String name, String writer, String company, String date) 
    {
        title = name;
        author = writer;
        publisher = company;
        copyright = date;
        
    }
    
    //-------------------------------------------------------------------------
    // Title getter
    //-------------------------------------------------------------------------
    public String getTitle() 
    {
        return title;
    }
    
    //-------------------------------------------------------------------------
    // Title setter
    //-------------------------------------------------------------------------
    public void setTitle(String name) 
    {
        title = name;
    }
    
    //-------------------------------------------------------------------------
    // Author getter
    //-------------------------------------------------------------------------
    public String getAuthor() 
    {
        return author;
    }
    
    //-------------------------------------------------------------------------
    // Author setter
    //-------------------------------------------------------------------------
    public void setAuthor(String writer) 
    {
        author = writer;
    }
    
    //-------------------------------------------------------------------------
    // Publisher getter
    //-------------------------------------------------------------------------
    public String getPublisher() 
    {
        return publisher;
    }
    
    //-------------------------------------------------------------------------
    // Publisher setter
    //-------------------------------------------------------------------------
    public void setPublisher(String company) 
    {
        publisher = company;
    }
    
    //-------------------------------------------------------------------------
    // Copyright getter
    //-------------------------------------------------------------------------
    public String getCopyright() 
    {
        return copyright;
    }
    
    //-------------------------------------------------------------------------
    // Copyright setter
    //-------------------------------------------------------------------------
    public void setCopyright(String date) 
    {
        copyright = date;
    }
    
    //-------------------------------------------------------------------------
    // toString
    //-------------------------------------------------------------------------
    public String toString() 
    {
        return "Book:\nTitle: " + title + "\nAuthor: " + author + 
                "\nPublisher: " + publisher + "\nCopyright Date: " + copyright
                + "\n";
    }
            
    }
