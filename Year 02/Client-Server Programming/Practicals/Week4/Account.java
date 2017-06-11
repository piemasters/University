package year2.CSP.Week4;

public class Account {

    private int balance = 0;

    public synchronized void deposit(int amount) {

        int tmp = balance;
        //Thread.sleep(400);
        balance = tmp + amount;

        System.out.println("Current balance is " + balance);
    }
}
