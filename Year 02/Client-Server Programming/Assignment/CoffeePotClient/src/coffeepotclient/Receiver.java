package coffeepotclient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Receiver Class
 * 
 * This class deals with incoming server messages and displays them to the 
 * client.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */

public class Receiver extends Thread {

    //==========================| Global Variables |============================
    StreamSocket streamServer;
    String serverOutput;
    boolean debug = true;

    //==========================================================================
    //
    //=============================| Constructor |==============================
    public Receiver(StreamSocket serverStream, boolean debug) {
        
        this.streamServer = serverStream;
        this.debug = debug;
        
    }

    //==========================================================================
    //
    //=================================| Run |==================================
    @Override
    public void run() {
        
        while (streamServer.isOpen()) {
            
            serverOutput = streamServer.recieveString();

            //-----------| If null received kill server connection |------------
            if (serverOutput == null) {
                try {
                    streamServer.kill();
                } catch (IOException ex) {
                    Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                return;
            }
            //------------------------------------------------------------------
            //
            //---------------------| Print server output |----------------------
            if (!serverOutput.equals("")) {
                
                //---------------| Display status on debug mode |---------------
                if (debug == true) {
                    System.out.print("Received from: " + streamServer.displayDetail() + "\n" + serverOutput + "\n");
                } //
                //--------------------------------------------------------------
                else {
                    serverOutput = Parser.parseResponse(serverOutput);
                    System.out.print(serverOutput + "\n");
                }
            }
            //------------------------------------------------------------------
        }
    }
    //==========================================================================
}
