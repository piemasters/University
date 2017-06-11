package OFI;

import java.util.Scanner;

public class Control {

    public static void main(String[] args) {

        //----------------------------------------------------------------------
        //-----------------------| FETCH TEMP DATA |----------------------------
        //----------------------------------------------------------------------        
        RoomType roomTypeList[] = TestData.RoomTypeData();
        Room roomList[] = TestData.RoomData(roomTypeList);
        Booking bookingList[] = TestData.BookingData();
        Customer customerList[] = TestData.CustomerData();
        //----------------------------------------------------------------------

        //----------------------------------------------------------------------
        //-------------------------| SET VARIABLES |----------------------------
        //----------------------------------------------------------------------
        Scanner scan = new Scanner(System.in);
        boolean cont = true, mainCont = true;
        //----------------------------------------------------------------------

        do {
        	//=================== Welcome, Continue or Quit ====================      	
        	mainCont = UI.welcomeMenu(scan, mainCont);

            if (mainCont == true) {

              //===================== List Room Types ========================
                UI.listRoomTypes(roomTypeList);
                
              //===================== Gather User Data =========================
                int roomSelect = UI.selectRoom(scan);
                String monthSelect = UI.selectMonth(scan);
                int daySelect = UI.selectDate(scan);
                int duration = UI.selectDuration(scan);

                int tempDay = daySelect - 1, assignedRoom = -2;
                boolean available = true;

                //======================= Find Room ============================
                assignedRoom = Room.GetRoom(roomSelect, roomList, roomTypeList, tempDay, daySelect, duration, available, assignedRoom);

                if (assignedRoom == -2) { //if no rooms available
                    UI.fullRoomMessage(roomTypeList, roomSelect);
                } else {

                    //=============== Update Room Availability =================
                    Room.UpdateRoomAvailability(daySelect, tempDay, duration, roomList, assignedRoom);

                    //============= Get Cost & Continue Booking ================
                    String displayCost = Booking.GetCost(roomTypeList, roomSelect, duration);
                    cont = UI.displayCost(scan, cont, displayCost);

                    if (cont == true) {
                       
                    	//================= Get Customer Details ===============
                    	String name = UI.selectName(scan);
                        String email = UI.selectEmail(scan);

                        //============== Make Customer If Required =============                       
                        int cCount = Customer.MakeCustomer(customerList, name, email);

                        //================= Make Reservation ===================                        
                        int bCount = Booking.MakeReservation(bookingList, daySelect,
                                roomList, assignedRoom, monthSelect, duration, customerList, cCount);
                        String displayResNum = bookingList[bCount].getreservationNumber();

                        //============ Display Reservation Number ==============
                        UI.displayReservationNumber(displayResNum);

                        //=================== Get Card Details =================
                        String cardNumber = UI.selectCardNumber(scan);
                        String cardIssue = UI.selectCardIssueDate(scan);
                        String cardExpirey = UI.selectCardExpireyDate(scan);

                        //====================Update Customer ==================
                        Customer.UpdateCustomer(customerList, cCount, name, email, cardNumber, cardIssue, cardExpirey);

                        //======================================================
                        //==========|Call Payment Transaction System |==========
                        //======================================================
                        
                        //============ Display Booking Confirmation ============
                        UI.displayBookingConfirmation(bookingList, bCount);
                    }
                } // room found
            } // start booking loop
        } while (mainCont == true); //main menu loop
    } // main class    	
} // control class
