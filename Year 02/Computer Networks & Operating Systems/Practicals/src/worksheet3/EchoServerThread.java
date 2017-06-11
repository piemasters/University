package worksheet3;
//
// EchoServerThread.java
// Acts as an echo server.
// Client must connect on the correct port.
// Server closes the connection on receiving 'END'.
// But keeps running for more client connections.
//
// Give the port number as a command line argument:
// e.g. java EchoServerThread [4567]
//

import java.io.*;
import java.net.*;

public class EchoServerThread {
	 
	 public final static int DEFAULT_PORT = 3456;
	 public final static int qLen = 3; // number of clients that can q
	 public void EchoServerThread() {}
	 public static void main( String[] args) throws IOException {
		 
		 ServerSocket listenSocket = null;
		 OutputStreamWriter osw = null;
		 InputStreamReader isr = null;
		 BufferedReader br = null;
		 int portNum = DEFAULT_PORT;
		 int clientNo = 0; // count clients serviced
		
		if( args.length != 0) {
			 try {
				 portNum = Integer.parseInt( args[ 0]);
				// put some test here to allow for port number not in range
			 }
			 catch( NumberFormatException nfE) {
				 System.err.println( "Illegal port number: " + args[ 0]);
				 System.err.println( "\tUsing the default: " + DEFAULT_PORT);
			 }
		 }
		 
		 try {
			listenSocket = new ServerSocket( portNum, qLen); 
		 } 
		 catch( BindException e) {
			 System.err.println("Could not bind to port: " + portNum);
			 System.err.println( "\tIs it already in use?");
			 System.err.println( "\tIs it a reserved port number?");
			 System.exit(1);
		 }
		 
		 while( true) { // loop forever accepting clients
			 
			 Socket clientSocket = null; 
			 
			 clientSocket = listenSocket.accept();
			 ++clientNo; // count clients serviced
			 new HandleClient( clientSocket, clientNo).start(); // a new thread
			 //new HandleClient( listenSocket.accept(), ++clientNo).start();
			 
		 } // while forever waiting for a client connection
	 } // main
} // class EchoServerThread