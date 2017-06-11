package year2.CSP.Week6;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class CalcClient {

    public static void main(String argv[]) throws Exception {
        int operator, operand1, operand2;
        double result;
        String symbolOperator;

        Scanner inFromUser = new Scanner(System.in);

        Socket clientSocket = new Socket("LocalHost", 6789);

        PrintWriter outToServer =
                new PrintWriter(
                new OutputStreamWriter(
                clientSocket.getOutputStream()));

        BufferedReader inFromServer =
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Please select an operator:\n"
                + "Plus       [+]    Press 1\n"
                + "Minus      [-]    Press 2\n"
                + "Multiply   [*]    Press 3\n"
                + "Divide     [/]    Press 4");

        operator = inFromUser.nextInt();
        
        if (operator == 1) {
            symbolOperator = "+";
        } else if (operator == 2) {
            symbolOperator = "-";
        } else if (operator == 3) {
            symbolOperator = "*";
        }  else if (operator == 2) {
            symbolOperator = "/";
        } else {
            symbolOperator = "Invalid Input";
            
        }

        System.out.print("Please enter your first operand:  ");
        operand1 = inFromUser.nextInt();
        System.out.print("Please enter your second operand: ");
        operand2 = inFromUser.nextInt();


        outToServer.println(operator);
        outToServer.flush();
        outToServer.println(operand1);
        outToServer.flush();
        outToServer.println(operand2);
        outToServer.flush();

        result= inFromServer.read();

        System.out.println("The result for " + operand1 +  " " + symbolOperator + " " + operand2 + " = " + result);

        clientSocket.close();

    }
} // end class

