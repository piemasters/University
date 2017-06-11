package assignments.assignment3;

import java.util.*;
import java.io.*;

/*******************************************************************************
 *
 * Program Name : NumbersInFile.java
 * Example Output/Input: 	
 * 
 * Enter location of input file:
 * C:/stuff/words.txt
 * 17 7
 * 
 * This is a main/driver class which reads the location of an input file which 
 * contains multiple lines with a mixture of words and numbers. The program 
 * reads this file and outputs:
 * • The sum of any integers in the file
 * • The number of words which are not integers
 * 
 * For example- if the file above (words.txt) contained:
 * seven 5 7 more roger out 6 jam
 * one 1 two -2
 * output would be as shown above.
 * HINTS: 
 * • Understand the URLDissector example
 * • Read the Scanner API ...e.g. methods next??? and hasNext???
 * 
 *****************************************************************************/
public class NumbersInFile {

    public static void main(String[] args) throws FileNotFoundException {

        String fileName, contents;
        int numCount = 0, numTotal = 0, wordCount = 0;

        Scanner scan = new Scanner(System.in);
        Scanner contentsScan = new Scanner(System.in);

        // ------------Enter File Name -----------------------
        System.out.println("Enter location of input file:");

        fileName = scan.nextLine();
        //fileName = "C:/Users/David/Downloads/java.txt";
        Scanner fileScan = new Scanner(new File(fileName));
        //----------------------------------------------------

        while (fileScan.hasNext()) {
            contents = fileScan.nextLine();
            contentsScan = new Scanner(contents);
            contentsScan.useDelimiter(" ");

            //---------- Count the number of words --------------
            StringTokenizer st = new StringTokenizer(contents);
            while (st.hasMoreTokens()) {

                //--------------- Count Numbers ---------------
                if (contentsScan.hasNextInt()) {
                    numCount = contentsScan.nextInt();
                    numTotal = numTotal + numCount;
                } else {
                    String holder = contentsScan.next();
                }
                //---------------------------------------------

                //-------------- Count Words ------------------
                contents = st.nextToken();
                try {
                    Integer.parseInt(contents);
                } catch (NumberFormatException e) {
                    wordCount += 1;
                }
                //---------------------------------------------
            }
        }
        //------------------- Print Results-----------------------
        System.out.print(numTotal + " ");
        System.out.println(wordCount);
        System.out.println("");
        //--------------------------------------------------------
    }
}