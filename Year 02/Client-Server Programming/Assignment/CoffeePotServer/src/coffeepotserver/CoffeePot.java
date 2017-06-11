package coffeepotserver;

import java.util.ArrayList;

/*
 * Addition & Request Class
 * 
 * This deals with any additions selected by the user and runs the selected
 * request.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */
public class CoffeePot extends Thread {

    //=========================| Global Variables |=============================
    public enum State {

        IDLE, BREWING, NOT_BREWING, COLD, POURING, OVERFLOWED, READY
    }
    State status;
    Order order;
    int tempreture, capacity, potNo;
    boolean debug;
    ArrayList<Addition> additions = new ArrayList<>();

    //==========================================================================
    //
    //===========================| Constructor |================================
    public CoffeePot(int tempreture, int capacity, boolean debug, int potNo) {
        this.capacity = capacity;
        this.tempreture = tempreture;
        this.debug = debug;
        this.potNo = potNo;
        status = State.IDLE;
    }

    //==========================================================================
    //
    //=========================| Getters / Setters |============================
    public synchronized State getPotState() {
        return status;
    }

    public synchronized void setPotState(State status) {
        this.status = status;
    }

    //==========================================================================
    //
    //====================| Convert Addition to String |========================
    public void addAddition(String name, int amount) {

        Addition addition = new Addition(name, amount);
        additions.add(addition);

    }

    //==========================================================================
    //
    //=======================| Create Addition String |=========================
    public String additionsToString() {

        String additions_str = "";
        int size = additions.size();

        //-------| For each addition, add to string, seperate using ';' |-------

        for (int i = 0; i < size; i++) {
            additions_str += additions.get(i).getName() + ";";
        }

        //----------------------------------------------------------------------

        return additions_str;
    }

    //==========================================================================
    //
    //============================| Take Order |================================
    public Order takeOrder(Order order) {

        int size = additions.size();

        //-------------| Add each selected addition to the order  |-------------

        for (int i = 0; i < size; i++) {

            // Add Milk
            if (additions.get(i).getName().equals(order.getMilkName())) {
                additions.get(i).request(true);
                order.hasMilk(true);
                //Add Alcohol
            } else if (additions.get(i).getName().equals(order.getAlcoholName())) {
                additions.get(i).request(true);
                order.hasAlcohol(true);
                //Add Syrup
            } else if (additions.get(i).getName().equals(order.getSyrupName())) {
                additions.get(i).request(true);
                order.hasSyrup(true);
            }
        }

        //----------------------------------------------------------------------

        this.order = order;
        return order;
    }

    //==========================================================================
    //
    //===========================| Cancel Order |===============================
    public void cancelOrder() {

        int size = additions.size();

        //---------------------| Cancel each request  |-------------------------

        for (int i = 0; i <= size; i++) {
            additions.get(i).request(false);
        }

        //----------------------------------------------------------------------
    }

    //==========================================================================
    //
    //===========================| Run Request |================================
    @Override
    public void run() {

        while (true) {

            switch (this.getPotState()) {

                //=======================| Brewing  |===========================

                case BREWING: {

                    while (tempreture <= 60) {

                        // ----------| Sleep & increment temperature |----------
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        tempreture++;
                        //------------------------------------------------------

                        // ----------| Display status on debug mode |-----------
                        if (debug == true) {
                            System.out.print("Pot: " + potNo + " tempreture: "
                                    + tempreture + "\n");
                        }
                        //------------------------------------------------------

                    } // While

                    // --------| Display success message on debug mode |--------
                    if (debug == true) {
                        System.out.print("Pot: " + potNo + " brewed" + "\n");
                    }
                    //----------------------------------------------------------

                    this.setPotState(State.NOT_BREWING);
                    break;
                }

                //==============================================================
                //
                //=======================| Pouring  |===========================

                case POURING: {

                    int amount = 0;
                    int size = additions.size();

                    // ---------| If no additions required ready state |--------
                    if (!order.wantsAddition()) {
                        this.setPotState(State.READY);
                        break;
                    }
                    //----------------------------------------------------------

                    // --------| While pouring, for each addition.. |-----------
                    while ((amount <= capacity) && (this.getPotState() == State.POURING)) {

                        try {

                            for (int i = 0; i < size; i++) {

                                // --------------| Use addition |---------------
                                if (additions.get(i).isRequested()) {
                                    additions.get(i).use();
                                    amount++;
                                    Thread.sleep(1000L);
                                    System.out.print(amount + "\n");
                                }
                                //----------------------------------------------

                                // ---------------| Overflow! |-----------------
                                if (amount == capacity) {
                                    if (debug == true) {
                                        System.out.print("Pot: " + potNo
                                                + " has overflowed" + "\n");
                                    }
                                    this.setPotState(State.OVERFLOWED);
                                }
                                //----------------------------------------------

                            }// For

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }// While
                    //----------------------------------------------------------

                    break;
                }

                //==============================================================
                //
                //========================| Ready  |============================   
                
                case READY: {
                    
                    // -------------| When ready cool temperature |-------------
                    while (tempreture >= 35 && this.getPotState() == State.READY) {
                        
                        //-----------| Sleep & decrement temperature |----------
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        tempreture--;
                        //------------------------------------------------------
                        
                        // ----------| Display status on debug mode |-----------
                        if (debug == true) {
                            System.out.print("Pot: " + potNo + " tempreture: "
                                    + tempreture + "\n");
                        }
                        //------------------------------------------------------
                        
                         // -----| Display success message and set state |------
                        if (tempreture == 35) {
                            if (debug == true) {
                                System.out.print("Pot: " + potNo + " is cold" + "\n");
                            }
                            this.setPotState(State.COLD);
                        }
                        //------------------------------------------------------
                    
                    } // While
                    
                    break;
                }

                //==============================================================
                //
                //=======================| Default  |===========================   

                default: {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                //==============================================================

            } //Switch
        } // While
    } // Run
    //==========================================================================
} //Class
