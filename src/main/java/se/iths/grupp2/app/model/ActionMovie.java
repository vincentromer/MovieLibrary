package se.iths.grupp2.app.model;

public class ActionMovie extends Movie {

    public ActionMovie() {
    }

    public ActionMovie(int id, String title) {
        super(id, title);
    }

    public String category() {
        return "Action";
    }
}
