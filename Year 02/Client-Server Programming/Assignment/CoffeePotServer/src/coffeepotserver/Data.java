package coffeepotserver;

import java.util.ArrayList;

/*
 * Data Class
 * 
 * This holds any hard coded data for use with the program.
 * 
 * David Norton - 10005864
 * Hiten Kotecha - 11004776
 */
public class Data {

    //============================| Coffee Pots |===============================
    static void CreatePots(boolean debug, ArrayList<CoffeePot> pots) {

        //--------------------------| Start Pots |------------------------------

        CoffeePot pot0 = new CoffeePot(35, 20, debug, 0);
        pot0.start();
        CoffeePot pot1 = new CoffeePot(35, 20, debug, 1);
        pot1.start();
        CoffeePot pot2 = new CoffeePot(35, 20, debug, 2);
        pot2.start();

        //----------------------------------------------------------------------
        //
        //--------------------------| Update Pots |-----------------------------

        pot0.addAddition("Cream", 20);
        pot0.addAddition("Half and half", 15);
        pot0.addAddition("Whiskey", 100);
        pot0.addAddition("Vanilla", 50);
        pot1.addAddition("Cream", 20);
        pot1.addAddition("Half and Half", 15);
        pot1.addAddition("Whiskey", 100);
        pot1.addAddition("Vanilla", 50);
        pot2.addAddition("Cream", 20);
        pot2.addAddition("Half and Half", 15);
        pot2.addAddition("Whiskey", 100);
        pot2.addAddition("Vanilla", 50);

        //----------------------------------------------------------------------
        //
        //---------------------------| Add Pots |-------------------------------

        pots.add(pot0);
        pots.add(pot1);
        pots.add(pot2);

        //----------------------------------------------------------------------

    }
    //==========================================================================
}// Class
