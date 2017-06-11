package year2.SD.Week3;

public class Price {

    private int idPrice;
    private String ticketType;
    private int cost;

    public Price(int id, String ticketType, int cost) {
        this.idPrice = id;
        this.ticketType = ticketType;
        this.cost = cost;
    }

    // idPrice Getter/Setters -------------
    public int getid() {
        return idPrice;
    }

    public void setid(int id) {
        this.idPrice = id;
    }

    // ticketType Getter/Setters -------------
    public String getticketType() {
        return ticketType;
    }

    public void setticketType(String ticketType) {
        this.ticketType = ticketType;
    }

    // TotalCost Getter/Setters -------------
    public int getcost() {
        return cost;
    }

    public void setcost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ID: " + idPrice + " | TicketType: " + ticketType + " | Cost: £" + cost + ".00";
    }
    
    
}
