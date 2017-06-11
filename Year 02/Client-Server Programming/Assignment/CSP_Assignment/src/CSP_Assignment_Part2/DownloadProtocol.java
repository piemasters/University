package CSP_Assignment_Part2;

/* Student Name:    David Norton
 * Student ID:      10005864
 * Version   :      1.0
 * Description:     A protocol used to download the file selected by the client.
 *                  A datatable is used to hold file names and details. It also
 *                  desplays the interface to the user, from which they accept
 *                  the terms and select the files they desire to download.
 */
import java.io.*;
import java.net.*;

public class DownloadProtocol extends Thread {

    //===========================| Set up variables |===========================
    private String[] dataTable = new String[3];
    private String serverOutput, clientOutput;
    protected String clientHostName, clientHostIP,
            endConnectionProtocol = "Connection closed";
    protected CounterProtocol systemLog;
    private final int TERMS = 1, SENTTERMS = 2, USERINPUT = 3, DOWNLOAD = 4,
            ANOTHER = 5;
    private int state = TERMS, fileCounter;
    private Socket commSocket;
    File clientWants;
    File transferBook = new File("myBook.txt");
    File transferPicture = new File("myPicture.jpg");
    File transferProgram = new File("myProgram.jar");
    //==========================================================================

    //======================| Determines Client Details |=======================
    public DownloadProtocol(CounterProtocol systemLog, Socket mySocket) {
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
    public String runProtocol(String clientOutput, Socket mySocket, Socket fileSocket) {
        this.clientOutput = clientOutput; //Sets local copy of String passed in.

        //---------------------| Populate the dataTable |-----------------------
        dataTable[0] = "computer program";
        dataTable[1] = "picture";
        dataTable[2] = "e-book";
        String options = ("1. " + dataTable[0] + " 2. " + dataTable[1]
                + " 3. " + dataTable[2]);
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


            // -------------------| Determine File To Send |--------------------
            case 3:
                // Determine file required
                switch (clientOutput) {
                    case "1":
                        clientWants = transferProgram;
                        fileCounter = 1;
                        serverOutput = ("Download Program");
                        break;
                    case "2":
                        clientWants = transferPicture;
                        fileCounter = 2;
                        serverOutput = ("Download Picture");
                        break;
                    case "3":
                        clientWants = transferBook;
                        fileCounter = 3;
                        serverOutput = ("Download Book");
                        break;
                    default:
                        serverOutput = ("Invalid Input. 1, 2 or 3?");
                        break;
                }

                state = DOWNLOAD;
                break;
            //------------------------------------------------------------------


            // --------------------| Send File to Cleint |----------------------    
            case 4:
                try {
                    // Implement file into a byte array
                    byte[] bytearray = new byte[(int) clientWants.length()];
                    FileInputStream fileInput = new FileInputStream(clientWants);
                    BufferedInputStream bInput =
                            new BufferedInputStream(fileInput);
                    bInput.read(bytearray, 0, bytearray.length);

                    // Send File
                    OutputStream outputStream = fileSocket.getOutputStream();
                    System.out.println("Sending Files...");
                    outputStream.write(bytearray, 0, bytearray.length);
                    outputStream.flush();
                    System.out.println("File sent.");

                } catch (FileNotFoundException f) {
                    System.out.println("Error: File Not Found");
                } catch (IOException i) {
                    System.err.println("Connection to port failed.");
                }

                serverOutput = ("File Downloaded Successfully. Would you like "
                        + "to download another file? Y or N");
                
                //Update log in a way that does not cause blocking.
                systemLog.incCounter(fileCounter);
                systemLog.appendToLog(clientHostName, clientHostIP);

                state = ANOTHER;

                break;
            //------------------------------------------------------------------

            // --------| Display Available Files or Close Connection |----------    
            case 5:
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
