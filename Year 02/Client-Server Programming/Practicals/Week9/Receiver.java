package year2.CSP.Week9;

import java.net.*;
import java.io.*;
import java.util.*;

public class Receiver {

    public static void main(String[] args) {

        try {

            // create datagram packet 
            final int MAX_LEN = 10;
            byte[] buffer = new byte[MAX_LEN];
            DatagramPacket datagramP = new DatagramPacket(buffer, MAX_LEN);

            // create a datagram socket for receiving the data – see slide Receiver 
            int port = 12345;
            DatagramSocket mySocket = new DatagramSocket(port);

            //receive and display message  
            mySocket.receive(datagramP);
            System.out.println(new String(datagramP.getData()));

            // Display message 
            String message = new String(datagramP.getData());
            System.out.println("Message received is: " + message);

            // Get the sender’s address and port number 
            InetAddress senderAddr = datagramP.getAddress();
            int senderPort = datagramP.getPort();
            System.out.println("got sender Addr: " + senderAddr);
            System.out.println("sender port: " + senderPort);

            // Enter user’s name 
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your name to send back to the sender:");
            String name = in.nextLine();

            // Create a datagram containing the user’s name 
            buffer = name.getBytes();
            DatagramPacket datagram2 = new DatagramPacket(buffer, buffer.length, senderAddr, senderPort);

            //Send a reply datagram 
            mySocket.send(datagram2);

            //close socket 
            mySocket.close();


        } catch (Exception ex) {
        }
    }
}