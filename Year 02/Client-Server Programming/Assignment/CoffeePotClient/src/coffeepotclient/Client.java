package coffeepotclient;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    /*
     * Main Class
     * 
     * This is the main class of the Coffee Pot Client.
     * It prompts the user for thei information and then attempts to connect
     * to the server.
     * 
     * David Norton - 10005864
     * Hiten Kotecha - 11004776
     */
    
    //=============================| Main Class |===============================
    public static void main(String[] args) {

        //---------------------------| Variables |------------------------------
        Receiver rx;
        Transmitter tx;
        int portNo = 5656;
        Scanner scan = new Scanner(System.in);
        boolean debug = false, hostAccepted = true;
        String URI, host;
        Socket requestSocket;
        StreamSocket streamServer;
        //----------------------------------------------------------------------

        System.out.println("===================================================");
        System.out.println("===========| COFFEE POT CLIENT V 1.0 |=============");
        System.out.println("===================================================");
        System.out.println("");
        
        //-----------------------------| Debug |--------------------------------
         System.out.print("Enable Debug mode? \n 1) YES \n 2) NO \nOption: ");
        
        if (scan.next().equals("1")) {
            debug = true;
            System.out.println("\nDebug Mode Enabled Successfully!\n");
        }
        //----------------------------------------------------------------------

        //---------------------------| Get Host |-------------------------------
        System.out.print("Enter your URI \n 1) Localhost \nURI:");
        URI = scan.next();
        host = Parser.getHost(URI);
       
        if (URI.equals("1")) {
            host = "localhost";
        }
        //System.out.println("\nYou are connected as: " + host);
        //----------------------------------------------------------------------
        
        //System.out.println("-------------------------------------------------");
        //System.out.println("INSTRUCTIONS");       
        //System.out.println("Enter \"coffee://<'URI'>/\" before each command");
        //System.out.println("-------------------------------------------------");
        
        //-----------------------| Connect to Host |---------------------------
        try {
            requestSocket = new Socket(host, portNo);
            streamServer = new StreamSocket(requestSocket);
            rx = new Receiver(streamServer, debug);
            tx = new Transmitter(streamServer, scan, URI, debug);
            rx.start();
            tx.start();
        } catch (UnknownHostException e) {
            System.out.print("Host not found\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //----------------------------------------------------------------------
    }
    //==========================================================================
}