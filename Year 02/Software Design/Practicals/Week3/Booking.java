package year2.SD.Week3;

public class Booking {

    private int idBooking;
    private Showing showing;
    private int ticketQuantity;
    private String ticketType;
    private int totalCost;
    private String paymentType;
    private String cardNumber;
    private String expireyDate;
    

    public Booking(int id, Showing showing, int ticketQuantity, String ticketType, 
            int totalCost, String paymentType, String cardNumber, String expireyDate) {
        this.idBooking = id;
        this.showing = showing;
        this.ticketQuantity = ticketQuantity;
        this.ticketType = ticketType;
        this.totalCost = totalCost;
        this.paymentType = paymentType;
        this.cardNumber = cardNumber;
        this.expireyDate = expireyDate;
    }

    // idBooking Getter/Setters -------------
    public int getID() {
        return idBooking;
    }

    public void setID(int id) {
        this.idBooking = id;
    }
    
    public Showing getShowing() {
        return showing;
    }

        // ticketQuantity Getter/Setters -------------
    public int getticketQuantity() {
        return ticketQuantity;
    }

    public void setticketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }
    
    // ticketType Getter/Setters -------------
    public String getticketType() {
        return ticketType;
    }

    public void setticketType(String ticketType) {
        this.ticketType = ticketType;
    }

        // totalCost Getter/Setters -------------
    public int gettotalCost() {
        return totalCost;
    }

    public void settotalCost(int totalCost) {
        this.totalCost = totalCost;
    }   
    
    // paymentType Getter/Setters -------------
    public String ispaymentType() {
        return paymentType;
    }

    public void setpaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    // cardNumber Getter/Setters -------------
    public String getcardNumber() {
        return cardNumber;
    }

    public void setcardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // expireyDate Getter/Setters -------------
    public String getexpireyDate() {
        return expireyDate;
    }

    public void setexpireyDate(String expireyDate) {
        this.expireyDate = expireyDate;
    }


    @Override
    public String toString() {
        return "Booking ID: " + idBooking + " | Showing ID: " + showing.getid() + " | Ticket Quantity: " + ticketQuantity +  
                " | Ticket Type: " + ticketType + "\nTotal Cost: £" + totalCost +
                " | PaymentType: " + paymentType + " | CardNumber: " + cardNumber + 
                " | ExpireyDate: " + expireyDate;
    }
    
    
}
