package uk.ac.uwe.cans.es;

import java.io.*;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import uk.ac.uwe.cans.util.FileUtils;

/**
 * This class handles individual client connections. The initial code only
 * handles one pair of one-line messages in either direction.
 *
 * Mostly, this will be the class you will have to tinker with to carry out
 * various tasks specified in the assignment.
 *
 * ServerClientListener.java (UTF-8) Jan 24, 2013
 *
 * @author Saad Liaquat Kiani<saad2.liaquat@uwe.ac.uk>
 */
public class ServerClientListener extends Thread {

    private BufferedReader bin;
    private BufferedWriter bout;
    private PrintWriter pout;
    private Socket clSock;
    private EncryptionManager encMgr;
    private MessageDigest hashIn = null;
    private byte[] bytePass;
    private byte[] hashBytePass;
    private String passHash, userIn;

    /**
     *
     * @param clientSocket
     * @throws IOException
     */
    public ServerClientListener(Socket clientSocket) throws IOException {
        super("ClientListener Thread");
        System.out.println("ClientListener initialised.");
        encMgr = new EncryptionManager();
        clSock = clientSocket;
        bin = new BufferedReader(new InputStreamReader(clSock.getInputStream()));
        pout = new PrintWriter(clSock.getOutputStream(), true);
    }

    /**
     * This is the initial version of the ServerClientListener thread's run()
     * method.
     */
    @Override
    public void run() {
        try {
            // Get user-pass combo from file
            List<String> creds = FileUtils.getCredentials();
            String username = creds.get(0);
            String password = creds.get(1);
            
            try {
                hashIn = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("Error collecting hashIn");
            }
            
            // Convert string to enable hashing
            bytePass = FileUtils.getBytes(password.toCharArray());
            // Create hashed byte array
            hashBytePass = hashIn.digest(bytePass);//hash byte[]
            
            // Convert hashed bytes array to a string
            passHash = new String(hashBytePass);//convert back to string
            
            // Get user input
            userIn = bin.readLine();

            // Check user input against file
            if (userIn.equals(username)) {

                pout.println("USEROK");
                pout.flush();
                // Get user input
                String passIn = bin.readLine();

                if (passIn.equals(passHash)) {

                    pout.println("PASSOK");
                    pout.flush();

                    String clientMsg = bin.readLine();
                    System.out.println("Received content from the client: " + clientMsg);

                    // NOTE: This initial code assumes that the received string is the content 
                    // of the file to be encrypted. You will have to change the logic here
                    // depending on which task you are doing.
                    int res = encMgr.encryptAndSave(clientMsg);
                    // Inform the client of the result (+ve number means all ok)
                    pout.println(res);
                    pout.flush(); // rememebr to flush the PrintWriter in some cases. See PrintWriter documentation.
                } else {
                    pout.println("Password Error");
                }
            } else {
                pout.println("Username Error");
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}