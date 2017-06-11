package uk.ac.uwe.sec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * A basic PKI based program that lets you generate a public/private key pair,
 * store it on file, encrypt plaintext using the public key and decrypt the
 * ciphertext using the private key.
 *
 * @author slk
 * @version 0.2
 */
public class BasicPKI {

    /**
     * This method generates an RSA based public private key pair and saves it
     * in two separate files public.key and private.key. It will also dump the
     * hexadecimal representation of the keys on the screen.
     *
     * 1024 bit key sizes are used to save computation time.
     */
    private static void generateKeys() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024);
            KeyPair kp = kpg.genKeyPair();
            Key publicKey = kp.getPublic();
            Key privateKey = kp.getPrivate();
            KeyFactory fact = KeyFactory.getInstance("RSA");
            dumpKeyPair(kp);
            saveToFile("./", kp);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is used to save the key pair on disk in two separate files -
     * public.key and private.key.
     *
     * @param path The path where the files should be saved. This parameter is
     * not in use currently.
     * @param keyPair The public-private key pair in question.
     * @throws IOException When dragons come, this is thrown.
     */
    private static void saveToFile(String path, KeyPair keyPair) throws IOException {
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Store Public Key.
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
                publicKey.getEncoded());
        FileOutputStream fos = new FileOutputStream("public.key");
        fos.write(x509EncodedKeySpec.getEncoded());
        fos.close();
        System.out.println("Public Key saved in : " + "public.key");
        // Store Private Key.
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
                privateKey.getEncoded());
        fos = new FileOutputStream(path + "private.key");
        fos.write(pkcs8EncodedKeySpec.getEncoded());
        fos.close();
        System.out.println("Private Key saved in : " + "private.key");
    }

    /**
     * This method will load the public and private keys from the files
     * (public.key and private.key respectively) and assign them into their
     * respective Object representations.
     *
     * @param path The directory path from where the on-disk files should be
     * read, but this parameter is not being used currently.
     * @param algorithm The algorithm on which hte public/private key files are
     * originally based upon. RSA in this case.
     * @return The KeyPair
     * @throws IOException When dragons come ...
     * @throws NoSuchAlgorithmException When dragons come ...
     * @throws InvalidKeySpecException When dragons come ...
     */
    public static KeyPair loadKeyPair(String path, String algorithm)
            throws IOException, NoSuchAlgorithmException,
            InvalidKeySpecException {
        // Read Public Key.
        File filePublicKey = new File("public.key");
        FileInputStream fis = new FileInputStream("public.key");
        byte[] encodedPublicKey = new byte[(int) filePublicKey.length()];
        fis.read(encodedPublicKey);
        fis.close();

        // Read Private Key.
        File filePrivateKey = new File("private.key");
        fis = new FileInputStream("private.key");
        byte[] encodedPrivateKey = new byte[(int) filePrivateKey.length()];
        fis.read(encodedPrivateKey);
        fis.close();

        // Generate KeyPair.
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
                encodedPublicKey);
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
                encodedPrivateKey);
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

        return new KeyPair(publicKey, privateKey);
    }

    /**
     * This method encrypts data bytes using the public key
     *
     * @param data the data to be encrypted
     * @return ciphertext bytes
     */
    public static byte[] rsaEncrypt(byte[] data) {
        byte[] cipherData = null;
        try {
            KeyPair kp = loadKeyPair(".", "RSA");
            Key publicKey = kp.getPublic();
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipherData = cipher.doFinal(data);
            FileOutputStream fos = new FileOutputStream("ciphertext.txt");
            fos.write(cipherData);
            fos.close();
            System.out.println("Ciphertext created using public key, saved in ciphertext.txt");
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cipherData;
    }

    /**
     * This method decrypts the ciphertext using the private key
     *
     * @param cipherText the ciphertext bytes to be decrypted
     * @return the plaintext byets
     */
    public static byte[] rsaDecrypt(byte[] cipherText) {
        byte[] plain = null;
        try {
            KeyPair kp = loadKeyPair(".", "RSA");
            Key privKey = kp.getPrivate();
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privKey);
            plain = cipher.doFinal(cipherText);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ciphertext decrypted using private key, plain text is:\n" + new String(plain));
        return plain;
    }

    /**
     * For showing the public/private keypair on screen
     *
     * @param keyPair
     */
    private static void dumpKeyPair(KeyPair keyPair) {
        PublicKey pub = keyPair.getPublic();
        System.out.println("Public Key: " + getHexString(pub.getEncoded()));

        PrivateKey priv = keyPair.getPrivate();
        System.out.println("Private Key: " + getHexString(priv.getEncoded()));
    }

    /**
     * Hex magic is done here
     *
     * @param b the byte on which the magic is to be performed
     * @return the String resulting from the magic
     */
    private static String getHexString(byte[] b) {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    /**
     * @param args the command line arguments. Should be either 'e', 'd' or 'g'.
     *
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("You must provide arguments for encryption (e), decryption (d) or key generation (g).");
            System.exit(0);
        }
        
        if (args.length > 0) {
            if (args[0].equals("g")) {
                BasicPKI.generateKeys();
                System.exit(0);
            } else if (args[0].equals("e")) {
                FileInputStream fis = null;
                try {
                    File plaintextfile = new File("plaintext.txt");
                    fis = new FileInputStream("plaintext.txt");
                    byte[] plaintextBytes = new byte[(int) plaintextfile.length()];
                    fis.read(plaintextBytes);
                    fis.close();
                    rsaEncrypt(plaintextBytes);
                } catch (IOException ex) {
                    System.out.println("Error. Make sure public/private key files and the plaintext file exist. Exiting.");
                    Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (args[0].equals("d")) {
                FileInputStream fis = null;
                try {
                    File ciphertextFile = new File("ciphertext.txt");
                    fis = new FileInputStream("ciphertext.txt");
                    byte[] ciphertextBytes = new byte[(int) ciphertextFile.length()];
                    fis.read(ciphertextBytes);
                    fis.close();
                    rsaDecrypt(ciphertextBytes);
                } catch (IOException ex) {
                    System.out.println("Error. Make sure public/private key files and the ciphertext file exist. Exiting.");
                    Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(BasicPKI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                System.out.println("RT_M");
            }
        }
    }
}