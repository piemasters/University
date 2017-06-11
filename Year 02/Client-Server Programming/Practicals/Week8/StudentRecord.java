package year2.CSP.Week8;

import java.io.*;
import java.net.*;
import java.lang.*;

public class StudentRecord implements
        Serializable {

    private String name, subject;

    public StudentRecord(String n) {
        name = n;
    }

    public void setSubject(String s) {
        subject = s;
    }

    public String toString() {
        return (name + " is doing " + subject);
    }
}
