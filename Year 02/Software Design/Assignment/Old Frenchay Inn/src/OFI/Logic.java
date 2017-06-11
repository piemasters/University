package OFI;

import java.util.Scanner;

public class Logic extends Interface {
    
    //-----------------------------------------------------------------------------------------
    //-------------------------------------| Main Menu |---------------------------------------
    //-----------------------------------------------------------------------------------------

    public static boolean MainMenuContinue(Scanner scan, boolean mainCont) {

        int menuContinue = scan.nextInt();

        switch (menuContinue) {
            case 1:
                mainCont = true;
                break;
            case 0:
                mainCont = false;
                break;
        }

        return mainCont;

    }
    
    //-----------------------------------------------------------------------------------------

    
    //-----------------------------------------------------------------------------------------
    //-------------------------------------| Sub Menus |---------------------------------------
    //-----------------------------------------------------------------------------------------
    
    public static boolean MenuContinue(Scanner scan, boolean cont) {

        int menuContinue = scan.nextInt();

        switch (menuContinue) {
            case 1:
                cont = true;
                break;
            case 0:
                cont = false;
                break;
        }

        return cont;

    }
    
    //-----------------------------------------------------------------------------------------
    
}
