package se.iths.grupp2.app.ui;


import se.iths.grupp2.app.model.*;
import se.iths.grupp2.app.storage.MovieStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieMenu {

    private final MovieStorage<DramaMovie> dramaStorage;
    private final MovieStorage<ActionMovie> actionStorage;
    private final MovieStorage<ComedyMovie> comedyStorage;
    private final MovieStorage<HorrorMovie> horrorStorage;
    private final MoviePrinter moviePrinter;

    public MovieMenu(
            MovieStorage<DramaMovie> dramaStorage,
            MovieStorage<ActionMovie> actionStorage,
            MovieStorage<ComedyMovie> comedyStorage,
            MovieStorage<HorrorMovie> horrorStorage,
            MoviePrinter moviePrinter
    ){
        this.dramaStorage = dramaStorage;
        this.actionStorage = actionStorage;
        this.comedyStorage = comedyStorage;
        this.horrorStorage = horrorStorage;
        this.moviePrinter = moviePrinter;
    }
    public void run(){
        boolean quit = false;

        menuLoop:
        while (!quit) {
            moviePrinter.printMenu("1. Show movies from a certain category",
                    "2. Show all movies",
                    "0. Quit");
            String choice = IO.readln("Choice? ");
            switch (choice.trim()) {
                case "1": {
                    MovieStorage<? extends Movie> movieStorage;
                    moviePrinter.printCategories();
                    String category = "";

                    while (true) {
                        category = IO.readln("Which category? ");
                        movieStorage = getMovieStorage(category);
                        if (movieStorage == null) continue;
                        break;
                    }

                    try {
                        List<? extends Movie> movies = movieStorage.findAll();

                        if (movies.isEmpty()) {
                            moviePrinter.print("No movies found");
                        } else {
                            moviePrinter.printMovieHeader(category);
                            moviePrinter.printMovieColumns();

                            for (Movie movie : movies) {
                                moviePrinter.printMovieInfo(movie);
                            }
                        }
                    } catch (IOException e) {
                        moviePrinter.printError("Could not access movies: " + e.getMessage());                        continue menuLoop;
                    }

                    IO.readln("\nPress enter to continue");
                    break;
                }
                case "2": {
                    List<Movie> movies = new ArrayList<>();
                    try {
                        movies.addAll(dramaStorage.findAll());
                        movies.addAll(actionStorage.findAll());
                        movies.addAll(comedyStorage.findAll());
                        movies.addAll(horrorStorage.findAll());
                    } catch (IOException e) {
                        moviePrinter.printError("Could not access movies: " + e.getMessage());                        continue menuLoop;
                    }

                    if (movies.isEmpty()) {
                        moviePrinter.print("No movies found");
                    } else {
                        moviePrinter.printMovieHeader("ALL");

                        String lastCategory = "";

                        for (Movie movie : movies) {
                            if (!movie.category().equals(lastCategory)) {
                                moviePrinter.printCategorySection(movie.category());
                            }

                            moviePrinter.printMovieInfo(movie);
                            lastCategory = movie.category();
                        }
                        moviePrinter.printMovieTotal(movies.size());
                    }
                    IO.readln("\nPress enter to continue");
                    break;
                }
                case "0": {
                    moviePrinter.printGoodbye();
                    quit = true;
                    break;
                }
                default: {
                    moviePrinter.printError("Enter a valid entry");
                    continue menuLoop;
                }
            }
        }
    }

    private MovieStorage<? extends Movie> getMovieStorage(String category) {
        MovieStorage<? extends Movie> movieStorage;
        switch (category.trim().toUpperCase()) {
            case "DRAMA":
                movieStorage = dramaStorage;
                break;
            case "ACTION":
                movieStorage = actionStorage;
                break;
            case "COMEDY":
                movieStorage = comedyStorage;
                break;
            case "HORROR":
                movieStorage = horrorStorage;
                break;
            default:
                moviePrinter.printError("Please enter a valid category");
                return null;
        }
        return movieStorage;
    }

}
