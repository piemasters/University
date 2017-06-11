package uk.ac.uwe.cans.cl;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.DHParameterSpec;
import javax.net.ssl.*;
import uk.ac.uwe.cans.util.FileUtils;

/**
 *
 * FileClient.java (UTF-8) Jan 24, 2013
 *
 * @author Saad Liaquat Kiani<saad2.liaquat@uwe.ac.uk>
 */
public class FileClient {

    private String userName;
    private String plainPassword;
    private String passwordHash = null;
    private Socket sock;
    private BufferedReader bin;
    private BufferedWriter bout;
    private DataInputStream dis;
    private DataOutputStream dos;
    private PrintWriter pout;
    private String fileContent = "";
    private boolean connected = false;
    // SERVER related variables
    private final String SERVER_HOST = "localhost";
    private final int SERVER_PORT = 9999;
    private final int SERVER_SSL_PORT = 9993;
    // CA related variables
    private final int CA_PORT = 8888;
    private final int CA_SSL_PORT = 8883;
    private final String CA_HOST = "localhost";
    // SSL and PKI related variable
    public final String keystoreName = "cl.keystore";
    public final String keystorePath = "/Users/slk/NetBeansProjects/BasicESS/src/Files/" + keystoreName;
    public final String keystorePassword = "clkeystore";
    private KeyPair clKeyPair;
    public final String keyAlias = "mykey";
    public final String keyPassword = "clkeystore";

    /**
     * Constructor
     *
     * @throws IOException
     * @throws UnknownHostException
     * @throws ClassNotFoundException
     */
    public FileClient() throws IOException, UnknownHostException, ClassNotFoundException, NoSuchAlgorithmException {

        System.out.println("Client initialised.");
        System.out.println("Connecting to the server ...");

        //Connect to the server
        connected = connectToServer();
        if (connected) {
            getFileContent();
            getUsernamePassword();
            doWork();
        } else if (!connected) {
            System.out.println("Couldn't connect to the server; Exiting");
            System.exit(-1);
        }

        //Connect to the CA
        //connectCA();

        //Connect to Server over SSL
        //connectServer_SSL();
    }

    /**
     * Gets the username and password from the authdb.txt file by using the
     * utility method in FileUtils class.
     */
    private void getUsernamePassword() throws NoSuchAlgorithmException {
        List<String> creds = FileUtils.getCredentials();
        userName = creds.get(0);
        plainPassword = creds.get(1);
    }

