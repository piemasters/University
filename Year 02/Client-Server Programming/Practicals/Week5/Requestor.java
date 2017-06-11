package year2.CSP.Week5;

import java.net.*;
import java.io.*;

public class Requestor {

    public static void main(String[] args) {
        try {
            // Connecting to the server by creating a data socket with the server’s address – see slide Requestor (1)
            //set the address of the acceptor, i.e. the server, 
            String acceptorHost = "localhost";
            int acceptorPort = 12345;
            //Make a connection request to the server by creating a data socket with the server’s address
            Socket mySocket = new Socket(acceptorHost, acceptorPort);

            // get the input stream -- see slide Requestor (2)
            // get an input stream for reading from the data socket
            InputStream inStream = mySocket.getInputStream();
            // create a BufferedReader object for text line input
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(inStream));

            // receive the data -- see slide Requestor (3)
            // receive the data, read a line from the data stream
            String message = socketInput.readLine();
            // display message
            System.out.println("Message received:");
            System.out.println("\t" + message);

            // close socket – see slide Requestor (4)
            // close socket
            mySocket.close();

        } // end try
        catch (Exception ex) {
            ex.printStackTrace();
        } //end catch
    } // end main
} // end class

