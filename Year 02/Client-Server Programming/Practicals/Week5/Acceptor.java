package year2.CSP.Week5;

import java.net.*;
import java.io.*;
import java.util.*;

public class Acceptor {

    public static void main(String[] args) {

        System.out.println("--------------------\nThe Server Is Open\n--------------------");
        System.out.println("Press q to quit");

        try {
            // Listen for connection request and create a data socket -- on Acceptor (1)
            // assign the server’s port number
            int portNo = 12345;
            // create a server socket (connection socket) for accepting connection
            ServerSocket connectionSocket = new ServerSocket(portNo);

            // listening for connection request and create a data socket.
            Socket dataSocket = connectionSocket.accept();

            // get an output stream for writing to the data socket –   Acceptor (2)
            // get a output stream for writing to the data socket
            OutputStream outStream = dataSocket.getOutputStream();
            // create a PrinterWriter object for character-mode output
            PrintWriter socketOutput = new PrintWriter(new OutputStreamWriter(outStream));


            // write a message into the data stream –  see slide Acceptor (3)
            // write a message into the data stream
            Date date = new Date();
            String message = "The current date is: ";
            socketOutput.println(message + date);
            socketOutput.flush();


            // close the data socket and close the serversocket – see slide Acceptor (4)
            //close data socket 
            dataSocket.close();
            // close the connection socket
            connectionSocket.close();

        } // end try
        catch (Exception ex) {
            ex.printStackTrace();
        } //end catch

    } // end main
} // end class
