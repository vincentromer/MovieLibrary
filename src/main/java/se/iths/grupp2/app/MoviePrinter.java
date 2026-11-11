package se.iths.grupp2.app;

import se.iths.grupp2.app.model.Movie;

public class MoviePrinter {

    public void print(String message) {
        IO.println(message);
    }

    public String prompt(String prompt) {
        return IO.readln(prompt);
    }

    public void printMenu(String... menuItems) {
        for (String menuItem : menuItems) {
            IO.println(menuItem);
        }
    }

    public void printMovieInfo(Movie movie) {
        IO.print("ID: " + movie.getId());
        IO.print(" ["+movie.getTitle() + "]");
        IO.println(" - "+movie.category());
    }
}
