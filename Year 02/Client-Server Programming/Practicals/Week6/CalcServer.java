package year2.CSP.Week6;

import java.io.*;
import java.net.*;

class CalcServer {

    public static void main(String argv[]) throws Exception {
        int operator, operand1, operand2, clientCount = 0;
        double result;
        String symbolOperator;

        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("The server is running...");

        while (true) {

            System.out.println("Clients served: " + clientCount);
            Socket dataSocket = welcomeSocket.accept();

            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));

            PrintWriter outToClient =
                    new PrintWriter(
                    new OutputStreamWriter(
                    dataSocket.getOutputStream()));

            operator = inFromClient.read();
            System.out.println("operator = " + operator);
            operand1 = inFromClient.read();
            System.out.println("operand1 = " + operand1);
            operand2 = inFromClient.read();
            System.out.println("operand2 = " + operand2);
            
            if (operator == 1) {
              result = operand1 + operand2;
            } else if (operator == 2) {
                result = operand1 - operand2;
            } else if (operator == 3) {
                result = operand1 * operand2;
            } else if (operator == 4) {
                result = operand1 / operand2;
            } else {
                System.out.println("Operator selected was not valid");
                result = 0;
            }
            
            outToClient.println(result);
            outToClient.flush();

            clientCount++;
        }


    } // end class
}