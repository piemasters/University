package year2.CSP.Week9;

import java.net.*;
import java.io.*;

public class Sender {

    public static void main(String[] args) {

        try {

            // set receiver’s address 
            InetAddress receiverHost = InetAddress.getByName("localhost");
            int receiverPort = 12345;

            // create byte array for the message and create datagram packet
            String message = "hello";
            byte[] buffer = message.getBytes();
            DatagramPacket datagramP = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);

            // create datagram socket
            DatagramSocket mySocket = new DatagramSocket();

            // send packet
            mySocket.send(datagramP);

            // receive packet
            mySocket.receive(datagramP);

            // Display message received
            String ack = new String(datagramP.getData());
            System.out.println("The receiver's reply is: " + ack);


            // close datagram socket 
            mySocket.close();

        } catch (Exception ex) {
        }
    }
}