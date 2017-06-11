package chapter07;

import java.util.*;
import java.text.NumberFormat;

/*******************************************************************************
 * Question  7.2 (page 400)     
 * Modify the Student class presented in this chapter as follows.
 * Each student object should also contain the scores for three
 * tests. Provide a constructor that sets all instance vales based on
 * parameter values. Overload the constructor such that each test
 * score is assumed to be initially zero. Provide a method called
 * setTestScore that accepts two parameters: the test number
 * (1 through 3) and the score. Also provide a method called
 * getTestScore that accepts the test number and returns the
 * appropriate score. Provide a method called average that computes 
 * and returns the average test score for this student. Modify
 * the toString method such that the test scores and average are
 * included in the description of the student. Modify the driver class
 * main method to exercise the new Student methods.
 ******************************************************************************/

public class Student
{
   private String firstName, lastName;
   private Address homeAddress, schoolAddress;

   //-----------------------------------------------------------------
   //  Constructor: Sets up this student with the specified values.
   //-----------------------------------------------------------------
   public Student (String first, String last, Address home,
                   Address school)
   {
      firstName = first;
      lastName = last;
      homeAddress = home;
      schoolAddress = school;
   }

   //-----------------------------------------------------------------
   //  Returns a string description of this Student object.
   //-----------------------------------------------------------------
   public String toString()
   {
      String result;

      result = firstName + " " + lastName + "\n";
      result += "Home Address:\n" + homeAddress + "\n";
      result += "School Address:\n" + schoolAddress;

      return result;
   }
}