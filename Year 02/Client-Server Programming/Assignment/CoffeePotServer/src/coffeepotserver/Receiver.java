package coffeepotserver;

import java.io.IOException;

/*
 * Receiving Class
 * 
 * Deals with adding the clients input to a buffer ready to be dealt with.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */
public class Receiver extends Thread {

    //=========================| Global Variables |=============================
    StreamSocket client;
    String clientInput;
    String buffer;

    //==========================================================================
    //
    //===========================| Constructor |================================
    public Receiver(StreamSocket client) {
        this.client = client;
    }

    //==========================================================================
    //
    //=========================| Deal with buffer |=============================
    private void addToBuffer(char clientInputChar) {

        // Add input to buffer
        buffer += clientInputChar;

        // Remove new lines
        if (buffer.equals("\n")) {
            buffer = "";
        }

        // Remove null values
        buffer = buffer.replaceAll("null", "");

        // Clear buffer
        if (buffer.contains("\r\n\r\n")) {
            setInput(buffer);
            buffer = "";
        }
    }

    //==========================================================================
    //
    //========================| Getters & Setters |=============================
    public synchronized String getInput() {
        return clientInput;
    }

    private void setInput(String clientInput) {
        this.clientInput = clientInput;
    }

    //==========================================================================
    //
    //============================| Clear Input |===============================
    public synchronized void clear() {
        clientInput = "";
    }

    //==========================================================================
    //
    //=============| Add client's order to buffer or kill client |==============
    public void run() {
        
        while (client.isOpen()) {
            
            //-----------------| Add client order to buffer |-------------------
            try {
                
                addToBuffer(client.readChar());
                
            }//
            //------------------------------------------------------------------
            //
            //---------------------| On error kill client |---------------------
            catch (IOException e) {
                
                try {
                    client.kill();
                } catch (IOException i) {
                    i.printStackTrace();
                }
                
            }
            //------------------------------------------------------------------
            
        } // While
    } // Run
    //==========================================================================
}