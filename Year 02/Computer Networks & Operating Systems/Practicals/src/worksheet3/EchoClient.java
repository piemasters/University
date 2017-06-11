package worksheet3;
//
// EchoClient.java
// This attempts to connect to the echo port of a server.
// e.g. java EchoClient [IPaddr]
//
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class EchoClient {
	public void EchoClient() {} // constructor
	public static void main(String[] args) throws IOException {
		
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String host = "127.0.0.1";
		
		if( args.length != 0) host = args[ 0];
		try {
			
			Scanner scan = new Scanner(System.in);
			int portNo;
			System.out.print( "Enter port number: ");
			portNo = scan.nextInt();
			
			echoSocket = new Socket( host, portNo); // modify so portNo is cmd line!
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader( echoSocket.getInputStream()));
		}
		catch (UnknownHostException e) { // hostname cannot be resolved to ipaddr!
			System.err.println("Don't know host named: " + host);
			System.exit(1);
		}
		catch (IOException e) { // ipaddr doesn't locate a host
			System.err.println("Couldn't get I/O for " + "the connection to: " + host);
			System.exit(1);
		}
		
		BufferedReader stdIn = new BufferedReader( new
		InputStreamReader(System.in));
		String userInput;
		
		do {
			System.out.print( "Enter some text to echo (END = exit): ");
			System.out.flush();
			userInput = stdIn.readLine();
			out.println(userInput);
			System.out.println("\techo: " + in.readLine());
		} while( !userInput.equals( "END"));
		
		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	} // main
} // class EchoClient
