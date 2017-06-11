package worksheet4;

//
// UDPclient.java based on code in Dietel and Dietel pp 1008-1010
// Sends a datagram packet to a server and
// waits for a reply.
//

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPclient {
	
	private DatagramSocket mySocket;
	private DatagramPacket sendPacket;
	private DatagramPacket receivePacket;
	
	public UDPclient() { // constructor
		try {
			mySocket = new DatagramSocket();
		}
		catch ( SocketException sockE) {
			System.err.println( "Problem opening datagram socket!");
			sockE.printStackTrace();
			System.exit( 1);
		}
	} // constructor
	
	//
	// Send packets, wait for responses from server and display them.
	//
	public void sendPackets() throws UnknownHostException {
		
		Scanner kbd = new Scanner( System.in);
		Scanner scan = new Scanner( System.in);
		String message = null;
		byte rdata[] = new byte[ 200]; // to hold response
				
			//Setup Port
			int portNo;
			System.out.print( "Enter port number or press 0 to skip: ");
			portNo = scan.nextInt();
			if (portNo == 0) {
				portNo = 4567;
			}
			
			//Setup Host
			String host;
			InetAddress add;
			System.out.println( "Enter host address in the form: " + InetAddress.getLocalHost() + " or press 0 to skip: ");
			host = scan.next();	
			if (host == "0") {		 
				add = InetAddress.getByName(host);	
			} else {
				add = InetAddress.getLocalHost();
			}		
		
		do{ // wait for 'END'
			try {
				
				// set up datagram packet.
				System.out.println( "\nEnter a message to send (END to disconnect): ");				
				// next line of input from keybd.
				message = kbd.nextLine(); // what happens if we use next()?
				
				if( !message.equals( "END")) { // if more messages to send
					
					// set up the packet
					byte sdata[] = message.getBytes();
					sendPacket = new DatagramPacket( sdata, sdata.length, add, portNo);
					mySocket.send( sendPacket);
					// wait for response!
					receivePacket = new DatagramPacket( rdata, rdata.length);
					mySocket.receive( receivePacket);
					displayPacket();
				} // if msgs to send
			}
			
			catch( IOException ioE) {
				System.err.println( "Receive error!");
				ioE.printStackTrace();
			}
			
		} while( !message.equals( "END"));
		
		System.out.println( "Client finished");
		mySocket.close();
	
	} // sendPackets()
	
	//
	// display the received packet
	//
	public void displayPacket() {
		System.out.println( "Packet received: ");
		System.out.println( "\tFrom host: " + receivePacket.getAddress());
		System.out.println( "\tHost port: " + receivePacket.getPort());
		System.out.println( "\tLength: " + receivePacket.getLength());
		System.out.println( "\tContaining: ");
		System.out.println( "\t\t" + new String( receivePacket.getData(), 0,
				receivePacket.getLength()));
	} // displayPacket()
	
	//
	// start the application!
	//
	public static void main( String args[]) throws UnknownHostException {
		UDPclient app = new UDPclient();
		app.sendPackets();
	} // main
	
} // class UDPclient