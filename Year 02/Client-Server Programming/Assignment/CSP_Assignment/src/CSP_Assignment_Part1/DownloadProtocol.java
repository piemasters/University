package CSP_Assignment_Part1;

/* Student Name:    David Norton
 * Student ID:      10005864
 * Version   :      1.0
 * Description:     A protocol used to download the file selected by the client.
 *                  A datatable is used to hold file names and details. It also
 *                  desplays the interface to the user, from which they accept
 *                  the terms and select the files they desire to download.
 */

import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DownloadProtocol extends Thread {

    //===========================| Set up variables |===========================
    private String[][] dataTable = new String[3][2];
    private String serverOutput, clientOutput;
    protected String clientHostName, clientHostIP,
            endConnectionProtocol = "Connection closed";
    protected CounterProtocol systemLog;
    private final int TERMS = 1, SENTTERMS = 2, USERINPUT = 3, ANOTHER = 4;
    private int state = TERMS, clientWants;
    private Socket commSocket;
    //==========================================================================

    
    //======================| Determines Client Details |=======================
    public DownloadProtocol(CounterProtocol systemLog, Socket mySocket){
        try {
            this.systemLog = systemLog;
            this.commSocket = mySocket;
            
            // Work out client's IP & hostname.
            InetAddress clientAddr = InetAddress.getLocalHost(); 
            clientHostIP = clientAddr.getHostAddress();
            clientHostName = clientAddr.getHostName();
        } catch (UnknownHostException ex) {
            System.out.println("Host-Name & Address could not be determined.");
        }
    }
    //==========================================================================
    

    //===================| User Interface & File Download |=====================
    public String runProtocol(String clientOutput) {
        this.clientOutput = clientOutput; //Sets local copy of String passed in.

        //---------------------| Populate the dataTable |-----------------------
        dataTable[0][0] = "computer program";
        dataTable[0][1] = "The program displays a message";
        dataTable[1][0] = "picture";
        dataTable[1][1] = "This picture shows a man at work";
        dataTable[2][0] = "e-book";
        dataTable[2][1] = "The book is about unknowns";
        String options = ("1. " + dataTable[0][0] + " 2. " + dataTable[1][0]
                + " 3. " + dataTable[2][0]);
        //----------------------------------------------------------------------

        switch (state) {

            // -----------------| Display Terms of Reference |------------------
            case 1: 

                serverOutput = "Terms of reference. Do you accept? Y or N";
                state = SENTTERMS;

                break;
            //------------------------------------------------------------------
                
                
            // ------| Determine TofR Response & Display Available Files |------    
            case 2: 

                if (clientOutput.equalsIgnoreCase("Y")) {
                    serverOutput = options;
                    state = USERINPUT;
                } else if (clientOutput.equalsIgnoreCase("N")) {
                    serverOutput = endConnectionProtocol;
                    System.out.println("Server output: end");
                } else {
                    serverOutput = ("Invalid Input. Terms of reference. "
                            + "Do you accept? Y or N");
                    state = SENTTERMS;
                }

                break;
            //------------------------------------------------------------------
                
            
            // --------------------| Send File to Cleint |----------------------
            case 3: 
                // Determine file required
                switch (clientOutput) {
                case "1": clientWants = 1;
                    break;
                case "2": clientWants = 2;
                    break;
                case "3": clientWants = 3;
                    break;
                default:
                    serverOutput = ("Invalid Input. 1, 2 or 3?");
                    break;
                }

                // Send file
                serverOutput = ((dataTable[(clientWants - 1)][1]) 
                        + " | Another? Y or N");
               
                //Update log in a way that does not cause blocking.
                systemLog.incCounter(clientWants);
                systemLog.appendToLog(clientHostName, clientHostIP);
                
                state = ANOTHER;

                break;
            //------------------------------------------------------------------
                
                
            // --------| Display Available Files or Close Connection |----------    
            case 4: 
                if (clientOutput.equalsIgnoreCase("Y")) {
                    serverOutput = options;
                    state = USERINPUT;
                } else if (clientOutput.equalsIgnoreCase("N")) {
                    serverOutput = endConnectionProtocol;
                } else {
                    serverOutput = ("Invalid input. Another? Y or N");
                    state = SENTTERMS;
                }

                break;
            //------------------------------------------------------------------
        }        
        return serverOutput;
    }
    //==========================================================================

}
