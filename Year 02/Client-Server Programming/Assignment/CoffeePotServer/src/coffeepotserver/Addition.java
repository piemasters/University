package coffeepotserver;

/*
 * Setup Class
 * 
 * This is used to set up details for the 'additions'.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */
public class Addition {

    //=========================| Global Variables |=============================
    String name;
    int amount;
    boolean isRequested;

    //==========================================================================
    //
    //===========================| Constructor |================================
    public Addition(String name, int amount) {
        this.name = name;
        this.amount = amount;
        isRequested = false;
    }
    //==========================================================================
    //
    //============================| Requests |==================================

    public void request(boolean isRequested) {
        this.isRequested = isRequested;
    }

    public boolean isRequested() {
        return isRequested;
    }
    
    //==========================================================================
    //
    //===========================| Decrement |==================================

    public void use() {
        amount--;
    }
    
    //==========================================================================
    //
    //============================| Getters |===================================

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
    
    //==========================================================================

}
