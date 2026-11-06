package se.iths.grupp2.app;

import se.iths.grupp2.app.model.ActionMovie;
import se.iths.grupp2.app.model.DramaMovie;
import se.iths.grupp2.app.storage.ActionMovieStorage;
import se.iths.grupp2.app.storage.DramaMovieStorage;
import se.iths.grupp2.app.storage.MovieStorage;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    static void main() throws IOException {

        MovieStorage<DramaMovie> dramaMovieStorage = new DramaMovieStorage(Path.of("data","drama-movies.json"));

        DramaMovie movie1 = new DramaMovie(1,"A Beautiful Mind");
        dramaMovieStorage.save(movie1);

        DramaMovie movie2 = new DramaMovie(2,"Dead Poets Society");
        dramaMovieStorage.save(movie2);

        DramaMovie movie3 = new DramaMovie(3,"12 Years a Slave");
        dramaMovieStorage.save(movie3);

        DramaMovie movie4 = new DramaMovie(4,"The Green Mile");
        dramaMovieStorage.save(movie4);

        DramaMovie movie5 = new DramaMovie(5,"Good Will Hunting");
        dramaMovieStorage.save(movie5);

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


    }
}
