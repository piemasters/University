package coffeepotserver;

/*
 * Constructor Class
 * 
 * This class contains the getters, setters, wants and has for the additions
 * for orders.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */
public class Order {

    //=========================| Global Variables |=============================
    String milk;
    boolean hasMilk;
    boolean wantsMilk;
    String syrup;
    boolean hasSyrup;
    boolean wantsSyrup;
    String alcohol;
    boolean hasAlcohol;
    boolean wantsAlcohol;

    //==========================================================================
    //
    //===========================| Constructor |================================
    public Order() {

        this.alcohol = "";
        this.milk = "";
        this.syrup = "";

        hasMilk = false;
        hasSyrup = false;
        hasAlcohol = false;
        wantsMilk = false;
        wantsSyrup = false;
        wantsAlcohol = false;
    }

    //==========================================================================
    //
    //========================| Getters & Setters |=============================
    public String getMilkName() {
        return milk;
    }

    public String getSyrupName() {
        return syrup;
    }

    public String getAlcoholName() {
        return alcohol;
    }

    public void setMilkName(String milk) {
        this.milk = milk;
    }

    public void setSyrupName(String syrup) {
        this.syrup = syrup;
    }

    public void setAlcoholName(String alcohol) {
        this.alcohol = alcohol;
    }

    //==========================================================================
    //
    //===========================| Wants & Has |================================
    public void wantsMilk(boolean wantsMilk) {
        this.wantsMilk = wantsMilk;
    }

    public void wantsSyrup(boolean wantsSyrup) {
        this.wantsSyrup = wantsSyrup;
    }

    public void wantsAlcohol(boolean wantsAlcohol) {
        this.wantsAlcohol = wantsAlcohol;
    }

    public boolean wantsAddition() {
        if ((wantsAlcohol) || (wantsSyrup) || (wantsMilk)) {
            return true;
        } else {
            return false;
        }
    }

    public void hasMilk(boolean hasMilk) {
        this.hasMilk = hasMilk;
    }

    public void hasSyrup(boolean hasSyrup) {
        this.hasSyrup = hasSyrup;
    }

    public void hasAlcohol(boolean hasAlcohol) {
        this.hasAlcohol = hasAlcohol;
    }
    //==========================================================================
}