package year2.CSP.Week6;

import java.io.*;
import java.net.*;

class TCPServer {

    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String responseSentence;

        ServerSocket welcomeSocket = new ServerSocket(6789);
        
        System.out.println("The server is running...");
        
        int clientCount =0;
        
        while (true) {
            
            System.out.println("Clients served: " + clientCount);

            Socket dataSocket = welcomeSocket.accept();

            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));

            PrintWriter outToClient =
                    new PrintWriter(
                    new OutputStreamWriter(
                    dataSocket.getOutputStream()));

            clientSentence = inFromClient.readLine();

            responseSentence = clientSentence.toUpperCase();

            outToClient.println(responseSentence);
            outToClient.flush();
            
            clientCount ++;
        }


    } // end class
}