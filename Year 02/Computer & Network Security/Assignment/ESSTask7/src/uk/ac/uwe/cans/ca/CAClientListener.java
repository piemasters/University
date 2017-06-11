package uk.ac.uwe.cans.ca;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import uk.ac.uwe.cans.es.ServerClientListener;
import uk.ac.uwe.cans.util.CertificateGenerator;
import uk.ac.uwe.cans.util.FileUtils;

/**
 * This class contains the functionality to handle client connections over a
 * socket. You will have to add functionality to the run() method to receive a
 * client's public key and get is signed by the CA's private key and then return
 * the signed certificate to the client.
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
    private String user, pass;
    private DataInputStream dis;
    private DataOutputStream dos;
    private KeyAgreement ESKeyAgree;
    private PublicKey clientPubKey;
    private String clientMsg;

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
     * TODO Receive a client's public key and get is signed by the CA's private
     * key and then return the signed certificate to the client.
     *
     * Hint: You could use any suitable streams over the socket, but
     * ObjectInput/OutputStream should be the easiest and safest choice in my
     * opinion.
     */
    @Override
    public void run() {
        ObjectOutputStream oos = null;
        try {
            // Read in public key
            oos = new ObjectOutputStream(clSock.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clSock.getInputStream());
            PublicKey pk = (PublicKey) ois.readObject();

            // Read in hashed username & password
            bin = new BufferedReader(new InputStreamReader(clSock.getInputStream()));
            pout = new PrintWriter(clSock.getOutputStream(), true);
//            String usernamein = bin.readLine();
//            String passwordin = bin.readLine();
//
//            // Get database details
//            List<String> credentials = FileUtils.getCredentials();
//            user = credentials.get(0);
//            pass = credentials.get(1);
//
//            // Hash stored password
//            MessageDigest hashIn = MessageDigest.getInstance("MD5");
//            // Convert string to enable hashing
//            byte[] passBytes = FileUtils.getBytes(pass.toCharArray());
//            // Create hashed byte array 
//            byte[] byteHashPass = hashIn.digest(passBytes);
//            // Convert to String
//            String passwordHash = new String(byteHashPass);
//
//            // Check authentication
//            boolean auth = PassAuth(usernamein, passwordin, user, passwordHash);
//            System.out.println("Authentication Check Result: " + auth);

            //If successfully authenticated


                //Sign the client's public key and generate a certificate
                X509Certificate clientSignedCert = CertificateGenerator.generateCertificate(pk, 365, "SHA1withDSA", ca.caKeyPair.getPrivate());

                // Send the certificate to the client
                pout.println("CERTSUCCESS");
                pout.flush();
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

    private void dhKeyExchange() throws InvalidKeyException, IOException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeySpecException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException {

        // Server Setup
        ServerSocket ESSocket = new ServerSocket(7777);
        Socket accept = ESSocket.accept();
        dis = new DataInputStream(accept.getInputStream());
        dos = new DataOutputStream(accept.getOutputStream());

        // Get public key from client
        int size = dis.readInt();
        byte[] clientEncodedPubKey = new byte[size];
        dis.read(clientEncodedPubKey);

        // Get client public key
        KeyFactory ESKeyFac = KeyFactory.getInstance("DH");
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(clientEncodedPubKey);
        clientPubKey = ESKeyFac.generatePublic(x509KeySpec);

        // Get client parameters
        DHParameterSpec dhParamSpec = ((DHPublicKey) clientPubKey).getParams();

        // Encryption Server generates key pair
        KeyPairGenerator ESKpairGen = KeyPairGenerator.getInstance("DH");
        ESKpairGen.initialize(dhParamSpec);
        KeyPair ESKpair = ESKpairGen.generateKeyPair();

        // Create key-agreement object
        ESKeyAgree = KeyAgreement.getInstance("DH");
        ESKeyAgree.init(ESKpair.getPrivate());

        // Encode public key
        byte[] ESPubKeyEnc = ESKpair.getPublic().getEncoded();

        // Send key
        int sizeout = ESPubKeyEnc.length;
        dos.writeInt(sizeout);
        dos.write(ESPubKeyEnc);

        // Use client's pk for first phase
        ESKeyAgree.doPhase(clientPubKey, true);

        // Generate shared secret
        byte[] ESSharedSecret = ESKeyAgree.generateSecret();
        int ESLen = ESSharedSecret.length;

        //Decryption - Create DES secret key
        ESKeyAgree.doPhase(clientPubKey, true);
        SecretKey ESDesKey = ESKeyAgree.generateSecret("DES");
        System.out.println("Creating cipher");

        // Create cipher
        Cipher ESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        ESCipher.init(Cipher.DECRYPT_MODE, ESDesKey);
        System.out.println("Cipher created");

        // Recieve ciphertext
        int encsize = dis.readInt();
        byte[] ciphertext = new byte[encsize];
        dis.read(ciphertext);

        //decrypt cipher text
        byte[] recovered = ESCipher.doFinal(ciphertext);
        clientMsg = new String(recovered);

        dos.close();
        dis.close();
        accept.close();
        ESSocket.close();
    }

    private boolean PassAuth(String userIn, String passIn, String user, String pass) {

        boolean auth = false;

        if (userIn.equals(user)) {
            System.out.println("Username correct");

            if (passIn.equals(pass)) {
                System.out.println("Password correct");
                auth = true;
            }
        }
        return auth;
    }
}