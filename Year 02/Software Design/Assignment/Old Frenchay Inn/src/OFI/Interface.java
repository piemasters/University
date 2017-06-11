package OFI;

import java.util.Scanner;

public class Interface {

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

            System.out.println("         WELCOME TO THE OLD FRENCHAY INN         ");
            System.out.println("-------------------------------------------------");
            System.out.println("To make a booking and view room types enter:    1");
            System.out.println("To quit enter:                                  0");
            System.out.println("-------------------------------------------------");

            //=================== Continue to Booking or Quit ==================
            
            mainCont = Logic.MainMenuContinue(scan, mainCont);

            if (mainCont == true) {

                //-==================== List Room Types ========================
                
                System.out.println("-------------------------------------------------");
                RoomType.ListRoomTypes(roomTypeList);
                System.out.println("-------------------------------------------------");

                System.out.print("Select a room type by entering the ID:         ");
                int roomSelect = scan.nextInt();
                System.out.print("Enter the month you wish to stay (e.g. April): ");
                String monthSelect = scan.next();
                System.out.print("Enter the date you wish to stay (e.g. 1):      ");
                int daySelect = scan.nextInt();
                System.out.print("How many nights would you like to stay?:       ");
                int duration = scan.nextInt();
                System.out.println("-------------------------------------------------");

                int tempDay = daySelect - 1, assignedRoom = -2;
                boolean available = true;

                //======================= Find Room ============================
                
                assignedRoom = Room.GetRoom(roomSelect, roomList, tempDay, daySelect, duration, available, assignedRoom);

                if (assignedRoom == -2) {
                    String fullRoomType = roomTypeList[roomSelect - 1].getroomType();
                    System.out.println("Unfortunately all " + fullRoomType + " rooms are fully booked during that period.\n");
                } else {

                    //=============== Update Room Availability =================
                    
                    Room.UpdateRoomAvailability(daySelect, tempDay, duration, roomList, assignedRoom);

                    //---------------------------- Get Cost ------------------------------
                    String displayCost = RoomType.GetCost(roomTypeList, roomSelect, duration);

                    System.out.println("The cost of this booking will be: " + displayCost);

                    System.out.println("If you are happy with this booking enter:       1");
                    System.out.println("To quit enter:                                  0");
                    System.out.println("-------------------------------------------------");

                    //=============== Continue Booking or Quit =================
                    
                    cont = Logic.MenuContinue(scan, cont);

                    if (cont == true) {
                        System.out.println("-------------------------------------------------");
                        System.out.print("Enter your full name:                          ");
                        String temp = scan.nextLine();
                        String name = scan.nextLine();
                        System.out.print("Enter your email address:                      ");
                        String email = scan.nextLine();

                        //============== Make Customer If Required =============
                        
                        int cCount = Customer.MakeCustomer(customerList, name, email);

                        //================= Make Reservation ===================
                        
                        int bCount = Booking.MakeReservation(bookingList, daySelect,
                                roomList, assignedRoom, monthSelect, duration, customerList, cCount);
                        String displayResNum = bookingList[bCount].getreservationNumber();

                        System.out.println("-------------------------------------------------");
                        System.out.println("Your reservation number is " + displayResNum);
                        System.out.println("-------------------------------------------------");

                        System.out.print("Enter your payment card number:                ");
                        String cardNumber = scan.nextLine();
                        System.out.print("Enter your card issue date(e.g. 01/12):        ");
                        String cardIssue = scan.nextLine();
                        System.out.print("Enter your card expirey date(e.g. 07/15):      ");
                        String cardExpirey = scan.nextLine();

                        //====================Update Customer ==================
                        
                        Customer.UpdateCustomer(customerList, cCount, name, email, cardNumber, cardIssue, cardExpirey);

                        System.out.println("-------------------------------------------------");
                        System.out.println("Your payment has been successfully transacted.");
                        System.out.println("Your room has been booked. Here are your details:\n" + bookingList[bCount] + "\n");
                        System.out.println("-------------------------------------------------");

                    }
                } // room found
            } // start booking loop
        } while (mainCont == true); //main menu loop
    } // main class
} // interface class
