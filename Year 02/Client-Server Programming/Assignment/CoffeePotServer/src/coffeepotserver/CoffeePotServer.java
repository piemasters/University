package coffeepotserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Main Class
 * 
 * This is the main class of the Coffee Pot Server.
 * It loops forever allowing new clients to access the coffeepot protocol. It
 * also allows for debug mode to gather extra information.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */
//==============================| Main Class |==================================
public class CoffeePotServer {

    public static void main(String[] args) {

        //---------------------------| Variables |------------------------------

        ServerSocket server;
        int portNo = 5656;
        Scanner scan = new Scanner(System.in);
        boolean debug = false;
        Protocol newClient;
        ArrayList<CoffeePot> pots = new ArrayList<>();

        //----------------------------------------------------------------------
        
        System.out.println("===================================================");
        System.out.println("===========| COFFEE POT SERVER V 1.0 |=============");
        System.out.println("===================================================");
        System.out.println("");
        
        //---------------------------| Debug Mode |-----------------------------

        System.out.print("Enable Debug mode? \n 1) YES \n 2) NO \nOption: ");
        if (scan.next().equals("1")) {
            debug = true;
            System.out.println("\nDebug Mode Enabled Successfully!\n");
        }

        //----------------------------------------------------------------------
        //
        //-------------------------| Add Coffee Pots |--------------------------

        Data.CreatePots(debug, pots);

        //----------------------------------------------------------------------
        //
        //---------------------------| Run Server |-----------------------------

        try {
            server = new ServerSocket(portNo);
            while (true) {
                newClient = new Protocol(server.accept(), pots, debug);
                newClient.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //----------------------------------------------------------------------

    }
} // Class