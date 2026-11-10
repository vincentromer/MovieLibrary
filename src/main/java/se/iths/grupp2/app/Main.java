package se.iths.grupp2.app;

import se.iths.grupp2.app.model.ActionMovie;
import se.iths.grupp2.app.model.ComedyMovie;
import se.iths.grupp2.app.model.DramaMovie;
import se.iths.grupp2.app.model.HorrorMovie;
import se.iths.grupp2.app.model.Movie;
import se.iths.grupp2.app.storage.ActionMovieStorage;
import se.iths.grupp2.app.storage.ComedyMovieStorage;
import se.iths.grupp2.app.storage.DramaMovieStorage;
import se.iths.grupp2.app.storage.HorrorMovieStorage;
import se.iths.grupp2.app.storage.MovieStorage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static MovieStorage<DramaMovie> dramaMovieStorage;
    static MovieStorage<ActionMovie> actionMovieStorage;
    static MovieStorage<ComedyMovie> comedyMovieStorage;
    static MovieStorage<HorrorMovie> horrorMovieStorage;

    static MoviePrinter moviePrinter;

    static void main() throws IOException {

        moviePrinter = new MoviePrinter();

        // region Movie creation
        // Drama movies
        dramaMovieStorage = new DramaMovieStorage(Path.of("data", "drama-movies.json"));

        DramaMovie dramaMovie1 = new DramaMovie(1, "A Beautiful Mind");
        dramaMovieStorage.save(dramaMovie1);

        DramaMovie dramaMovie2 = new DramaMovie(2, "Dead Poets Society");
        dramaMovieStorage.save(dramaMovie2);

        DramaMovie dramaMovie3 = new DramaMovie(3, "12 Years a Slave");
        dramaMovieStorage.save(dramaMovie3);

        DramaMovie dramaMovie4 = new DramaMovie(4, "The Green Mile");
        dramaMovieStorage.save(dramaMovie4);

        DramaMovie dramaMovie5 = new DramaMovie(5, "Good Will Hunting");
        dramaMovieStorage.save(dramaMovie5);

        // Action movies
        actionMovieStorage = new ActionMovieStorage(Path.of("data", "action-movies.json"));

        ActionMovie actionMovie1 = new ActionMovie(1, "Spider-Man 2");
        actionMovieStorage.save(actionMovie1);

        ActionMovie actionMovie2 = new ActionMovie(2, "Rush Hour");
        actionMovieStorage.save(actionMovie2);

        ActionMovie actionMovie3 = new ActionMovie(3, "The Avengers");
        actionMovieStorage.save(actionMovie3);

        ActionMovie actionMovie4 = new ActionMovie(4, "The Dark Knight");
        actionMovieStorage.save(actionMovie4);

        ActionMovie actionMovie5 = new ActionMovie(5, "Green Lantern");
        actionMovieStorage.save(actionMovie5);

        // Comedy movies
        comedyMovieStorage = new ComedyMovieStorage(Path.of("data", "comedy-movies.json"));

        ComedyMovie comedyMovie1 = new ComedyMovie(1, "Superbad");
        comedyMovieStorage.save(comedyMovie1);

        ComedyMovie comedyMovie2 = new ComedyMovie(2, "Step Brothers");
        comedyMovieStorage.save(comedyMovie2);

        ComedyMovie comedyMovie3 = new ComedyMovie(3, "Anchorman");
        comedyMovieStorage.save(comedyMovie3);

        ComedyMovie comedyMovie4 = new ComedyMovie(4, "The Hangover");
        comedyMovieStorage.save(comedyMovie4);

        ComedyMovie comedyMovie5 = new ComedyMovie(5, "Bridesmaids");
        comedyMovieStorage.save(comedyMovie5);

        //Horror movies
        horrorMovieStorage = new HorrorMovieStorage(Path.of("data", "horror-movies.json"));

        HorrorMovie horrorMovie1 = new HorrorMovie(1, "Suicide Club");
        horrorMovieStorage.save(horrorMovie1);

        HorrorMovie horrorMovie2 = new HorrorMovie(2, "Exit 8");
        horrorMovieStorage.save(horrorMovie2);

        HorrorMovie horrorMovie3 = new HorrorMovie(3, "The Lighthouse");
        horrorMovieStorage.save(horrorMovie3);

        HorrorMovie horrorMovie4 = new HorrorMovie(4, "Session 9");
        horrorMovieStorage.save(horrorMovie4);

        HorrorMovie horrorMovie5 = new HorrorMovie(5, "Oculus");
        horrorMovieStorage.save(horrorMovie5);
        // endregion

        boolean quit = false;

        menuLoop:
        while (!quit) {
            moviePrinter.printMenu("1. Show movies from a certain category",
                    "2. Show all movies",
                    "0. Quit");
            String choice = moviePrinter.prompt("Choice? ");
            switch (choice.trim()) {
                case "1": {
                    MovieStorage<? extends Movie> movieStorage;
                    moviePrinter.print("Categories: DRAMA, ACTION, COMEDY, HORROR");
                    String category = moviePrinter.prompt("Which category? ");

                    movieStorage = getMovieStorage(category);
                    if (movieStorage == null) continue menuLoop;

                    for (Movie movie : movieStorage.findAll()) {
                        if (movieStorage.findAll() == null || movieStorage.findAll().isEmpty()) {
                            moviePrinter.prompt("No movies found");
                            break;
                        }
                        moviePrinter.printMovieInfo(movie);
                    }

                    moviePrinter.prompt("Press enter to continue");
                    break;
                }
                case "2": {
                    List<Movie> movies = new ArrayList<>();
                    try {
                        movies.addAll(dramaMovieStorage.findAll());
                        movies.addAll(actionMovieStorage.findAll());
                        movies.addAll(comedyMovieStorage.findAll());
                        movies.addAll(horrorMovieStorage.findAll());
                    }
                    catch (NullPointerException e) {
                        moviePrinter.print("Could not access movies: " + e.getMessage());
                        continue menuLoop;
                    }

                    for (int i = 0; i < movies.size(); i++) {
                        if (i % 5 == 0) IO.println(); // Print a new line for every fifth movie
                        Movie movie = movies.get(i);
                        moviePrinter.printMovieInfo(movie);
                    }
                    moviePrinter.prompt("Press enter to continue");
                    break;
                }
                case "0": {
                    moviePrinter.print("Quitting...");
                    System.exit(1);
                    break;
                }
                default: {
                    moviePrinter.print("Enter a valid entry");
                    continue menuLoop;
                }
            }
        }

    }

    private static MovieStorage<? extends Movie> getMovieStorage(String category) {
        MovieStorage<? extends Movie> movieStorage;
        switch (category.trim().toUpperCase()) {
            case "DRAMA":
                movieStorage = dramaMovieStorage;
                break;
            case "ACTION":
                movieStorage = actionMovieStorage;
                break;
            case "COMEDY":
                movieStorage = comedyMovieStorage;
                break;
            case "HORROR":
                movieStorage = horrorMovieStorage;
                break;
            default:
                moviePrinter.print("Please enter a valid category");
                return null;
        }
        return movieStorage;
    }

}
