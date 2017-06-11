package year2.CSP.Week6;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPClient {

    public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence;

        Scanner inFromUser = new Scanner(System.in);

        Socket clientSocket = new Socket("LocalHost", 6789);

        PrintWriter outToServer =
                new PrintWriter(
                new OutputStreamWriter(
                clientSocket.getOutputStream()));

        BufferedReader inFromServer =
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
       
        System.out.println("Please enter a sentence.");
        sentence = inFromUser.nextLine();

        outToServer.println(sentence);
        outToServer.flush();
        
        modifiedSentence = inFromServer.readLine();

        System.out.print("Your sentence capitalized from Server: \n\"" + modifiedSentence + "\"\n");

        clientSocket.close();

    }
} // end class

