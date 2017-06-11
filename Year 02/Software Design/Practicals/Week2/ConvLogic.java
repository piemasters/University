package year2.SD.Week2;

import java.util.*;
import java.math.*;
import java.text.*;

public class ConvLogic {

    private double exchangeRate, amount, temp;
    public int currencyType;
    private String finalConversion;
    DecimalFormat euroFormat = new DecimalFormat("€0.00");
    DecimalFormat gbpFormat = new DecimalFormat("£0.00");

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(int currencyType) {
        this.currencyType = currencyType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFinalConversion() {

        if (getCurrencyType() == 1) {
            temp = getExchangeRate() * getAmount();
            finalConversion = euroFormat.format(temp);
        } else if (getCurrencyType() == 2) {
            temp = (1 / getExchangeRate()) * getAmount();
            finalConversion = gbpFormat.format(temp);
        } else {
            finalConversion = "Invalid Input";
        }

        return finalConversion;

    }
}