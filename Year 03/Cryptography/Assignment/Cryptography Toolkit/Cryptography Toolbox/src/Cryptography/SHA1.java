package Cryptography;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class SHA1 {

    private static String convertToHex(byte[] data) {

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < data.length; i++) {

            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;

            do {

                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));

                halfbyte = data[i] & 0x0F;

            } while(two_halfs++ < 1);
        }

        return buf.toString();
    }

    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  {

        MessageDigest md = MessageDigest.getInstance("SHA-1");

        //Test
       // System.out.println("md: " + md);

        byte[] sha1hash = new byte[40];

        //Test
        //System.out.println("sha1hash" + sha1hash);

        md.update(text.getBytes("iso-8859-1"), 0, text.length());

        //Test
        //System.out.println("md: " + md);

        sha1hash = md.digest();

        //Test
        //System.out.println("sha1hash" + sha1hash);

        return convertToHex(sha1hash);
    }
}

