package se.iths.grupp2.app;

import se.iths.grupp2.app.model.ActionMovie;
import se.iths.grupp2.app.model.ComedyMovie;
import se.iths.grupp2.app.model.DramaMovie;
import se.iths.grupp2.app.storage.ActionMovieStorage;
import se.iths.grupp2.app.storage.ComedyMovieStorage;
import se.iths.grupp2.app.storage.DramaMovieStorage;
import se.iths.grupp2.app.storage.MovieStorage;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    static void main() throws IOException {

        //Drama movies
        MovieStorage<DramaMovie> dramaMovieStorage = new DramaMovieStorage(Path.of("data", "drama-movies.json"));

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
        MovieStorage<ActionMovie> actionMovieStorage = new ActionMovieStorage(Path.of("data", "action-movies.json"));

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
        MovieStorage<ComedyMovie> comedyMovieStorage = new ComedyMovieStorage(Path.of("data", "comedy-movies.json"));

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


    }
}
