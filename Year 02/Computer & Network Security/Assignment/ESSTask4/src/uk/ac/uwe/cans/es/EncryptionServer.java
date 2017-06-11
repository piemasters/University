package uk.ac.uwe.cans.es;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the main EncryptionServer class that listens for incoming client
 * connections. When a client connects, functionality is passed on the the
 * ServerClientListener class
 *
 * EncryptionServer.java (UTF-8) Jan 24, 2013
 *
 * @author Saad Liaquat Kiani<saad2.liaquat@uwe.ac.uk>
 */
public class EncryptionServer {

    public static final int SERVER_LISTENING_PORT = 9999;
    public static final int SERVER_SSL_LISTENING_PORT = 9993;
    
    private ServerSocket serverSocket = null;

    public EncryptionServer() {
        System.out.println("Encryption Server initialised.");
        // Open server socket for listening
        try {
            serverSocket = new ServerSocket(SERVER_LISTENING_PORT);
            System.out.println("EncryptionServer listening on port " + SERVER_LISTENING_PORT);
        } catch (IOException se) {
            System.err.println("EncryptionServer cannot listen on port " + SERVER_LISTENING_PORT);
            System.exit(-1);
        }
        //Listen for incoming client connections
        listen();
    }

    private void listen() {
        // Accept and handle incoming client connections
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getInetAddress());
                ServerClientListener clientListener =
                        new ServerClientListener(clientSocket);
                clientListener.start();
            } catch (IOException ioe) {
                Logger.getLogger(EncryptionServer.class.getName()).log(Level.SEVERE,
                    null, ioe);
            }
        }
    }

    public static void main(String args[]) {
        EncryptionServer es = new EncryptionServer();
    }
}
