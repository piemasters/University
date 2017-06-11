package OFI;

public class Room {

    private int roomID;
    private RoomType roomType;
    private int roomNumber;
    public boolean[] bookings = new boolean[30];

    public Room(int roomID, RoomType roomType, int roomNumber) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
    }

    //-----------------------------------------------------------------------------------------
    //-----------------------------------| Getters & Setters |---------------------------------
    //-----------------------------------------------------------------------------------------
    
    // roomID Getter/Setters -------------
    public int getroomID() {
        return roomID;
    }

    public void setroomID(int roomID) {
        this.roomID = roomID;
    }

    // roomType Getter -------------
    public RoomType getRoomType() {
        return roomType;
    }

    // roomID Getter/Setters -------------
    public int getroomNumber() {
        return roomNumber;
    }

    public void setroomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //----------| Check room's array to see if it available for the select day |---------------
    //-----------------------------------------------------------------------------------------

    public boolean CheckAvailability(int tempDay) {
       
        // if the day is available (false = not booked)
        if (bookings[tempDay] == false) {
            
            return true; // is available
            
        } else {
            
            return false; // isn't available
        }
    }
    
    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //-----------------------| Get room - find what type of room |-----------------------------
    //-----------------------------------------------------------------------------------------
    
    public static int GetRoom(int roomSelect, Room[] roomList, int tempDay, int daySelect, int duration, 
            boolean available, int assignedRoom) {
        
        if (roomSelect == 1) {
            
            assignedRoom = Room.FindSingleRoom(roomList, tempDay, daySelect, duration, available, assignedRoom);
            
        } else if (roomSelect == 2) {
            
            assignedRoom = Room.FindDoubleRoom(roomList, tempDay, daySelect, duration, available, assignedRoom);
            
        } else if (roomSelect == 3) {
            
            assignedRoom = Room.FindFamilyRoom(roomList, tempDay, daySelect, duration, available, assignedRoom);
            
        } else {
            System.out.println("Room type does not exist");
        }
        return assignedRoom;
    }

    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //-----------------------------| Find Single Room |----------------------------------------
    //-----------------------------------------------------------------------------------------
    
    public static int FindSingleRoom(Room[] roomList, int tempDay, int daySelect, int duration, boolean available, int assignedRoom) {
       
        for (int i = 0; i < roomList.length; i++) { //for every room
            if (roomList[i].getRoomType().getroomType().equals("Single")) { //if a single room
                assignedRoom = FindRoom(tempDay, daySelect, duration, available, roomList, i, assignedRoom); //find room
            }
            tempDay = daySelect - 1;
        }
        return assignedRoom;
    }
    
    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //-----------------------------| Find Double Room |----------------------------------------
    //-----------------------------------------------------------------------------------------

    public static int FindDoubleRoom(Room[] roomList, int tempDay, int daySelect, int duration, boolean available, int assignedRoom) {
        for (int i = 0; i < roomList.length; i++) {
            if (roomList[i].getRoomType().getroomType().equals("Double")) {
                assignedRoom = FindRoom(tempDay, daySelect, duration, available, roomList, i, assignedRoom);
            }
            tempDay = daySelect - 1;
        }
        return assignedRoom;
    }
   
    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //-----------------------------| Find Family Room |----------------------------------------
    //-----------------------------------------------------------------------------------------

    public static int FindFamilyRoom(Room[] roomList, int tempDay, int daySelect, int duration, boolean available, int assignedRoom) {
        for (int i = 0; i < roomList.length; i++) {
            if (roomList[i].getRoomType().getroomType().equals("Family")) {
                assignedRoom = FindRoom(tempDay, daySelect, duration, available, roomList, i, assignedRoom);
            }
            tempDay = daySelect - 1;
        }
        return assignedRoom;
    }
    
    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //-----------------------------| Find Matching Room |--------------------------------------
    //-----------------------------------------------------------------------------------------

    public static int FindRoom(int tempDay, int daySelect, int duration, boolean available, Room[] roomList, int i, int assignedRoom) {

        //for each day selected to stay, while the room is not booked
        while (tempDay < daySelect - 1 + duration && available == true) {

            if (roomList[i].CheckAvailability(tempDay) == true) { //if available
                
                available = true;
                
            } else {
                
                available = false;
                
            }
            tempDay++;
        }
        
        //if room available for all days selected, assign room
        if (available == true) {
            
            assignedRoom = i;
            
        }
                        
        return assignedRoom;
    }
    
    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //-----------------------| Update Booked Rooms Availability |------------------------------
    //-----------------------------------------------------------------------------------------
    
    public static void UpdateRoomAvailability(int daySelect, int tempDay, int duration, Room[] roomList, int assignedRoom) {
       
        //for each day the room has been booked
        for (tempDay = daySelect - 1; tempDay < (daySelect - 1 + duration); tempDay++) {
            
            roomList[assignedRoom].bookings[tempDay] = true; //room is booked this day
            
        }
    }
    
    //-----------------------------------------------------------------------------------------
    
    //-----------------------------------------------------------------------------------------
    //--------------------------------------| toString |---------------------------------------
    //-----------------------------------------------------------------------------------------
    
    public String toString() {
        return "Room Number: " + roomNumber + " | Type: " + roomType.getroomType() + " | Price: £" + roomType.getroomPrice();
    }
    
    //-----------------------------------------------------------------------------------------
    
}
