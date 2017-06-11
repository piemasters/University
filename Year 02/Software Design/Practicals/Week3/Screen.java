package year2.SD.Week3;

public class Screen {

    private int idScreen;
    private int capacity;

    public Screen(int id, int capacity) {
        this.idScreen = id;
        this.capacity = capacity;
    }

    // idScreen Getter/Setters -------------
    public int getid() {
        return idScreen;
    }

    public void setid(int id) {
        this.idScreen = id;
    }

    // capacity Getter/Setters -------------
    public int getcapacity() {
        return capacity;
    }

    public void setcapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Screen ID: " + idScreen + " | Capacity: " + capacity;
    }
    
    
}
