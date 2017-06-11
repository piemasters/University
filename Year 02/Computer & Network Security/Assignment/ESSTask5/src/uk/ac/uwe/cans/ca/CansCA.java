package uk.ac.uwe.cans.ca;

import java.io.*;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.*;
import uk.ac.uwe.cans.util.FileUtils;

/**
 * This is the initial CaNS certificate authority (CA) class. The initial
 * implementation listens on the non-ssl server socket, and once a client
 * connects, passes control to CAClientListener object. In the CAClientListener
 * object, you have to implement the required functionality in the run() method
 * to receive the client's public key and get it signed by the CA private key
 * and return to the client.
 *
 * CansCA.java (UTF-8) Jan 24, 2013
 *
 * @author Saad Liaquat Kiani<saad2.liaquat@uwe.ac.uk>
 */
public class CansCA {

    // *************************   NOTE   ********************************* //
    // * YOU MUST UPDATE THE FOLLOWING VARIABLES ACCORDING TO YOUR SETUP ** //
    public final String keystoreName = "ca.keystore";
    public final String keystorePath = "/Users/slk/NetBeansProjects/BasicESS/src/Files/" + keystoreName;
    public final String keyAlias = "mykey";
    public final String keystorePassword = "cakeystore";
    public final String keyPassword = "cakeystore";
    // ************************   NOTE  END ******************************* //
    private final int CA_PORT = 8888;
    private final int CA_SSL_PORT = 8883;
    public KeyPair caKeyPair;

    /**
     * The default constructor of the CansCA class. Retrieves its keys from the
     * keystore and starts listening on the server socket.
     */
    public CansCA() {
        try {
            caKeyPair = FileUtils.getKeysFromKeystore(keystorePath, keystorePassword, keyAlias, keyPassword);
            listen();
            //listen_SSL();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CansCA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyStoreException ex) {
            Logger.getLogger(CansCA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CansCA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CansCA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(CansCA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnrecoverableKeyException ex) {
            Logger.getLogger(CansCA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * CansCA's server socket listens on the defined port and if the client
     * connects, its passes on the the CAClientListener object.
     */
    public void listen() {
        System.out.println("CA (Non SSL) initialised.");
        // Open server socket for listening
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(CA_PORT);
            System.out.println("CA listening on port " + CA_PORT);
        } catch (IOException se) {
            System.err.println("CA cannot listen on port " + CA_PORT);
            System.exit(-1);
        }

        // Accept and handle client connections
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getInetAddress());
                CAClientListener clientListener = new CAClientListener(this, clientSocket);
                clientListener.start();
            } catch (IOException ioe) {
                Logger.getLogger(CansCA.class.getName()).log(Level.SEVERE, null, ioe);
            }
        }
    }

    /**
     * This method is not used by the CansCA normally (you could use it if you want). 
     * Its main purpose here is to demonstrate how to setup the server side of an
     * SSL connection. 
     */
    public void listen_SSL() {
        // Registering the JSSE provider
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        //Specifying the Keystore details
        System.setProperty("javax.net.ssl.keyStore", keystorePath);
        System.setProperty("javax.net.ssl.trustStore", keystorePath);
        System.setProperty("javax.net.ssl.keyStorePassword", keystorePassword);
        System.setProperty("javax.net.ssl.trustPassword", keystorePassword);

        // Enable debugging to view the handshake and communication which happens between the SSLClient and the SSLServer
        //System.setProperty("javax.net.debug", "all");

        System.out.println("CA (SSL) initialised.");
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            FileInputStream fis = new FileInputStream(keystorePath);
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore = KeyStore.getInstance("JKS");
            keystore.load(fis, keystorePassword.toCharArray());
            kmf.init(keystore, keystorePassword.toCharArray());

            context.init(kmf.getKeyManagers(), null, null);
            SSLServerSocketFactory ssf = context.getServerSocketFactory();
            //SSLServerSocketFactory sslserversocketfactory =                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslserversocket =
                    (SSLServerSocket) ssf.createServerSocket(CA_SSL_PORT);
            System.out.println("CA listening on port " + CA_SSL_PORT);
            SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();

            InputStream is = sslsocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bin = new BufferedReader(isr);

            String msg = bin.readLine();
            System.out.println("Client said: " + msg);

            PrintWriter out = new PrintWriter(sslsocket.getOutputStream(), true);
            out.println("Hello from CA");
            out.flush();
            out.close();
        } catch (Exception ex) {
            Logger.getLogger(CansCA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        CansCA ca = new CansCA();
    }
}
