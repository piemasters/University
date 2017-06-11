package year2.SD.Week2;

import java.util.Scanner;

/**
 * User: uniQ
 * Date: 02/10/2012
 */
public class Main {
    public static void main(String[] args) {
        Logic c1 = new Logic();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter exchange rate: ");
        c1.setExchangeRate(input.nextDouble());

        System.out.println("Select 1) or 2):\n\t1) £ to €\n\t2) € to £");
        c1.setCurrencyCon(input.nextInt());

        System.out.println("Enter amount to convert: ");
        c1.setAmount(input.nextDouble());

        System.out.println(c1.getFinalConversion());

    }
}
