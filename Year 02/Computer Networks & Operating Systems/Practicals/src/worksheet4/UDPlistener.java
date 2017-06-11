package worksheet4;

//
// UDPlistener.java based on code in Dietel and Dietel pp 1004-1007
// Server reads a datagram packet from a client and responds
// with a datagram packet.
//

import java.io.*;
import java.net.*;

public class UDPlistener {
	
	private DatagramSocket mySocket;
	private DatagramPacket receivePacket;
	private DatagramPacket sendPacket;
	
	public UDPlistener() {
		
		System.out.println(" \nListening very carefully!\n\n");
		
		try {
			mySocket = new DatagramSocket( 4567);
		}
		catch( SocketException sE) { // error so bad server dies!
			System.err.println( "Could not open a datagram socket");
			sE.printStackTrace();
			System.exit( 1);
		}
	} // constructor
	
	//
	// Wait for packets from client, display them and respond.
	//
	public void waitForPackets() {
		
		do { // wait for 'END' from client!!
			
			// receive a packet, display it and echo
			try {
				// set up a packet ready to receive the msg
				byte data[] = new byte[ 100];
				receivePacket = new DatagramPacket( data, data.length);
				
				// now wait for the packet
				mySocket.receive( receivePacket);
				displayPacket();
				sendPacketToClient( "I see you sent: ");
			}
			catch( IOException ioE) {
				System.err.println( "Some receive error!");
				System.err.println( ioE.toString());
			}
			
		} while( !(receivePacket.toString()).equals( "END"));
		
	} // waitForPacket()
	
	//
	// Display the received packet
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
	// echo packet
	//
	private void sendPacketToClient( String msg) throws IOException {
		
		// construct the packet to send
		String sMsg = msg + " ";
		sMsg += new String( receivePacket.getData(), 0, receivePacket.getLength());
		
		// create the packet to send
		sendPacket = new DatagramPacket( sMsg.getBytes(), sMsg.length(),
				receivePacket.getAddress(), receivePacket.getPort());
		
		// send the packet
		mySocket.send( sendPacket);
		System.out.println( "Packet sent back");
	
	} // sendPacketToClient()
	
	//
	// execute the application
	//
	public static void main( String args[]) {
		
		UDPlistener app = new UDPlistener();
		app.waitForPackets();
	} // main
	
} // class UDPlistener