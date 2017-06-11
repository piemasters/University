package uk.ac.uwe.cans.util;

import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import uk.ac.uwe.cans.cl.FileClient;

/**
 * This class contains various utility methods for use in your assignment tasks.
 *
 * FileUtils.java (UTF-8) Jan 24, 2013
 *
 * @author Saad Liaquat Kiani<saad2.liaquat@uwe.ac.uk>
 */
public class FileUtils {

    /**
     * This method gets the public/private key pair from a keystore.
     * @param keystorePath Absolute path to the keystore containing the keys
     * @param keystorePass Keystore password
     * @param keyAlias Alias of the key
     * @param keyPass Password to access the key
     * @return A KeyPair object containing the public and private keys
     * @throws FileNotFoundException
     * @throws KeyStoreException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws UnrecoverableKeyException
     */
    public static KeyPair getKeysFromKeystore(String keystorePath, String keystorePass, String keyAlias, String keyPass) throws FileNotFoundException, KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {
        FileInputStream fis = new FileInputStream(keystorePath);
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(fis, keystorePass.toCharArray());
        PublicKey publicKey = null;
        Key key = keystore.getKey(keyAlias, keyPass.toCharArray());
        if (key instanceof PrivateKey) {
            // Get certificate of public key
            X509Certificate cert = (X509Certificate) keystore.getCertificate(keyAlias);
            // Get public key
            publicKey = cert.getPublicKey();
        }
        return new KeyPair(publicKey, (PrivateKey) key);
    }

    /**
     * This method adds a certificate to a keystore
     * @param keystorePath Absolute path to the keystore
     * @param keystorePass Keystore password
     * @param certAlias Certificate alias
     * @param signedCert The certificate being added to the keystore
     * @throws FileNotFoundException
     * @throws KeyStoreException
     * @throws IOException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException 
     */
    public static void addCertToKeystore(String keystorePath, String keystorePass, String certAlias, X509Certificate signedCert){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(keystorePath);
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(fis, keystorePass.toCharArray());
            keystore.setCertificateEntry(certAlias, signedCert);
            FileOutputStream fos = new FileOutputStream(keystorePath);
            keystore.store(fos, keystorePass.toCharArray());
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyStoreException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method converts a PublicKey object to Base64 representation 
     * http://janiths-codes.blogspot.co.uk/2009/11/how-to-convert-publickey-as-string-and.html
     * 
     * @param pubKey  The PublicKey object
     * @return The Base64 representation of the PublicKey
     */
    public static String publicKeyToBase64String(PublicKey pubKey) {
        // Send the public key bytes to the other party...
        byte[] publicKeyBytes = pubKey.getEncoded();

        //Convert Public key to String
        BASE64Encoder encoder = new BASE64Encoder();
        String pubKeyStr = encoder.encode(publicKeyBytes);
        return pubKeyStr;
    }

    /**
     * This method converts a Base64 representation of a publick key into 
     * a PubliKey object. 
     * http://janiths-codes.blogspot.co.uk/2009/11/how-to-convert-publickey-as-string-and.html
     *
     * @param base64String The Base64 representation of the PublicKey
     * @return PublicKey
     * @throws IOException
     */
    public static PublicKey Base64StringToPublicKey(String base64String) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
        //Convert PublicKeyString to Byte Stream
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] sigBytes2 = decoder.decodeBuffer(base64String);

        // Convert the public key bytes into a PublicKey object
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(sigBytes2);
        KeyFactory keyFact = KeyFactory.getInstance("RSA");
        PublicKey pubKey = keyFact.generatePublic(x509KeySpec);
        return pubKey;
    }

    /**
     * This method returns a username,password from a text file (in which they are 
     * stored as comma separated strings. See authdb.txt file. 
     * 
     * The following method assumes there is just one username and password
     * separated by a comma (,) in the authdb.txt file.
     *
     * @return a List<String> object containing a username in the first location
     * and the password in the second location.
     */
    public static List<String> getCredentials() {
        String fileContent = "";
        BufferedInputStream bis = (BufferedInputStream) FileClient.class.getClassLoader().getResourceAsStream("Files/authdb.txt");
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
        List<String> creds = Arrays.asList(fileContent.split("\\s*,\\s*"));
        return creds;
    }

    /**
     * Utility method to safely convert a character array into a byte array
     *
     * @param charArray
     * @return a byte array
     */
    public static byte[] getBytes(char[] charArray) {
        byte[] byteArray = new byte[charArray.length * 2];
        java.nio.ByteBuffer.wrap(byteArray).asCharBuffer().put(charArray);
        return byteArray;
    }

    /**
     * Utility method to safely convert a byte array into a character array
     *
     * @param byteArray
     * @return a character array
     */
    public static char[] getChars(byte[] byteArray) {
        char[] charArray = new char[byteArray.length / 2];
        java.nio.ByteBuffer.wrap(byteArray).asCharBuffer().get(charArray);
        return charArray;
    }
}
