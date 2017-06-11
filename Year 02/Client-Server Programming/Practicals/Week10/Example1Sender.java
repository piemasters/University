package year2.CSP.Week10;

import java.io.*;
import java.net.*;
import java.util.*;

public class Example1Sender {

    public static void main(String[] args) throws IOException {

        // Set a multicast group address
        InetAddress group = InetAddress.getByName("239.1.2.3");
        
        // Create a multicast socket 
        MulticastSocket s = new MulticastSocket(3456);

        //Create a datagram packet to be sent to the group
        String msg = "Hi everyone!";

        // Send the datagram packet using the multicast socket
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 3456);
        s.send(packet);

    }
}
