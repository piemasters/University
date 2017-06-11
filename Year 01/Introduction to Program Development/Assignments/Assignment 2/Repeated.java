package assignments.assignment2;

import java.util.*;

/*******************************************************************************
 * Question  5 - Repeated   
 * Write a Java program which asks the user to repeatedly enter lines of text. 
 * If a line is exactly equal to the previous line the program outputs: 
 *      Repeated: xxx
 * where xxxx is the repeated line.
 * The program will continue reading and processing until a blank line is 
 * entered. After reading the blank line the program will quit with the message:
 *      Farewell

 *******************************************************************************

 * "Please enter lines of text: "
 * While input doesn't equal ""
 *      OldPhase = EnteredPhrase
 *      EnteredPhrase = User input
 *      
 *      if EnteredPhrase = OldPhrase
 *          printline "Repeated: " + EnteredPhrase
 * }
 * Println : Farewell

 *****************************************************************************/
public class Repeated {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String inputPhrase = "Blank", tempPhrase = "";

        System.out.println("Please enter lines of text: ");

        while (inputPhrase.contentEquals("") == false) {

            tempPhrase = inputPhrase;
            inputPhrase = scan.nextLine();

            if (tempPhrase.equals(inputPhrase)) {
                System.out.println("Repeated: " + inputPhrase);
            } 
        }
        System.out.println("Farewell\n");
    }
}