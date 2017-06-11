package year2.SD.Week3;

public class Showing {

    private int idShowing;
    private String month;
    private int date;
    private String time;
    private Film film;
    private Screen screen;
    public int seatAvailability;

    public Showing(int id, String month, int date, String time, Film film, Screen screen, int seatAvailability) {
        this.idShowing = id;
        this.month = month;
        this.date = date;
        this.time = time;
        this.film = film;
        this.screen = screen;
        this.seatAvailability = seatAvailability;
    }

    // idShowing Getter/Setters -------------
    public int getid() {
        return idShowing;
    }

    public void setid(int id) {
        this.idShowing = id;
    }

    // month Getter/Setters -------------
    public String getmonth() {
        return month;
    }

    public void setmonth(String month) {
        this.month = month;
    }

    // date Getter/Setters -------------
    public int getdate() {
        return date;
    }

    public void setdate(int date) {
        this.date = date;
    }

    // time Getter/Setters -------------
    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }

    public Screen getScreen() {
        return screen;
    }

    public Film getFilm() {
        return film;
    }
    
    // seatAvailability Getter/Setters -------------
    public int getseatAvailability() {
        return seatAvailability;
    }

    public void setseatAvailability(int seatAvailability) {
        this.seatAvailability = seatAvailability;
    }
    
    public void decSeats (int tempSeatAvailability, int numTickets) {
       seatAvailability = tempSeatAvailability - numTickets;
    }

    @Override
    public String toString() {
        return "Showing ID: " + idShowing + " | Month: " + month + " | Date: " + date + " | Time: " + time + 
                " | Film: " + film.gettitle() + " | Screen Capacity: " + screen.getcapacity() + 
                " | Seats Available: " + seatAvailability;
    }
}
