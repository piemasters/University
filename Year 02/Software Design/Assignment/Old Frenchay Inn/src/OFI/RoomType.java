package OFI;

import java.text.DecimalFormat;

public class RoomType {

    int roomTypeID;
    String roomType;
    int roomPrice;
    String roomDetails;

    public RoomType(int roomTypeID, String roomType, int roomPrice, String roomDetails) {
        this.roomTypeID = roomTypeID;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomDetails = roomDetails;
    }
    
    //-----------------------------------------------------------------------------------------
    //-----------------------------------| Getters & Setters |---------------------------------
    //-----------------------------------------------------------------------------------------

    // roomTypeID Getter/Setters -------------
    public int getroomTypeID() {
        return roomTypeID;
    }

    public void setroomTypeID(int roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    // roomTypeID Getter/Setters -------------
    public String getroomType() {
        return roomType;
    }

    public void setroomType(String roomType) {
        this.roomType = roomType;
    }

    // roomPrice Getter/Setters -------------
    public int getroomPrice() {
        return roomPrice;
    }

    public void setroomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    // roomDetails Getter/Setters -------------
    public String getroomDetails() {
        return roomDetails;
    }

    public void setroomDetails(String roomDetails) {
        this.roomDetails = roomDetails;
    }
    
    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //------------------------------------| List Room Types |----------------------------------
    //-----------------------------------------------------------------------------------------

    public static void ListRoomTypes(RoomType[] roomTypeList) {
        
        for (int i = 0; i < roomTypeList.length; i++) {
            if (roomTypeList[i] != null) {
                System.out.println(roomTypeList[i]);
            }
        }

    }
    
    //-----------------------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------
    //------------------------------------| Get Cost of Stay |---------------------------------
    //-----------------------------------------------------------------------------------------    
    
    public static String GetCost(RoomType[] roomTypeList, int roomSelect, int duration) {
        
        DecimalFormat tCost = new DecimalFormat("£00.00");
        
        //cost = price of roomtype * length of stay, formatted into £0.00
        int cost = roomTypeList[roomSelect - 1].getroomPrice() * duration;
        String displayCost = tCost.format(cost);
        
        return displayCost;
    }
    
    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //--------------------------------------| toString |---------------------------------------
    //-----------------------------------------------------------------------------------------

    public String toString() {
        return "Room Type ID: " + roomTypeID + " | Type: " + roomType + " | Price: £" + roomPrice + " | Details: " + roomDetails;
    }
    
    //-----------------------------------------------------------------------------------------
}
