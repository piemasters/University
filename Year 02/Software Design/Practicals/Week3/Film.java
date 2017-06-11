package year2.SD.Week3;

public class Film {

    private int idFilm;
    private String title;
    private String ageRating;
    private int duration;
    private String description;

    public Film(int id, String title, String ageRating, int duration, String description) {
        this.idFilm = id;
        this.title = title;
        this.ageRating = ageRating;
        this.duration = duration;
        this.description = description;
    }
    
    // idFilm Getter/Setters -------------
    public int getid() {
        return idFilm;
    }

    public void setid(int id) {
        this.idFilm = id;
    }

    // title Getter/Setters -------------
    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    // ageRating Getter/Setters -------------
    public String getageRating() {
        return ageRating;
    }

    public void setageRating(String ageRating) {
        this.ageRating = ageRating;
    }

    // duration Getter/Setters -------------
    public int getduration() {
        return duration;
    }

    public void setduration(int duration) {
        this.duration = duration;
    }

    // description Getter/Setters -------------
    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Film ID: " + idFilm + " | Title: " + title + " | AgeRating: " + ageRating + " | Duration: " + duration + "mins | Description: " + description;
    }
    
    
}
