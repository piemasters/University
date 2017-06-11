package worksheet4;

//
// Web8000.java an HTTP Web server from Elliotte Rusty Harold.
// Listens on a socket waiting for a client to send a GET request.
// Always responds with the contents of a fixed text file!
//

import java.io.*;
import java.net.*;
import java.util.*;

public class Web8000 extends Thread {
	
	private byte[] header; // the message header
	private byte[] content; // the message content
	private final static int DEFAULT_PORT = 8000; // the default listening port
	private int port = DEFAULT_PORT;
	
	// constructor
	public Web8000( byte[] data, String encoding, String MIMEtype, int port) throws UnsupportedEncodingException {
		
		content = data; // set up the message content
		this.port = port; // use the port number passed
		String header = "HTTP/1.0 200 OK\r\n"
				+ "Server: Web8000 1.0\r\n"
				+ "Content-length: " + content.length + "\r\n"
				+ "Content-type: " + MIMEtype + "\r\n\r\n";
		// note the extra ‘\r\n’, see what happens if it is missing!
		this.header = header.getBytes( "ASCII"); // assume ASCII encoding system
		
	} // constructor
	
	// enable thread to deal with client
	public void run() {
		
		try {
			ServerSocket serverSock = new ServerSocket( port);
			// log details of server response on screen
			System.out.println( "Connecting on port: " + serverSock.getLocalPort());
			System.out.println( "Data to be sent: ");
			System.out.write( content);
			
			while( true) { // loop forever dealing with clients
				
				Socket clientSock = null;
				
				try {
					clientSock = serverSock.accept(); // get skt for client-server comms
					OutputStream out = new BufferedOutputStream( clientSock.getOutputStream());
					InputStream in = new BufferedInputStream( clientSock.getInputStream());
					
					// read request and assume buffer big enough!
					StringBuffer request = new StringBuffer( 800);
					int ch = 0;
					Boolean finished = false; // so we can read bytes until all of hdr.
					
					while( !finished) {
						
						ch = in.read(); // read next char (byte), actually returns int!
						
						if( ch == -1) { // did sender somehow fail during transmission?
							System.out.println( "Sender died?");
							finished = true;
						}
						else {
							// append the char to the string buffer
							System.out.print( (char)ch);
							request.append( (char)ch);
							
							if( ch == '\n') { // see if end of header
								if( request.toString().indexOf( "\r\n\r\n") != -1)
									finished = true; // what if "\r\r" or "\n\n"?
							}
							
						} // deal with bytes recvd
						
					} // while more bytes to read
					
					// check that it is an HTTP request. Should check for GET etc too!
					if( request.toString().indexOf("HTTP/") != -1) out.write( header); // okay so write MIMEtype hdr details
					// now send the actual data content
					out.write( content);
					out.flush(); // to make sure the buffer is emptied immediately
				
				} // try
				catch( IOException ioE) {
				}
				finally { // make sure this end of the connection gets closed
					if( clientSock != null) clientSock.close();
				}
				
			} // while forever
			
		} // try opening server socket
		
		catch( IOException ioE) {
			System.err.println( "Could not start server. Port in use!");
		}
		
	} // run()
	
	public static void main( String args[]) {
		
		try { 
			
			String fileName = "C:/Users/David/Dropbox/Public/David/University/2nd Year/EclipseWorkspace/CNOS/src/worksheet4/data.html"; // should be supplied by client!
			String contentType = "text/plain"; // make this depend on file extension
			// e.g. .html -> "text/html"
			InputStream in = new FileInputStream( fileName); // open file
			// array to hold contents of file
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int bite; 
			
			while( (bite = in.read()) != -1) // Now read bytes from file …
				out.write( bite); // … into byte stream
			
			// convert byte stream into an array of bytes ready for DatagramPacket
			byte [] data = out.toByteArray();
			int port = DEFAULT_PORT;
			String encoding = "ASCII";
			
			// create the thread to send the contents of the file to any connection!
			Thread thr = new Web8000( data, encoding, contentType, port);
			thr.start(); // start the thread to deal with the clients
			
		} // try
		
		catch( ArrayIndexOutOfBoundsException obE) {
			// useful for when args should have been supplied!
			System.err.println( "Usage: java Web8000 filename port encoding");
		}
		
		catch( Exception e) {
			String fileName = "C:/Users/David/Dropbox/Public/David/University/2nd Year/EclipseWorkspace/CNOS/src/worksheet4/error.html"; // should be supplied by client!
			
		}
		
	} // main
	
} // class Web8000