package worksheet3;
//
// EchoServer.java
// Acts as an echo server.
// Client must connect on the correct port.
// Server closes the connection on receiving 'END'.
// But keeps running for more client connections.
//
// Give the port number as a command line argument:
// e.g. java EchoServer [4567]
//

import java.io.*;
import java.net.*;

public class EchoServer {
	 
	 public final static int DEFAULT_PORT = 3456;
	 public final static int qLen = 3; // number of clients that can q
	 public void EchoServer() {}
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
			 String request = null; // try changing for isr rather than br
//			 char request[] = new char[ 4];
//			 int nChars = 0;
			 
			 try {
				 
				 clientSocket = listenSocket.accept(); // actual comms socket!
				 ++clientNo; // count clients serviced
				 osw = new OutputStreamWriter( clientSocket.getOutputStream());
				// the above line might need , "US-ASCII"); or // "UTF-8"?
				 
				 System.out.println( "Connection from: " + clientSocket.getInetAddress());
				 isr = new InputStreamReader( clientSocket.getInputStream());
				// the above line might need , "US-ASCII"); or // "UTF-8"?
				 br = new BufferedReader( isr);
				 
				 do {			 
					 request = br.readLine(); // try changing for isr rather than br
					 System.out.println( "\tFrom client " + clientNo + ": " + request);
//					 nChars = isr.read( request, 0, request.length);
//					 System.out.println( "\tReceived: " + new String( request, 0, nChars));
					 
					 // What happens if we don't send '\r\n' or only one of them?
					 osw.write( "Hello from "+ InetAddress.getLocalHost() + " to Client no: " + clientNo + "\r\n");
					 osw.flush(); // make sure msg got sent from the buffer!
				 } while( !request.equals( "END"));
//				 } while( !(new String( request)).equals( "END"));
					 
				 System.out.println( "Client " + clientNo + " closed connection");
				 osw.close();
				 isr.close();
				 br.close();
				 clientSocket.close(); 
				 
			 } // end try{} accepting a client connection
			 
			 catch( IOException ioE) {
				System.err.println( "Connection error, maybe the client died!");
			 }
			 finally { // to trap any other errors!!
				 try {
					if( clientSocket != null) clientSocket.close();
				 }
				 catch( IOException ioE) {}
			 } // end of finally
			 
		 } // while forever waiting for a client connection
	 } // main
} // class EchoServer