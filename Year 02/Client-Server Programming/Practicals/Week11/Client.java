package year2.CSP.Week11;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author h2-kotecha
 */
public class Client {

    public static void main(String[] args) {

        HttpClient hc;

        try {
            hc = new HttpClient();
            while (true) {
                System.out.println("Enter (full) URL: ");
                Scanner sc = new Scanner(System.in);
                String path = sc.nextLine();
                hc.connectToHTTPServer(path);
                System.out.println("Enter your HTTP command: ");
                String command = sc.next();
                String res = hc.processRequestResponse(command);
                System.out.println(res);
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}