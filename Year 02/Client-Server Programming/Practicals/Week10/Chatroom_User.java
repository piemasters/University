package year2.CSP.Week10;

import java.io.*;
import java.net.*;
import java.util.*;

public class Chatroom_User {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        try {

            // variables
            Scanner in = new Scanner(System.in);
            String input = "placeholder";

            // start thread
            Chatroom_Thread c1 = new Chatroom_Thread();
            c1.start();

            //Set the same multicast group address
            InetAddress group = InetAddress.getByName("239.1.2.3");
            // Create a multicast socket 
            MulticastSocket s = new MulticastSocket(3456);
            //Create a datagram packet as a placeholder
            byte[] buf = new byte[256];
            String msg = null;
            


            System.out.print("Enter your username : ");
            String username = in.nextLine();
            while (!input.equals("quit")) {
                input = scan.nextLine();
                msg = "User " + username + ": " + input;
                DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 3456);
                s.send(packet);
            }
            s.close();

            System.out.println("You have quit.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
