package OFI;

public class RoomType {

    private int roomTypeID;
    private String roomType;
    private int roomPrice;
    private String roomDetails;

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
    //--------------------------------------| toString |---------------------------------------
    //-----------------------------------------------------------------------------------------

    public String toString() {
        return "Room Type ID: " + roomTypeID + " | Type: " + roomType + " | Price: £" + roomPrice + " | Details: " + roomDetails;
    }
    
    //-----------------------------------------------------------------------------------------
}
