package year2.SD.Week2;

import year2.SD.Week2.UI;

/**
 * User: uniQ
 * Date: 02/10/2012
 */
public class Logic extends UI {
    private String finalConversion;


    public String getFinalConversion() {

        if (currencyCon == 1) {
            finalConversion = "£"+getExchangeRate() * getAmount();
        }
        if (currencyCon == 2) {
            double GbpToEur = 1 / getExchangeRate();
            finalConversion = "€"+GbpToEur * getAmount();
        }
        return finalConversion;
    }
}