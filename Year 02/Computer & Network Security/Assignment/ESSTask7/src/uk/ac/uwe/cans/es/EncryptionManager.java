package uk.ac.uwe.cans.es;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import uk.ac.uwe.cans.util.FileUtils;

/**
 * This class contains methods for encryption and decryption (password based) of
 * plaintext/cipher strings
 * 
 * EncryptionManager.java (UTF-8) Jan 24, 2013
 *
 * @author Saad Liaquat Kiani<saad2.liaquat@uwe.ac.uk>
 */
public class EncryptionManager {

    /**
     * Salt to be used in encryption. In order to use Password-Based Encryption (PBE)
     * as defined in PKCS #5, we have to specify a salt
     */ 
    private byte[] salt = {
        (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c,
        (byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99
    };
    private byte[] encryptedFileContentBytes = null;
    private PBEKeySpec pbeKeySpec;
    private PBEParameterSpec pbeParamSpec;
    private SecretKeyFactory keyFac;
    private SecretKey pbeKey;
    private final String serverPwd = "serverpassword";
    char[] serverPassword;

    public EncryptionManager() {
    }

    /**
     * This method takes in a plaintext string and encrypts it
     * @param plainString
     * @return positive integer for success, negative for failure.
     */
    public int encryptAndSave(String plainString) {
        
        encryptedFileContentBytes = encrypt(plainString.toCharArray());
        return verifyDecryption();
        // NOTE No need to actually save the file for the purpose of this coursework
    }
    
    /**
     * This method verifies if the encryption was correct by decrypting the
     * encrypted contents.
     * @return positive integer for success, negative for failure.
     */
    public int verifyDecryption(){
        int res = 1;
        System.out.println("Encrypted file contents: " + new String(encryptedFileContentBytes));
        byte[] decryptedFileContentBytes = decrypt(FileUtils.getChars(encryptedFileContentBytes));
        System.out.println("Decrypted file contents: " + new String(decryptedFileContentBytes));
        return res;
    }

    /*
     * This method takes the client's file content and encrypts it using the
     * built-in server password. In order to use Password-Based Encryption (PBE)
     * as defined in PKCS #5, we have to specify a salt and an iteration count.
     * The same salt and iteration count that are used for encryption must be
     * used for decryption:
     */
    public byte[] encrypt(char[] plainFileContents) {
        serverPassword = serverPwd.toCharArray();
        try {
            int itCount = 20;
            // Create PBE parameter spec
            pbeParamSpec = new PBEParameterSpec(salt, itCount);
            pbeKeySpec = new PBEKeySpec(serverPassword);
            keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            pbeKey = keyFac.generateSecret(pbeKeySpec);
            // Create PBE Cipher
            Cipher pbeCipher;
            pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");

            // Initialize PBE Cipher with key and parameters
            pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);

            byte[] plainFileContentBytes = FileUtils.getBytes(plainFileContents);

            // Encrypt the cleartext
            byte[] ciphertext = pbeCipher.doFinal(plainFileContentBytes);
            return ciphertext;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    /*
     * This method takes the encrypted file content and decrypts it using the
     * built-in server password. In order to use Password-Based Encryption (PBE)
     * as defined in PKCS #5, we have to specify a salt and an iteration count.
     * The same salt and iteration count that are used for encryption must be
     * used for decryption:
     */
    public byte[] decrypt(char[] encryptedFileConents) {
        serverPassword = serverPwd.toCharArray();
        try {
            // Iteration count
            int itCount = 20;
            // Create PBE parameter spec
            pbeParamSpec = new PBEParameterSpec(salt, itCount);
            pbeKeySpec = new PBEKeySpec(serverPassword);
            keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            pbeKey = keyFac.generateSecret(pbeKeySpec);
            // Create PBE Cipher
            Cipher pbeCipher;
            pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");

            // Initialize PBE Cipher with key and parameters
            pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);

            // Encrypt the cleartext
            byte[] plaintext = pbeCipher.doFinal(encryptedFileContentBytes);
            return plaintext;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptionManager.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }
}
