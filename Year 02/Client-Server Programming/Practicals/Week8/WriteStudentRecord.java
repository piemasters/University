package year2.CSP.Week8;

import java.io.*;
import java.net.*;
import java.lang.*;

public class WriteStudentRecord {

    public static void main(String[] args)
            throws IOException {

// Create a student record object
        StudentRecord s = new StudentRecord("Jo");

//set the subject to “Computing”
        s.setSubject("Computing");

//create an ObjectOutptStream linked to ‘myFile”
        String fileName = "myFile";
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("src//year2//CSP//Week8//myFile.txt");
            out = new FileOutputStream("src//year2//CSP//Week8//myFile.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            //save or write the object to “myFile”
            oos.writeObject(s);
        } catch (Exception e) {
        }

    }
}
