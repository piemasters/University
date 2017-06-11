package year2.CSP.Week11;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author h2-kotecha
 */
public class HttpClient {

    String host, filename;
    int port;
    URL url;
    Socket socket;
    Scanner from_server;
    PrintWriter to_server;

    public void connectToHTTPServer(String path) throws MalformedURLException, UnknownHostException, IOException {
        url = new URL(path);
        host = url.getHost();
        port = url.getPort();
        if (port == -1) {
            port = 80;
        }
        filename = url.getFile();
        socket = new Socket(host, port);
        from_server = new Scanner(socket.getInputStream());
        // get the inputstream from socket
        to_server = new PrintWriter(socket.getOutputStream());
        // get the outputstream from socket

    }

    public String processRequestResponse(String command) throws IOException {
        to_server.println(command + " " + filename + " HTTP/1.0\n");
        to_server.flush(); // Send it right now!
        String response = receiveHTTPResponse();
        return response;
    }

    private String receiveHTTPResponse() {
        String r = "";
        while (from_server.hasNextLine()) {
            r = r + from_server.nextLine() + "\n";
        }
        return r;
    }
}