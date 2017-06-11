package assignments.assignment2;

import java.util.*;

/*******************************************************************************
 * Question  2 - FileType   
 * FileType  program requests (as shown) and reads a list of file names 
 * (one per line). Program ends when a blank line is entered. If a file name 
 * ends With ".txt" then print "Text File: xxxx" where xxxx is the full file 
 * name. If the file name contains the string "del" print "Delete: xxxx". 
 * If the file satisfies both conditions just do the text file option. 
 * Otherwise do not print anything

 *******************************************************************************

 * While input doesn't equal ""
 *  Enter phrase
 *  if "txt" found in string
 *      printline "Text File: " + entered phrase
 *  elseif "del" found in string
 *      printline "Text File: " + entered phrase


 *****************************************************************************/
public class FileType {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String inputPhrase = "Blank";
        Boolean txt = false, del = false;

        System.out.println("Enter file names (blank line to end): ");

        while (inputPhrase.contentEquals("") == false) {

            inputPhrase = scan.nextLine();

            txt = inputPhrase.endsWith(".txt");
            del = inputPhrase.contains("del");
            
            if (txt == true) {
                System.out.println("Text File: " + inputPhrase);
            }
            else if (del == true) {
                System.out.println("Delete: " + inputPhrase);
            }
        }
        System.out.println("");
    }
}
