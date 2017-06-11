package OFI;

import java.util.Scanner;

public class UI extends Control {
	
	//=================== Welcome, Continue or Quit ====================
	static boolean welcomeMenu(Scanner scan, boolean mainCont) {

		//=================== Welcome, Continue or Quit ====================
		
		System.out.println("         WELCOME TO THE OLD FRENCHAY INN         ");
		System.out.println("-------------------------------------------------");
		System.out.println("To make a booking and view room types enter:    1");
		System.out.println("To quit enter:                                  0");
		System.out.println("-------------------------------------------------");
		
		mainCont = MainMenuContinue(scan, mainCont);
		return mainCont;
	}
	
	//-----------------------------------------------------------------------------------------
    //------------------------------------| List Room Types |----------------------------------
    //-----------------------------------------------------------------------------------------

    static void listRoomTypes(RoomType[] roomTypeList) {
    	System.out.println("-------------------------------------------------");
        for (int i = 0; i < roomTypeList.length; i++) {
            if (roomTypeList[i] != null) {
                System.out.println(roomTypeList[i]);
            }
        }
        System.out.println("-------------------------------------------------");
    }
    
    //-----------------------------------------------------------------------------------------
	
	//==================== Gather User Room Data =======================	
	static int selectRoom(Scanner scan) {
		
		System.out.print("Select a room type by entering the ID:         ");
		int roomSelect = scan.nextInt();
		return roomSelect;
	}
	static String selectMonth(Scanner scan) {
		System.out.print("Enter the month you wish to stay (e.g. April): ");
		String monthSelect = scan.next();
		return monthSelect;
	}
	static int selectDate(Scanner scan) {
		System.out.print("Enter the date you wish to stay (e.g. 1):      ");
		int daySelect = scan.nextInt();
		return daySelect;
	}
	static int selectDuration(Scanner scan) {
		System.out.print("How many nights would you like to stay?:       ");
		int duration = scan.nextInt();
		System.out.println("-------------------------------------------------");
		return duration;
	}
	
	//=============== Display Message If Rooms Are Full ================
	static void fullRoomMessage(RoomType[] roomTypeList, int roomSelect) {
		
		//===================== Full Rooms Error =========================
		
		String fullRoomType = roomTypeList[roomSelect - 1].getroomType();
		System.out.println("Unfortunately all " + fullRoomType + " rooms are fully booked during that period.\n");
	}
	
	//====================== Display Booking Cost ======================
	static boolean displayCost(Scanner scan, boolean cont, String displayCost) {
			
		System.out.println("The cost of this booking will be: " + displayCost);
		System.out.println("If you are happy with this booking enter:       1");
		System.out.println("To quit enter:                                  0");
		System.out.println("-------------------------------------------------");
		
		cont = MenuContinue(scan, cont);
		return cont;
	}
	
	//====================== Gather User Data ==========================
	static String selectName(Scanner scan) {
		System.out.println("-------------------------------------------------");
		System.out.print("Enter your full name:                          ");
		String temp = scan.nextLine();
		String name = scan.nextLine();
		return name;
	}
	static String selectEmail(Scanner scan) {
		System.out.print("Enter your email address:                      ");
		String email = scan.nextLine();
		return email;
	}

	//=================== Display Reservation Number ===================
	static void displayReservationNumber(String displayResNum) {
		System.out.println("-------------------------------------------------");
		System.out.println("Your reservation number is " + displayResNum);
		System.out.println("-------------------------------------------------");
	}
	
	//====================== Gather Card Data ==========================
	static String selectCardNumber(Scanner scan) {
		System.out.print("Enter your payment card number:                ");
		String cardNumber = scan.nextLine();
		return cardNumber;
	}
	static String selectCardIssueDate(Scanner scan) {
		System.out.print("Enter your card issue date(e.g. 01/12):        ");
		String cardIssue = scan.nextLine();
		return cardIssue;
	}
	static String selectCardExpireyDate(Scanner scan) {
		System.out.print("Enter your card expirey date(e.g. 07/15):      ");
		String cardExpirey = scan.nextLine();
		return cardExpirey;
	}

	//================ Display Booking Confirmation ====================
	static void displayBookingConfirmation(Booking[] bookingList, int bCount) {
		System.out.println("-------------------------------------------------");
		System.out.println("Your payment has been successfully transacted.");
		System.out.println("Your room has been booked. Here are your details:\n" + bookingList[bCount] + "\n");
		System.out.println("-------------------------------------------------");
	}
    
	//-----------------------------------------------------------------------------------------
    //-------------------------------------| Main Menu |---------------------------------------
    //-----------------------------------------------------------------------------------------
    static boolean MainMenuContinue(Scanner scan, boolean mainCont) {

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
    //-------------------------------------| Sub Menus |---------------------------------------
    //-----------------------------------------------------------------------------------------    
    static boolean MenuContinue(Scanner scan, boolean cont) {

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
    
    
}
