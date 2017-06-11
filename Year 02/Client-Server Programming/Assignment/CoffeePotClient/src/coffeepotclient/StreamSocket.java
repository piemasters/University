package coffeepotclient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Stream Socket
 * 
 * Deals with all sending and recieving of data between the server and the 
 * client.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */
public class StreamSocket {

    //=========================| Global Variables |=============================
    Socket socket;
    OutputStream streamOut;
    OutputStreamWriter streamWriter;
    PrintWriter socketOut;
    InputStream streamIn;
    InputStreamReader streamReader;
    BufferedReader socketIn;
    boolean status;
    int portNo = 5656;

    //==========================================================================
    //
    //===========================| Constructor |================================
    public StreamSocket(Socket socket) throws IOException {

        this.socket = socket;

        //----------|  Create sockets for file & string transmition |-----------

        // Out
        streamOut = socket.getOutputStream();
        streamWriter = new OutputStreamWriter(streamOut);
        socketOut = new PrintWriter(streamWriter);

        //In
        streamIn = socket.getInputStream();
        streamReader = new InputStreamReader(streamIn);
        socketIn = new BufferedReader(streamReader);

        //----------------------------------------------------------------------

        status = true;
    }

    //==========================================================================
    //
    //=====================| Send and flush a string |==========================
    public void sendString(String message) {
        socketOut.println(message);
        socketOut.flush();
    }

    //==========================================================================
    //
    //========================| Receive a string |==============================
    public String recieveString() {
        try {
            return socketIn.readLine();
        } catch (IOException ex) {
        }
        return null;
    }
    
    //==========================================================================
    //
    //============| Returns server socket info for client output |==============

    public String displayDetail() {
        
        InetAddress clientAddress;
        clientAddress = socket.getInetAddress();
        
        return clientAddress.getHostName() + " " + clientAddress.getHostAddress();
    }
    
    //==========================================================================
    //
    //==========================| Close all sockets |===========================

    public void kill() throws IOException {
        status = false;
        socket.close();

        streamOut.close();
        streamWriter.close();
        socketOut.close();

        streamIn.close();
        streamReader.close();
        socketIn.close();
    }
    
    //==========================================================================
    //
    //=======================| Check if client is open |========================
    public boolean isOpen() {
        return status;
    }
    
    //==========================================================================
    //
    //=========================| Update host socket |===========================

    public void updateHost(String host) throws UnknownHostException, IOException {
        socket = new Socket(host, portNo);
    }

    //==========================================================================
    //
    //==========================| Get host address |============================
    
    public String getCurrentHost() {
        
        InetAddress host;
        host = socket.getInetAddress();
        return host.getHostName();
        
    }
    
    //==========================================================================
}
