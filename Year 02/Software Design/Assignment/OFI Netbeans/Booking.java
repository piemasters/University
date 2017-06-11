package OFI;

import java.text.DecimalFormat;

public class Booking {

    int bookingID;
    Room room;
    int startDay;
    String startMonth;
    int nightsStay;
    Customer customer;
    String reservationNumber;
    Boolean reservationConfirmation;

    public Booking(int bookingID, Room room, int startDay, String startMonth, int nightsStay,
            Customer customer, String reservationNumber, Boolean reservationConfirmation) {
        this.bookingID = bookingID;
        this.room = room;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.nightsStay = nightsStay;
        this.customer = customer;
        this.reservationNumber = reservationNumber;
        this.reservationConfirmation = reservationConfirmation;
    }
    
    //-----------------------------------------------------------------------------------------
    //-----------------------------------| Getters & Setters |---------------------------------
    //-----------------------------------------------------------------------------------------

    // bookingID Getter/Setters -------------
    public int getbookingID() {
        return bookingID;
    }

    public void setbookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    // room Getter -------------
    public Room getRoom() {
        return room;
    }

    // startDay Getter/Setters -------------
    public int getstartDay() {
        return startDay;
    }

    public void setstartDay(int startDay) {
        this.startDay = startDay;
    }

    // startMonth Getter/Setters -------------
    public String getstartMonth() {
        return startMonth;
    }

    public void setstartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    // nightsStay Getter/Setters -------------
    public int getnightsStay() {
        return nightsStay;
    }

    public void setnightsStay(int nightsStay) {
        this.nightsStay = nightsStay;
    }

    // Customer Getter -------------
    public Customer getCustomer() {
        return customer;
    }

    // reservationNumber Getter/Setters -------------
    public String getreservationNumber() {
        return reservationNumber;
    }

    public void setreservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    // reservationConfirmation Getter/Setters -------------
    public Boolean getreservationConfirmation() {
        return reservationConfirmation;
    }

    public void setreservationConfirmation(Boolean reservationConfirmation) {
        this.reservationConfirmation = reservationConfirmation;
    }
    
    //-----------------------------------------------------------------------------------------

  //-----------------------------------------------------------------------------------------
    //------------------------------------| Get Cost of Stay |---------------------------------
    //-----------------------------------------------------------------------------------------    
    
    public static String GetCost(RoomType[] roomTypeList, int roomSelect, int duration) {
        
        DecimalFormat tCost = new DecimalFormat("£00.00");
        
        //cost = price of roomtype * length of stay, formatted into �0.00
        int cost = roomTypeList[roomSelect - 1].getroomPrice() * duration;
        String displayCost = tCost.format(cost);
        
        return displayCost;
    }
    
    //-----------------------------------------------------------------------------------------

    
    //-----------------------------------------------------------------------------------------
    //--------------------| Make the reservation & get reservation number |--------------------
    //-----------------------------------------------------------------------------------------
    public static int MakeReservation(Booking[] bookingList, int daySelect, Room[] roomList, 
            int assignedRoom, String monthSelect, int duration, Customer[] customerList, int cCount) {

        boolean reservationMade = false;
        int bCount = 0;
        
        //find a free slot in the bookingList to add booking
        while (reservationMade == false && bCount < bookingList.length) {

            if (bookingList[bCount] == null) {
                
                reservationMade = true;
                //Create unique reservation number
                String reservationNumber = "OFI-ID" + (bCount + 1) + 
                        "-DAY" + daySelect + "-ROOM" + roomList[assignedRoom].getroomNumber();
                bookingList[bCount] = new Booking(bCount + 1, roomList[assignedRoom], daySelect, 
                        monthSelect, duration, customerList[cCount], reservationNumber, reservationMade);
            } else {
                bCount++;
            }
        }
        return bCount;
    }
    //-----------------------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------
    //--------------------------------------| toString |---------------------------------------
    //-----------------------------------------------------------------------------------------
    
    public String toString() {
        return "------------------------BOOKING-------------------------\n"
                + "Room " + room.getroomNumber() + " | From: " + startDay + " "
                + startMonth + " for " + nightsStay + " nights\n"
                + "Name: " + customer.getcutomerName() + " | Reservation Number: "
                + reservationNumber + "\nBooking & Payment Confirmed?: " + reservationConfirmation;
    }
    
    //-----------------------------------------------------------------------------------------
}
