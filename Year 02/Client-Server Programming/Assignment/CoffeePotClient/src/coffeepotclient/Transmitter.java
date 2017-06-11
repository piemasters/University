package coffeepotclient;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Transmitter Class
 * 
 * Deals with sending of messages to the server.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */

public class Transmitter extends Thread {

    //==========================| Global Variables |============================
    StreamSocket streamServer;
    Scanner scan;
    String serverInput;
    boolean debug;

    //==========================================================================
    //
    //=============================| Constructor |==============================
    public Transmitter(StreamSocket serverStream, Scanner scan, String initialInput, boolean debug) {

        this.streamServer = serverStream;
        this.scan = scan;
        this.debug = debug;
        serverInput = Parser.parseRequest(initialInput, this.streamServer);

    }

    //==========================================================================
    //
    //=================================| Run |==================================
    @Override
    public void run() {
        
        while (streamServer.isOpen()) {
            
            //--------------| Send string to server (with Debug) |--------------
            if ((debug == true) && (!"".equals(serverInput))) {
                System.out.print("Sent to: " + streamServer.displayDetail() + "\n" + serverInput);
            }
            streamServer.sendString(serverInput);
            //------------------------------------------------------------------
            //
            //--------------| Receive string from keyboard input |--------------
            serverInput = scan.nextLine();
            serverInput = Parser.parseRequest(serverInput, streamServer);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Transmitter.class.getName()).log(Level.SEVERE, null, ex);
            }
            //------------------------------------------------------------------
        }
        
    }
    //==========================================================================
}
