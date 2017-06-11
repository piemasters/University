package chapter03;
import java.util.Scanner;

/*******************************************************************************
 * Question  3.1 (page 183)     
 * Write an application that prompts for and reads the user's name and password,
 * checks whether the password is strong or not, and prints the result.
 * A password is considered strong if the same four-letter sequence does not
 * occur in the given username or password. If this condition is not satisfied,
 * it is a weak password. Both the username and password should contain a
 * minimum of four characters each.
******************************************************************************/

public class Password01 {
     public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);
         String username, password;
         
         System.out.print("Please enter a Username: ");
         username = scan.next();
         System.out.print("Please enter a Password: ");
         password = scan.next();
         
         // check username + password have more than 4 characters in each
         int userLength = username.length();
         int passLength = password.length();
         
         System.out.println("Username and Password must have "
                 + "4 or more characters");
         System.out.println("Username is length: " + userLength);
         System.out.println("Password is length: " + passLength);

         // check if they contain an identical sequence of 4 characters.
         boolean strengthCheck = username.contentEquals(password);
         System.out.println("Password is weak?: " + strengthCheck);
         

     }
}
