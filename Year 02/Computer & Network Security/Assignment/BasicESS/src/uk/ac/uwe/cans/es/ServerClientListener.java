package uk.ac.uwe.cans.es;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
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
    private String userName;
    private String plainPassword;
    private MessageDigest hashInput = null;
    private byte[] bytespass;
    private byte[] byteHashPass;
    private String hashedpass, inputusername;
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
            getUsernamePassword();

            try {
                hashInput = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            bytespass = FileUtils.getBytes(plainPassword.toCharArray());//convert string for hashing
            byteHashPass = hashInput.digest(bytespass);//hash byte[]
            hashedpass = new String(byteHashPass);//convert back to string
            inputusername = bin.readLine();
            if (userName.equals(inputusername)) {
                pout.println("SUCCESSUSER");
                pout.flush();
                String inputhash = bin.readLine();
                if (hashedpass.equals(inputhash)) {//result false currently
                    pout.println("SUCCESSPASS");
                    pout.flush();
                    //Task 4
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
                    //Task 4 END
                    //Transfer
                    //  clientMsg = bin.readLine();
                    System.out.println("Received content from the client: " + clientMsg);
                    // NOTE: This initial code assumes that the received string is the content 
                    // of the file to be encrypted. You will have to change the logic here
                    // depending on which task you are doing.

                    int res = encMgr.encryptAndSave(clientMsg);
                    // Inform the client of the result (+ve number means all ok)
                    pout.println(res);
                    pout.flush(); // rememebr to flush the PrintWriter in some cases. See PrintWriter documentation.
                } else {
                    pout.println("Password Incorrect");
                    pout.flush();
                }
            } else {
                pout.println("Username Incorrect");
                pout.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerClientListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getUsernamePassword() {
        List<String> creds = FileUtils.getCredentials();
        userName = creds.get(0);
        plainPassword = creds.get(1);

        //System.out.println("Username: " + userName + ", Plain password: " + plainPassword);
    }

    private void dhKeyExchange() throws InvalidKeyException, IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        // Set up server
        ServerSocket ESSocket = new ServerSocket(6969);
        Socket accept = ESSocket.accept();
        dis = new DataInputStream(accept.getInputStream());
        dos = new DataOutputStream(accept.getOutputStream());
        //get public key from client
        int size = dis.readInt();
        byte[] clientEncodedPubKey = new byte[size];
        dis.read(clientEncodedPubKey);
        //get client public key
        KeyFactory ESKeyFac = KeyFactory.getInstance("DH");
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(clientEncodedPubKey);
        clientPubKey = ESKeyFac.generatePublic(x509KeySpec);
        //get client parameters
        DHParameterSpec dhParamSpec = ((DHPublicKey) clientPubKey).getParams();
        // ES generates key pair
        KeyPairGenerator ESKpairGen = KeyPairGenerator.getInstance("DH");
        ESKpairGen.initialize(dhParamSpec);
        KeyPair ESKpair = ESKpairGen.generateKeyPair();
        //create keyagreement object
        ESKeyAgree = KeyAgreement.getInstance("DH");
        ESKeyAgree.init(ESKpair.getPrivate());
        //encode public key
        byte[] ESPubKeyEnc = ESKpair.getPublic().getEncoded();
        //send key
        int sizeout = ESPubKeyEnc.length;
        dos.writeInt(sizeout);
        dos.write(ESPubKeyEnc);
        //Phase 1
        ESKeyAgree.doPhase(clientPubKey, true);
        //generate shared secret
        byte[] ESSharedSecret = ESKeyAgree.generateSecret();
        int ESLen = ESSharedSecret.length;

        //Decryption
        //create DES secret key
        ESKeyAgree.doPhase(clientPubKey, true);
        SecretKey ESDesKey = ESKeyAgree.generateSecret("DES");
        System.out.println("Creating cipher");
        //create cipher
        Cipher ESCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        ESCipher.init(Cipher.DECRYPT_MODE, ESDesKey);
        //recieve ciphertext
        int encsize = dis.readInt();
        byte[] ciphertext = new byte[encsize];
        dis.read(ciphertext);
        //clientMsg = bin.readLine();
        //decrypt cipher text
       // byte[] ciphertext = FileUtils.getBytes(clientMsg.toCharArray());
        byte[] recovered = ESCipher.doFinal(ciphertext);

        clientMsg = new String(recovered);
        dos.close();
        dis.close();
        accept.close();
        ESSocket.close();
    }
}