package year2.CSP.Week10;

import java.io.*;
import java.net.*;
import java.util.*;

public class Example1Receive_loop_1 {

    public static void main(String[] args) throws IOException {

        try {

            System.out.println("Enter the process name : ");
            Scanner in = new Scanner(System.in);
            String processName = in.nextLine();


            //Set the same multicast group address
            InetAddress group = InetAddress.getByName("239.1.2.3");
            // Create a multicast socket with the same port number
            MulticastSocket s = new MulticastSocket(3456);
            // Join the group
            s.joinGroup(group);

            //Create a datagram packet as a placeholder
            byte[] buf = new byte[100];
            DatagramPacket recv = new DatagramPacket(buf, buf.length);

            int count = 0;
            while (count < 10) {
                // Issue a receive method to receive a data packet
                s.receive(recv);
                System.out.println(new String(recv.getData()));
            }
            s.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
