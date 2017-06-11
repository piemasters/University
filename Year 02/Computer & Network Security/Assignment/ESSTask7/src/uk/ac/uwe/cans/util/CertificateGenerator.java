package uk.ac.uwe.cans.util;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import sun.security.x509.*;

/**
 * This class contains the utility method to generate a signed certificate. It 
 * expects to be provided with the public key to be signed, the private key to
 * sign with, the algorithm to use and the number of days the signed certificate
 * should be valid for. 
 * 
 * The generateCertificate() method is based upon the one available at the fillowing
 * link: 
 * http://bfo.com/blog/2011/03/08/odds_and_ends_creating_a_new_x_509_certificate.html
 * 
 * I have modified it for use with the BasicESS project.
 * 
 * CertificateGenerator.java (UTF-8) Jan 24, 2013
 *
 * @author modified for use by Saad Liaquat Kiani<saad2.liaquat@uwe.ac.uk>
 */
public class CertificateGenerator {

    /**
     * NOTE: CHANGE THE FOLLOWING DN TO MATCH YOUR CA'S DN
     */
    public static final String dn = "CN=David & Felix, OU=BFS, O=BFS, L=Bristol, ST=Avon, C=GB";
    
    /**
     * Create a a signed X.509 Certificate.  It expects to be provided with the 
     * public key to be signed, the private key to sign with, the algorithm to 
     * use and the number of days the signed certificate should be valid for. 
     *
     * @param dn the X.509 Distinguished Name, e.g. "CN=Saad Kiani, OU=CSCT, O=UWE, L=Bristol, ST=Avon, C=GB"
     * @param pair the KeyPair
     * @param days how many days from now the Certificate is valid for
     * @param algorithm the signing algorithm, e.g. "SHA1withRSA"
     */
    
    public static X509Certificate generateCertificate(PublicKey requestorPublicKey, int days, String algorithm, PrivateKey issuerPrivateKey)
            throws GeneralSecurityException, IOException {
        //PrivateKey privkey = pair.getPrivate();
        X509CertInfo info = new X509CertInfo();
        Date from = new Date();
        Date to = new Date(from.getTime() + days * 86400000l);
        CertificateValidity interval = new CertificateValidity(from, to);
        BigInteger sn = new BigInteger(64, new SecureRandom());
        X500Name owner = new X500Name(dn);

        info.set(X509CertInfo.VALIDITY, interval);
        info.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(sn));
        info.set(X509CertInfo.SUBJECT, new CertificateSubjectName(owner));
        info.set(X509CertInfo.ISSUER, new CertificateIssuerName(owner));
        info.set(X509CertInfo.KEY, new CertificateX509Key(requestorPublicKey));
        info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
        AlgorithmId algo = new AlgorithmId(AlgorithmId.RSAEncryption_oid);
        info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algo));

        // Sign the cert to identify the algorithm that's used.
        X509CertImpl cert = new X509CertImpl(info);
        cert.sign(issuerPrivateKey, algorithm);

        // Update the algorithm, and resign.
        algo = (AlgorithmId) cert.get(X509CertImpl.SIG_ALG);
        info.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algo);
        cert = new X509CertImpl(info);
        cert.sign(issuerPrivateKey, algorithm);
        return cert;
    }
}
