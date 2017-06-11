package year2.CSP.Week8;
import java.io.*;

public class CopyBytes {

    public static void main(String[] args)
            throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("src\\year2\\CSP\\Week8\\inFile.txt");
            out = new FileOutputStream("src\\year2\\CSP\\Week8\\outFile.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
