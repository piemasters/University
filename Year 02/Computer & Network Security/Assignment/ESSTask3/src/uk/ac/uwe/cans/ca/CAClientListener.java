package uk.ac.uwe.cans.ca;

import java.io.*;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.ac.uwe.cans.util.CertificateGenerator;

/**
 * This class contains the functionality to handle client connections over a socket.
 * You will have to add functionality to the run() method to receive a client's
 * public key and get is signed by the CA's private key and then return the
 * signed certificate to the client.
 * 
 * CAClientListener.java (UTF-8) Jan 24, 2013
 *
 * @author Saad Liaquat Kiani<saad2.liaquat@uwe.ac.uk>
 */
public class CAClientListener extends Thread {

    private BufferedReader bin;
    private BufferedWriter bout;
    private PrintWriter pout;
    private Socket clSock;
    private CansCA ca;
    /**
     *
     * @param clientSocket
     * @throws IOException
     */
    public CAClientListener(CansCA ca, Socket clientSocket) throws IOException {
        super("ClientListener Thread");
        this.ca = ca;
        System.out.println("ClientListener initialised.");
        clSock = clientSocket;
    }

    /**
     * TODO Receive a client's
     * public key and get is signed by the CA's private key and then return the
     * signed certificate to the client.
     * 
     * Hint: You could use any suitable streams over the socket, but 
     * ObjectInput/OutputStream should be the easiest and safest choice in my 
     * opinion.
     */
    @Override
    public void run() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(clSock.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clSock.getInputStream());
            PublicKey pk = (PublicKey) ois.readObject();
            System.out.println("Client's publickey: " + pk.toString());
            
            //Sign the client's public key and generate a certificate
            X509Certificate clientSignedCert = CertificateGenerator.generateCertificate(pk, 365, "SHA1withRSA", ca.caKeyPair.getPrivate());
            //send the certificate to the client
            oos.writeObject(clientSignedCert);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(CAClientListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CAClientListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CAClientListener.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CAClientListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}