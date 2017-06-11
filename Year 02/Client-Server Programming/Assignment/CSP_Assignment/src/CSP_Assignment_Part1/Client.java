package CSP_Assignment_Part1;

/* Student Name:    David Norton
 * Student ID:      10005864
 * Version   :      1.0
 * Description:     The user program that connects to the download server 
 *                  via a shared socket, interacts with it and requests 
 *                  files for download.
 */

import java.io.*;
import java.net.*;

public class Client {

    //===========================| Set up variables |===========================
    protected String HOSTID = "127.0.0.1";
    private int PORTNO = 4444;
    protected String endConnectionProtocol = "Connection closed";
    private String serverOutput, clientOutput;
    //==========================================================================

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.runClient();
    }

    public void runClient() throws IOException {

        //=================| Set up socket & readers/writers |==================
        Socket mySocket = null;
        PrintWriter socketOutput = null;
        BufferedReader socketInput = null;
        BufferedReader keyboardInput = 
                new BufferedReader(new InputStreamReader(System.in));
        //======================================================================

        
        //========================| Connect to Socket |=========================
        try {

            // Open socket connected to server and set up for data transfer
            mySocket = new Socket(HOSTID, PORTNO);
            socketOutput = new PrintWriter(mySocket.getOutputStream(), true);
            socketInput = new BufferedReader
                    (new InputStreamReader(mySocket.getInputStream()));

        } catch (UnknownHostException e) { // Error if host IP not found
           
            System.err.println("Don't know about host: " + HOSTID);
            System.exit(1);

        } catch (IOException e) { // Error if host port is busy
            
            System.err.println("Couldn't get I/O for connection to: " + PORTNO);
            System.exit(1);
        }
        //======================================================================

        
        //=====================| Communicate with Server |======================
        while ((serverOutput = socketInput.readLine()) != null) {

            System.out.println("Server: " + serverOutput);
            
            // If server disconnects from the client the loop is broken
            if (serverOutput.equals(endConnectionProtocol)) {
                break;
            }

            // Display and send what the client has submitted
            clientOutput = keyboardInput.readLine();
            if (clientOutput != null) {
                System.out.println("Client: " + clientOutput);
                socketOutput.println(clientOutput);
            }
            
        }
        //=====================================================================
        
        
        //=============| Close Sockets to free System Resources |===============
        socketOutput.close();
        socketInput.close();
        keyboardInput.close();
        mySocket.close();
        //======================================================================
   
    
    } // End runClient
} // End Client
