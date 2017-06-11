package CSP_Assignment_Part1;

/* Student Name:    David Norton
 * Student ID:      10005864
 * Version   :      1.0
 * Description:     The Server program which connects with multiple clients, 
 *                  allowing them to download desired files. It does this over
 *                  a determined socket and implements the use of threads to
 *                  allow for multiple clients.
 */

import java.io.*;
import java.net.*;

public class Server {

    //===========================| Set up variables |===========================
    private int PORTNO = 4444, BACKLOG = 5;
    private boolean listen = true;
    protected CounterProtocol systemLog = new CounterProtocol();
    // Initialise ServerSocket to prevent system crash if try/catch loop fails 
    private ServerSocket serverSocket;
    //==========================================================================

    public static void main(String[] args) throws IOException {

        Server mainServer = new Server();
        mainServer.runServer();
    }

    public void runServer() {

        System.out.println("Starting Server...");

        //==========================| Create Socket |===========================
        try {
            try {
                serverSocket = new ServerSocket(PORTNO, BACKLOG);
                
            } catch (IOException e) { // If port is locked throw an error.
                System.err.println("Could not listen on port: " + PORTNO);
                System.exit(-1);
            }

            // Listen for connection attempts (infinite loop not detected).
            while (listen) {
                // For each new connection create a new Server Thread
                new ServerThread(serverSocket.accept(), systemLog).start();
            }

            serverSocket.close();   // close the connection socket

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //======================================================================

    }
}
