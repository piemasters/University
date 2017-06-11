package year2.CSP.Week4;

public class FamilyAccount {

    public static void main(String[] args) {
        Account ourAccount = new Account();
        CardHolder c1 = new CardHolder(ourAccount, "John");
        CardHolder c2 = new CardHolder(ourAccount, "Kate");

        c1.start();
        c2.start();
    }
}
