package worksheet3;
//
//HandleClient.java
//A thread class to enable multiple Echo Clients
//

import java.io.*;
import java.net.*;

public class HandleClient extends Thread {
	private Socket clientSocket = null;
	private int clientNo = 0;
	private OutputStreamWriter osw = null;
	private InputStreamReader isr = null;
	private BufferedReader br = null;
	//constructor
	public HandleClient( Socket socket, int clientNo) {
		//super( "ServerThread");
		this.clientSocket = socket;
		this.clientNo = clientNo;
	} // constructor
	public void run() {
		String request = null; // try changing for isr rather than br
		//		 char request[] = new char[ 4];
		//		 int nChars = 0;

		try {

			osw = new OutputStreamWriter( clientSocket.getOutputStream());
			// the above line might need , "US-ASCII"); or // "UTF-8"?

			System.out.println( "Connection from: " + clientSocket.getInetAddress());
			isr = new InputStreamReader( clientSocket.getInputStream());
			// the above line might need , "US-ASCII"); or // "UTF-8"?
			br = new BufferedReader( isr);

			do {			 
				request = br.readLine(); // try changing for isr rather than br
				System.out.println( "\tFrom client " + clientNo + ": " + request);
				//				 nChars = isr.read( request, 0, request.length);
				//				 System.out.println( "\tReceived: " + new String( request, 0, nChars));

				// What happens if we don't send '\r\n' or only one of them?
				osw.write( "Hello from "+ InetAddress.getLocalHost() + " to Client no: " + clientNo + "\r\n");
				osw.flush(); // make sure msg got sent from the buffer!
			} while( !request.equals( "END"));
			//			 } while( !(new String( request)).equals( "END"));

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
	} // run
} // class HandleClient