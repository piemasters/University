package uk.ac.uwe.cans.util;

import java.io.*;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class SignCertificate {

    // Get files and password
    private String kpES = "src\\Files\\ES.ks";
    private String kpCA = "src\\Files\\CA.ks";
    private String certificate = "src\\Files\\signed.crt";
    private String pass = "password";
    
    
    public static void main(String[] args) throws KeyStoreException, FileNotFoundException, 
            IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException, 
            GeneralSecurityException {
        
        // Create Signed Certificate
        SignCertificate signed = new SignCertificate();
        
    }

    public SignCertificate() throws KeyStoreException, IOException, NoSuchAlgorithmException,
            CertificateException, UnrecoverableKeyException, GeneralSecurityException {

        // Get keys from keystores
        KeyPair keyES = FileUtils.getKeysFromKeystore(kpES, pass, "ES", pass);
        KeyPair keyCA = FileUtils.getKeysFromKeystore(kpCA, pass, "CA", pass);

        // Get ES public key & CA private key
        PublicKey publicKey = keyES.getPublic();
        PrivateKey privateKey = keyCA.getPrivate();

        // Sign ES public key with CA private key- 365 expirey date
        X509Certificate certificateX509 = CertificateGenerator.generateCertificate(publicKey, 365, "SHA1withDSA", privateKey);
        // Save certificate to file
        storeCertificate(certificateX509, certificate);

    }

    private void storeCertificate(X509Certificate certificateX509, String path) 
            throws FileNotFoundException, CertificateEncodingException, IOException {
        
        FileOutputStream fos = new FileOutputStream(path);
        
        // Save certificate to file
        byte[] save = certificateX509.getEncoded();
        fos.write(save);
        
    }
}