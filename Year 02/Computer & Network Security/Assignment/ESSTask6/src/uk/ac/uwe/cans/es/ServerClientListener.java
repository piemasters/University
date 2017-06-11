package uk.ac.uwe.cans.es;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
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
            userIn = username;

            // Check user input against file
            if (userIn.equals(username)) {

                pout.println("USEROK");
                pout.flush();
                // Get user input
                String passIn = passHash;

                if (passIn.equals(passHash)) {

                    pout.println("PASSOK");
                    pout.flush();
                    
                    try {
                        dhKeyExchange();
                    } catch (NoSuchPaddingException ex) {
                        Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalBlockSizeException ex) {
                        Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (BadPaddingException ex) {
                        Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidKeyException ex) {
                        Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidAlgorithmParameterException ex) {
                        Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvalidKeySpecException ex) {
                        Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //String clientMsg = bin.readLine();
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
        System.out.println("Cipher Created");
        
        
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
    
}