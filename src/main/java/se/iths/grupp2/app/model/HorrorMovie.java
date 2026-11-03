package se.iths.grupp2.app.model;

public class HorrorMovie extends Movie{

    public HorrorMovie() {
    }

    public HorrorMovie(int id, String title) {
        super(id, title);
    }

    public String category() {
        return "Horror";
    }
}
