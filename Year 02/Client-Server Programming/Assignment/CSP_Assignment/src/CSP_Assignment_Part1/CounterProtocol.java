package CSP_Assignment_Part1;

/* Student Name:    David Norton
 * Student ID:      10005864
 * Version   :      1.0
 * Description:     A protocol used to increment the counter for each file
 *                  downloaded. It also saves a log of user details to a 
 *                  text file.  The Synchronized method is used to ensure 
 *                  only a single thread can access the critical region 
 *                  (incrementation of the counter) at a time.
 */

import java.io.*;

public class CounterProtocol {

    //===========================| Set up variables |===========================
    private String fileLocation = ("host1_log.txt");
    private int programCount = 0, pictureCount = 0, bookCount = 0, tmp;
    private String clientHostIP, clientHostName, logEntry;
    //==========================================================================

    
    //=====================| Increments Relevant Counter |======================
    synchronized void incCounter(int resource) {

        /* Increments the counter for the relitive file. Contains mandatory
         * fragment of code. */

        switch (resource) {
            
            case 1: // Program

                tmp = programCount;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    System.out.println("sleep interrupted");
                }
                programCount = tmp + 1;
                break;

            case 2: // Picture

                tmp = pictureCount;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    System.out.println("sleep interrupted");
                }
                pictureCount = tmp + 1;
                break;

            case 3: // Book

                tmp = bookCount;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    System.out.println("sleep interrupted");
                }
                bookCount = tmp + 1;
                break;
        }

        // Displays the total number of downloads on the server. 
        System.out.println("-------------------------------------------------");
        System.out.println("Programs downloaded this session: " + programCount);
        System.out.println("Pictures downloaded this session: " + pictureCount);
        System.out.println("E-books downloaded this session:  " + bookCount);
    }
    //==========================================================================

    
    //===================| Logs Client's Name & IP to File |====================
    synchronized void appendToLog(String hostName, String hostIP) {
        this.clientHostIP = hostIP;
        this.clientHostName = hostName;

        // Create String to write to log file.
        logEntry = (clientHostName + " | " + clientHostIP);
        System.out.println("File downloaded from " + logEntry);

        // Write to file.
        try {
            /* Create file if neededt. The boolean ensures data is appended to 
             * the file, not overwriitten. Buffer FileWriter for effeciency */
            FileWriter fileWrite = new FileWriter(fileLocation, true);
            BufferedWriter outputFile = new BufferedWriter(fileWrite);

            outputFile.write(logEntry); // Write the line to the file
            outputFile.newLine();       // Put a new line between each entry.  
            outputFile.close();         // Close character stream & unlock file.
        
        } catch (Exception e) {
            System.err.println("File Handling Error: " + e.getMessage());
        }

    }
    //==========================================================================

}