package CSP_Assignment_Part1;

/* Student Name:    David Norton
 * Student ID:      10005864
 * Version   :      1.0
 * Description:     Server threads allow multiple users connect with the Server.
 *                  Controls the creation of a thread, its close and keeping
 *                  connection with a client until they select to exit.
 */

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {

    //===========================| Set up variables |===========================
    protected Socket mySocket = null;
    protected String endConnectionProtocol = "Connection closed";
    private String serverOutput, clientOutput;
    private CounterProtocol systemLog;
    //==========================================================================

    public ServerThread(Socket socket, CounterProtocol systemLog) {
        this.mySocket = socket;
        this.systemLog = systemLog;
    }

    @Override
    public void run() {

        System.out.println("New Connection Started.");

        try {
            
            //=====| Set up Reader/Writer & Connect to Download Protocol |======
            BufferedReader socketInput = new BufferedReader
                    (new InputStreamReader(mySocket.getInputStream()));
            PrintWriter socketOutput = 
                    new PrintWriter(mySocket.getOutputStream(), true);
            DownloadProtocol serverProtocol = 
                    new DownloadProtocol(systemLog, mySocket);
            
            serverProtocol.start();
            serverOutput = serverProtocol.runProtocol(null);
            socketOutput.println(serverOutput);
            //==================================================================
            

            //===================| Communicate with Client |====================
            while ((clientOutput = socketInput.readLine()) != null) {

                serverOutput = serverProtocol.runProtocol(clientOutput);

                // If client has selected to quit the loop is broken
                if (serverOutput.equals(endConnectionProtocol)) {
                    socketOutput.println(endConnectionProtocol);
                } else {
                    socketOutput.println(serverOutput);
                }
            }
            //==================================================================
            
            
            //===========| Close Sockets to free System Resources |=============
            mySocket.close();
            socketInput.close();
            socketOutput.close();
            //==================================================================
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    } // End run
} // End ServerThread
