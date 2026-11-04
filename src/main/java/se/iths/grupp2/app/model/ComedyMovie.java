package se.iths.grupp2.app.model;

public class ComedyMovie extends Movie {

    // Needed by Jackson
    public ComedyMovie() {
    }

    public ComedyMovie(int id, String title) {
        super(id, title);
    }

    @Override
    public String category() {
        return "Komedi";
    }
}