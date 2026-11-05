package se.iths.grupp2.app.storage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.io.TempDir;

import se.iths.grupp2.app.model.ActionMovie;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


public class ActionMovieStorageTest {

    @TempDir
    Path tempDir;

    @Test
    void saveAndGetMovieTest() throws IOException {
        Path file = tempDir.resolve("test-action-movies.json");
        ActionMovieStorage actionMovieStorage = new ActionMovieStorage(file);

        int movieId = 1;
        String movieTitle = "Foobar";

        ActionMovie testMovie = new ActionMovie(movieId, movieTitle);
        actionMovieStorage.save(testMovie);

        ActionMovie foundMovie = actionMovieStorage.findById(movieId);

        assertEquals(movieId, foundMovie.getId());
        assertEquals(movieTitle, foundMovie.getTitle());
    }

    @Test
    void saveDuplicateMovieTest() throws IOException {
        Path file = tempDir.resolve("test-action-movies.json");
        ActionMovieStorage actionMovieStorage = new ActionMovieStorage(file);

        int movieId = 2;
        String movieTitle1 = "Foo";
        String movieTitle2 = "Foobar";

        ActionMovie testMovie1 = new ActionMovie(movieId, movieTitle1);
        ActionMovie testMovie2 = new ActionMovie(movieId, movieTitle2);

        actionMovieStorage.save(testMovie1);
        actionMovieStorage.save(testMovie2);

        List<ActionMovie> foundMovies = actionMovieStorage.findAll();
        assertEquals(1, foundMovies.size());
        assertEquals(movieTitle1, foundMovies.getFirst().getTitle());
    }

    @Test
    void getMoviesWithoutSaveTest() throws IOException {
        Path file = tempDir.resolve("test-action-movies.json");
        ActionMovieStorage actionMovieStorage = new ActionMovieStorage(file);

        List<ActionMovie> foundMovies = actionMovieStorage.findAll();

        assertTrue(foundMovies.isEmpty());
    }

    @Test
    void getMovieByMissingIdTest() throws IOException {
        Path file = tempDir.resolve("test-action-movies.json");
        ActionMovieStorage actionMovieStorage = new ActionMovieStorage(file);

        ActionMovie testMovie = new ActionMovie(1, "foobargus");
        actionMovieStorage.save(testMovie);

        ActionMovie foundMovie = actionMovieStorage.findById(777);

        assertNull(foundMovie);
    }


}
