package year2.CSP.Week4;

public class CardHolder extends Thread {

    private Account acc;
    private String holderName;

    CardHolder(Account a, String nm) {
        acc = a;
        holderName = nm;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            acc.deposit(10);
        }
    }//run
}
