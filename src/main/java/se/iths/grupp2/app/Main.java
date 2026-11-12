package se.iths.grupp2.app;

import se.iths.grupp2.app.model.ActionMovie;
import se.iths.grupp2.app.model.ComedyMovie;
import se.iths.grupp2.app.model.DramaMovie;
import se.iths.grupp2.app.model.HorrorMovie;
import se.iths.grupp2.app.storage.ActionMovieStorage;
import se.iths.grupp2.app.storage.ComedyMovieStorage;
import se.iths.grupp2.app.storage.DramaMovieStorage;
import se.iths.grupp2.app.storage.HorrorMovieStorage;
import se.iths.grupp2.app.storage.MovieStorage;
import se.iths.grupp2.app.service.MovieSeeder;
import se.iths.grupp2.app.ui.Ansi;
import se.iths.grupp2.app.ui.MovieMenu;
import se.iths.grupp2.app.ui.MoviePrinter;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    static MovieStorage<DramaMovie> dramaMovieStorage;
    static MovieStorage<ActionMovie> actionMovieStorage;
    static MovieStorage<ComedyMovie> comedyMovieStorage;
    static MovieStorage<HorrorMovie> horrorMovieStorage;

    static MoviePrinter moviePrinter;

    static void main() {

        moviePrinter = new MoviePrinter();

        try {
            dramaMovieStorage = new DramaMovieStorage(Path.of("data", "drama-movies.json"));
            actionMovieStorage = new ActionMovieStorage(Path.of("data", "action-movies.json"));
            comedyMovieStorage = new ComedyMovieStorage(Path.of("data", "comedy-movies.json"));
            horrorMovieStorage = new HorrorMovieStorage(Path.of("data", "horror-movies.json"));

            MovieSeeder seeder = new MovieSeeder();

            seeder.seedMovies(
                    dramaMovieStorage,
                    actionMovieStorage,
                    comedyMovieStorage,
                    horrorMovieStorage
            );
        }
        catch(IOException e) {
                moviePrinter.printError("Could not initialize movie library: " + e.getMessage());
                return;
            }
            MovieMenu movieMenu = new MovieMenu(
                    dramaMovieStorage,
                    actionMovieStorage,
                    comedyMovieStorage,
                    horrorMovieStorage,
                    moviePrinter);

            movieMenu.run();
        }

    }
