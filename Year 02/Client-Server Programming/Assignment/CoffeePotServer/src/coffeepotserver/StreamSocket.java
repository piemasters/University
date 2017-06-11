package coffeepotserver;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
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
    DataOutputStream dataOut;
    PrintWriter socketOut;
    InputStream streamIn;
    InputStreamReader streamReader;
    DataInputStream dataIn;
    BufferedReader socketIn;
    boolean status;
    
    //==========================================================================
    //
    //===========================| Constructor |================================

    public StreamSocket(Socket socket) throws IOException {
       
        this.socket = socket;
        
        //----------|  Create sockets for file & string transmition |-----------
        
        // Out
        streamOut = socket.getOutputStream();
        streamWriter = new OutputStreamWriter(streamOut);
        dataOut = new DataOutputStream(streamOut);
        socketOut = new PrintWriter(streamWriter);

        // In
        streamIn = socket.getInputStream();
        streamReader = new InputStreamReader(streamIn);
        dataIn = new DataInputStream(streamIn);
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
            Logger.getLogger(StreamSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //==========================================================================
    //
    //=====================| Send and flush a byte |============================

    public void sendBytes(byte[] data, int length) {

        try {
            dataOut.write(data, 0, length);
            dataOut.flush();
        } catch (IOException ex) {
            Logger.getLogger(StreamSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //==========================================================================
    //
    //=====================| Receive a byte array |=============================
    public byte[] recieveBytes(int length) {
        
        byte[] temp = new byte[length];
        
        try {
            dataIn.read(temp, 0, length);
        } catch (IOException ex) {
            Logger.getLogger(StreamSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
    }
    
    //==========================================================================
    //
    //============| Returns client socket info for server output |==============

    public String displayDetail() {
        
        InetAddress clientAddress;
        clientAddress = socket.getInetAddress();
        
        return clientAddress.getHostName() + " " + clientAddress.getHostAddress();
    }

    //==========================================================================
    //
    //==========================| Close all sockets |===========================
    
    public void kill() throws IOException {// Close all sockets
        status = false;
        socket.close();
        streamOut.close();
        dataOut.close();
        streamWriter.close();
        socketOut.close();
        streamIn.close();
        dataIn.close();
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
    //=======================| Read char from buffer |==========================

    public char readChar() throws IOException {
        return (char) dataIn.readByte();
    }
    //==========================================================================
}