    /**
     * Do the core task related work here.
     *
     * @throws IOException
     */
    private void doWork() throws IOException, NoSuchAlgorithmException {

        // Task 2
        // Trivial Password based authentication
        // doTrivialPBE(userName, plainPassword);
        

        // Task 3
        // Better password based authentication
        // doPasswordBasedAuthentication(userName, passwordHash);
        Scanner authScan = new Scanner(System.in);
        System.out.print("Username: ");
        String usernameInput = authScan.nextLine();// Grab user input for username
        System.out.print("\nPassword: ");
        String passwordInput = authScan.nextLine();// Grab user input for password
        
        MessageDigest hashInput = MessageDigest.getInstance("MD5");
        byte[] passBytes = FileUtils.getBytes(passwordInput.toCharArray());//convert String for hashing
        byte[] byteHashPass = hashInput.digest(passBytes);//hashed byte array 

        passwordHash = new String(byteHashPass);//convert hashed bytes[] to string
        boolean authenticated = doPasswordBasedAuthentication(usernameInput, passwordHash);
        // Task 4
        if (authenticated == true) {
            System.out.println("Authentication Successful");

            // Send file content to the server
            
            int trasnferStatus = -10;
            try {
                trasnferStatus = transfer();
            } catch (InvalidKeyException ex) {
                Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidAlgorithmParameterException ex) {
                Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidParameterSpecException ex) {
                Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            //If file transferred correctly
            if (trasnferStatus >= 0) {
                // Tell the user etc.
                System.out.println("Transfer Successful");
            }
        } else {
            System.out.println("Authentication Failure");
        }
    }
    
    private boolean doPasswordBasedAuthentication(String user, String hashpass) throws IOException{
        boolean authentication = false;
        pout.println(user);
        pout.flush();
        String ESResponse = bin.readLine();
        if(ESResponse.equals("SUCCESSUSER")){
        System.out.println("Username Correct");
        pout.println(hashpass);
        pout.flush();
        String ESResponses = bin.readLine();
        if(ESResponses.equals("SUCCESSPASS")){
            authentication = true;
        }else{
            System.out.println("pass error");
        }
    }else{
        System.out.println("user error");
    }
    return authentication;
}

/**
    *
    * @return
    */
private boolean connectToServer() {
    try {
        sock = new Socket(SERVER_HOST, SERVER_PORT);
        pout = new PrintWriter(sock.getOutputStream(), true);
        bin = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        connected = true;
    } catch (UnknownHostException ex) {
        System.err.println("Can not find host: " + SERVER_HOST);
        connected = false;
        Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        System.err.println("Can not get I/O for connecting to the host: " + SERVER_HOST);
        connected = false;
        Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
    }
    return connected;
}

/**
    * Returns the contents of the file to be transferred as a String and
    * assigns to the fileContent variable.
    *
    * NOTE: Keep the file content simple, plain text and do not use any binary
    * file. Once you have completed the file, you can try with binary files if
    * you want.
    */
private void getFileContent() {
    BufferedInputStream bis = (BufferedInputStream) FileClient.class.getClassLoader().getResourceAsStream("Files/Plain.txt");
    if (bis != null) {
        try {
            while (bis.available() > 0) {
                fileContent += ((char) bis.read());
            }
        } catch (IOException ex) {
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                } else if (bis == null) {
                    System.err.println("BufferedInputStream was NULL!");
                }
            } catch (IOException ex) {
                Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    System.out.println("File content is:\n" + fileContent);
}

    /**
     * Sends the file content to the server over socket
     *
     * @return status integer
     * @throws IOException
     */
    private int transfer() throws IOException, InvalidKeyException, IllegalStateException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidParameterSpecException {
        String serverResp = null;
        System.out.println("Writing file content to server.");

        // Write the file's contents in the printwriter.
        // Note: For Task 4, encrypt using DH symmetric Key before transfer
        // Set up server
        Socket clientSocket = new Socket("localhost", 6969);
        dis = new DataInputStream(clientSocket.getInputStream());
        dos = new DataOutputStream(clientSocket.getOutputStream());
        System.out.println("connected");
        // Diffie-Hellman
        //generate parameters
        AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator.getInstance("DH");
        paramGen.init(512);
        AlgorithmParameters params = paramGen.generateParameters();
        DHParameterSpec dh = (DHParameterSpec)params.getParameterSpec(DHParameterSpec.class);
        //Create DH keypair
        KeyPairGenerator clientKpairGen = KeyPairGenerator.getInstance("DH");
        clientKpairGen.initialize(dh);
        KeyPair clientKpair = clientKpairGen.generateKeyPair();
        //create an instantiate DH keyagreement object
        KeyAgreement clientKeyAgree = KeyAgreement.getInstance("DH");
        clientKeyAgree.init(clientKpair.getPrivate());
        //encode key
        byte[] clientPubKeyEnc = clientKpair.getPublic().getEncoded();
        // send key
        int outsize = clientPubKeyEnc.length;
        dos.writeInt(outsize);
        dos.write(clientPubKeyEnc);
        //read in ES key
        int size = dis.readInt();
        byte[] ESEncodedPubKey = new byte[size];
        dis.read(ESEncodedPubKey);
        //get ES public key
        KeyFactory clientKeyFac = KeyFactory.getInstance("DH");
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(ESEncodedPubKey);
        PublicKey ESPubKey = clientKeyFac.generatePublic(x509KeySpec);
        //Phase 1
        clientKeyAgree.doPhase(ESPubKey, true);
        //generate shared secret key
        byte[] clientSharedSecret = clientKeyAgree.generateSecret();
        int clientLen = clientSharedSecret.length;

        //Encryption
        //create DES secret key
        clientKeyAgree.doPhase(ESPubKey, true);
        SecretKey clientDesKey = clientKeyAgree.generateSecret("DES");
        //create cipher
        Cipher clientCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        clientCipher.init(Cipher.ENCRYPT_MODE, clientDesKey);
        //encrypt plain text
        byte[] cleartext = FileUtils.getBytes(fileContent.toCharArray());
        byte[] ciphertext = clientCipher.doFinal(cleartext);
        //send size and cipher text
        dos.writeInt(ciphertext.length);
        dos.write(ciphertext);
        fileContent = new String(ciphertext);    
        // Task 4 End
        //pout.println(fileContent);
        System.out.println("Wrote file content to the server.");
        //Get the server's response
        serverResp = bin.readLine();
        int status = new Integer(serverResp).intValue();
        if (status >= 0) {
            //file transfered correctly, tell the user
            System.out.println("File encrypted and saved correctly.");
        } else if (status < 0) {
            System.out.println("File NOT encrypted and saved correctly.");
        }
        return status;
    }

    /**
     * Connect to the CA and send over the client's public key for signing and
     * get back a signed certificate. Store that signed certificate in an
     * "APPROPRIATE" location.
     *
     * @throws UnknownHostException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     */
    private void connectCA() throws UnknownHostException, IOException, ClassNotFoundException, FileNotFoundException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
        String publicKeyBase64String = null;
        try {
            // Get client's key pair from the keystore
            clKeyPair = FileUtils.getKeysFromKeystore(keystorePath, keystorePassword, keyAlias, keyPassword);
            System.out.println("Public key: " + clKeyPair.getPublic().toString());
            // Convert it into Base64 before sending to the CA (if you want, 
            // there are other ways of doing this that do not require you to
            // do this e.g. sending in an object stream)
            publicKeyBase64String = FileUtils.publicKeyToBase64String(clKeyPair.getPublic());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyStoreException ex) {
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnrecoverableKeyException ex) {
            Logger.getLogger(FileClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket clientCAsock = new Socket(CA_HOST, CA_PORT);

        clientCAsock.close();
    }

    /**
     * Connect to the server over SSL.
     *
     * NOTE: This method is there for your info only. And it does not connect to
     * the server, but rather the CA over SSL. You can learn how to make SSL
     * connection from this method (and the corresponding one in the CA), but to
     * connect to the Server over SSL you will have to modify this method.
     */
    private void connectServer_SSL() {
        // Registering the JSSE provider
        Security.addProvider(new com.sun.crypto.provider.SunJCE());

        //Specifying the Keystore details
        //System.setProperty("javax.net.ssl.keyStore", keystorePath);
        System.setProperty("javax.net.ssl.trustStore", keystorePath);
        System.setProperty("javax.net.ssl.keyStorePassword", keystorePassword);
        System.setProperty("javax.net.ssl.trustPassword", keystorePassword);

        // Enable debugging to view the handshake and communication which happens between the SSLClient and the SSLServer
        //System.setProperty("javax.net.debug","all");

        try {
            // Creating Client Sockets
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslsocketfactory.createSocket(CA_HOST, CA_SSL_PORT);

            // Initializing the streams for Communication with the Server
            pout = new PrintWriter(sslSocket.getOutputStream(), true);
            bin = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            String clientSSLmsg = "Hello Testing Client-CA SSL";
            pout.println(clientSSLmsg);
            System.out.println("CA's response over SSL: " + bin.readLine());

            // Closing the Streams and the Socket
            pout.close();
            bin.close();
            sslSocket.close();
        } catch (Exception exp) {
            System.out.println(" Exception occurred .... " + exp);
            exp.printStackTrace();
        }
    }

    public static void main(String args[]) throws IOException, UnknownHostException, ClassNotFoundException, NoSuchAlgorithmException {
        FileClient client = new FileClient();
    }
}