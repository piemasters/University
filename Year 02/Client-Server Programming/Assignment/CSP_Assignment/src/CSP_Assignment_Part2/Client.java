package CSP_Assignment_Part2;

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
    private int PORTNO = 4444, fileSize;
    protected String endConnectionProtocol = "Connection closed";
    private String serverOutput, clientOutput;
    private boolean download;
    private FileOutputStream fileOutput;
    //==========================================================================

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.runClient();
    }

    public void runClient() throws IOException {

        //=================| Set up socket & readers/writers |==================
        Socket mySocket = null, fileSocket = null;
        PrintWriter socketOutput = null;
        BufferedReader socketInput = null;
        BufferedReader keyboardInput =
                new BufferedReader(new InputStreamReader(System.in));
        //======================================================================


        //========================| Connect to Socket |=========================
        try {

            // Open socket connected to server and set up for data transfer
            mySocket = new Socket(HOSTID, PORTNO);
            fileSocket = new Socket(HOSTID, PORTNO + 1);
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

            // ---------------------| Download File |---------------------------
            
            if (download == true) {

                // Initialize Byte Array & Input Stream
                int bytesRead, currentTot = 0;
                byte[] bytearray = new byte[fileSize];
                InputStream inputStream = fileSocket.getInputStream();

                // Prepare File Download
                BufferedOutputStream bOutput = 
                        new BufferedOutputStream(fileOutput);
                bytesRead = inputStream.read(bytearray, 0, bytearray.length);
                currentTot = bytesRead;

                // Download File
                do {
                    bytesRead = inputStream.read(bytearray, currentTot,
                            (bytearray.length - currentTot));
                    if (bytesRead >= 0) {
                        currentTot += bytesRead;
                    }   
                } while (bytesRead > 0);
                bOutput.write(bytearray, 0, currentTot);
                bOutput.flush();
                bOutput.close();
                download = false;
                serverOutput = ("Done");
            }
            //------------------------------------------------------------------


            // ---------------| Acknowledge File to Download |------------------

            if (serverOutput.contains("Download")) {

                // Determine what to name file
                switch (serverOutput) {
                    case "Download Program":
                        fileOutput = new FileOutputStream("newProgram.jar");
                        fileSize = 1347;
                        break;
                    case "Download Picture":
                        fileOutput = new FileOutputStream("newPicture.jpg");
                        fileSize = 26788;
                        break;
                    case "Download Book":
                        fileOutput = new FileOutputStream("newBook.txt");
                        fileSize = 334;
                        break;
                    default:
                        fileOutput = null;
                }
                download = true;
                System.out.print("Server: Please press ENTER to continue..");
                //--------------------------------------------------------------
            }

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