package se.iths.grupp2.app;

import se.iths.grupp2.app.model.DramaMovie;
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




    }
}
