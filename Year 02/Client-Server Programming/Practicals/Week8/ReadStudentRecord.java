package year2.CSP.Week8;

import java.io.*;
import java.net.*;

public class ReadStudentRecord {

    public static void main(String[] args)
            throws IOException {

//create an ObjectInputStream linked to “myFile”
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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
//read the StudentRecord object from the myFile and assign it to a StudentRecord object reference.
            StudentRecord record = (StudentRecord) ois.readObject();
            System.out.print(record.toString());     
        } catch (Exception e) {
        }
    }
}
