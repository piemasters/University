package OFI;

public class TestData extends Control {

    static RoomType[] RoomTypeData() {
        RoomType roomTypeList[] = new RoomType[3];
        roomTypeList[0] = new RoomType(1, "Single", 30, "En-suite bathroom | Internet | Mini-Bar");
        roomTypeList[1] = new RoomType(2, "Double", 40, "En-suite bathroom | TV | Mini-Bar");
        roomTypeList[2] = new RoomType(3, "Family", 50, "En-suite bathroom | Internet | TV");
        return roomTypeList;
    }

    static Room[] RoomData(RoomType[] roomTypeList) {
        Room roomList[] = new Room[8];
        roomList[0] = new Room(1, roomTypeList[0], 1);
        roomList[1] = new Room(2, roomTypeList[0], 2);
        roomList[2] = new Room(3, roomTypeList[0], 3);
        roomList[3] = new Room(4, roomTypeList[0], 4);
        roomList[4] = new Room(5, roomTypeList[1], 5);
        roomList[5] = new Room(6, roomTypeList[1], 6);
        roomList[6] = new Room(7, roomTypeList[2], 7);
        roomList[7] = new Room(8, roomTypeList[2], 8);
        return roomList;
    }

    static Booking[] BookingData() {
        Booking bookingList[] = new Booking[100];
        return bookingList;
    }

    static Customer[] CustomerData() {
        Customer customerList[] = new Customer[100];
        return customerList;
    }
}
