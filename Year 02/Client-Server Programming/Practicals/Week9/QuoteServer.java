package year2.CSP.Week9;
import java.io.*;

public class QuoteServer {

    public static void main(String[] args) throws IOException {
        new QuoteServerThread().start();
    }
}
