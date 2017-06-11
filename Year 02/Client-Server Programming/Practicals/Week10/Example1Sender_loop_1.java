package year2.CSP.Week10;

import java.io.*;
import java.net.*;
import java.util.*;

public class Example1Sender_loop_1 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        
        try {
        
        // Set a multicast group address
        InetAddress group = InetAddress.getByName("239.1.2.3");       
        // Create a multicast socket 
        MulticastSocket s = new MulticastSocket(3456);

        int count = 1;
        while (count < 10) {
                System.out.println("Enter the text for sending to the group: ");
            String msg = scan.nextLine();
            
            // Send the datagram packet using the multicast socket
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 3456);
            s.send(packet);
            count++;
        }
        s.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
