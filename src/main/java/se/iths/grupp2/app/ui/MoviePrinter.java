package se.iths.grupp2.app.ui;

import se.iths.grupp2.app.model.Movie;

public class MoviePrinter {

    public void print(String message) {
        IO.println(message);
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
