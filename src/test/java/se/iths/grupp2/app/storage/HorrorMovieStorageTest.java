package se.iths.grupp2.app.storage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import se.iths.grupp2.app.model.HorrorMovie;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HorrorMovieStorageTest {

    @TempDir
    Path tempDir;

    @Test
    void saveAndFindMovie() throws IOException {
        Path file = tempDir.resolve("horror-movies.json");
        String filmTitle = "The Shining";
        HorrorMovieStorage storage = new HorrorMovieStorage(file);

        HorrorMovie movie = new HorrorMovie(1, filmTitle);
        storage.save(movie);

        HorrorMovie foundMovie = storage.findById(1);

        assertEquals(filmTitle, foundMovie.getTitle());
    }

    @Test
    void saveDoesNotAllowDuplicateId() throws IOException {
        Path file = tempDir.resolve("duplicate-horror-movies.json");

        String filmTitle = "The Exorcist";
        String filmTitle2 = "The Shining";

        HorrorMovieStorage storage = new HorrorMovieStorage(file);

        HorrorMovie movie1 = new HorrorMovie(1, filmTitle);
        HorrorMovie movie2 = new HorrorMovie(1, filmTitle2);

        storage.save(movie1);
        storage.save(movie2);

        List<HorrorMovie> savedMovies = storage.findAll();

        assertEquals(1, savedMovies.size());
        assertEquals(filmTitle, savedMovies.get(0).getTitle());
    }

    @Test
    void findAllReturnsEmptyListWhenFileDoesNotExist() throws IOException {

        Path file = tempDir.resolve("missing-horror-movies.json");
        HorrorMovieStorage storage = new HorrorMovieStorage(file);

        List<HorrorMovie> savedMovies = storage.findAll();

        assertTrue(savedMovies.isEmpty());
    }

    @Test
    void findByIDReturnsNullWhenMovieDoesNotExist() throws IOException {

        Path file = tempDir.resolve("missing-horror-movies.json");
        HorrorMovieStorage storage = new HorrorMovieStorage(file);

        HorrorMovie foundMovie = storage.findById(999);

        assertNull(foundMovie);
    }

    @Test
    void findByIdReturnsNullWhenIdIsMissing() throws IOException {

        Path file = tempDir.resolve("missing-horror-movies.json");
        String filmTitle = "The Shining";

        HorrorMovieStorage storage = new HorrorMovieStorage(file);

        HorrorMovie movie1 = new HorrorMovie(1, filmTitle);
        storage.save(movie1);

        HorrorMovie foundMovie = storage.findById(999);

        assertNull(foundMovie);
    }

    @Test
    void savedMovieCanBeReadByNewStorageInstance() throws IOException {

        Path file = tempDir.resolve("persisted-horror-movies.json");
        String filmTitle = "The Shining";

        HorrorMovieStorage storage = new HorrorMovieStorage(file);

        HorrorMovie movie1 = new HorrorMovie(1, filmTitle);
        storage.save(movie1);

        HorrorMovieStorage newStorage = new HorrorMovieStorage(file);

        HorrorMovie foundMovie = newStorage.findById(1);

        assertEquals(filmTitle, foundMovie.getTitle());
    }
}