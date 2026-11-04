package se.iths.grupp2.app.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import se.iths.grupp2.app.model.DramaMovie;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DramaMovieStorageTest {

    @TempDir
    Path tempDir;

    @Test
    void saveAndFindMovie() throws IOException {
        Path file = tempDir.resolve("drama-movies.json");

        DramaMovieStorage storage = new DramaMovieStorage(file);

        DramaMovie movie = new DramaMovie(1, "The Shawshank Redemption");
        storage.save(movie);

        DramaMovie foundMovie = storage.findById(1);

        assertEquals("The Shawshank Redemption", foundMovie.getTitle());
    }

    @Test
    void saveDoesNotAllowDuplicateId() throws IOException {
        Path file = tempDir.resolve("duplicate-drama-movies.json");
        DramaMovieStorage storage = new DramaMovieStorage(file);

        DramaMovie movie1 = new DramaMovie(1, "The Shawshank Redemption");
        DramaMovie movie2 = new DramaMovie(1, "Forrest Gump");

        storage.save(movie1);
        storage.save(movie2);

        List<DramaMovie> savedMovies = storage.findAll();

        assertEquals(1, savedMovies.size());
        assertEquals("The Shawshank Redemption", savedMovies.get(0).getTitle());
    }

    @Test
    void findAllReturnsEmptyListWhenFileDoesNotExist() throws IOException {

        Path file = tempDir.resolve("missing-drama-movies.json");
        DramaMovieStorage storage = new DramaMovieStorage(file);

        List<DramaMovie> savedMovies = storage.findAll();

        assertTrue(savedMovies.isEmpty());
    }


    @Test
    void findByIDReturnsNullWhenMovieDoesNotExist()throws IOException{

        Path file = tempDir.resolve("missing-drama-movies.json");
        DramaMovieStorage storage = new DramaMovieStorage(file);

        DramaMovie foundMovie = storage.findById(999);

        assertNull(foundMovie);
    }

@Test
    void findByIdReturnsNullWhenIdIsMissing() throws IOException{

    Path file = tempDir.resolve("missing-drama-movies.json");
    DramaMovieStorage storage = new DramaMovieStorage(file);

    DramaMovie movie1 = new DramaMovie(1, "Forrest Gump");
    storage.save(movie1);

    DramaMovie foundMovie = storage.findById(999);

    assertNull(foundMovie);
}
@Test
    void savedMovieCanBeReadByNewStorageInstance() throws IOException{

    Path file = tempDir.resolve("persisted-drama-movies.json");
    DramaMovieStorage storage = new DramaMovieStorage(file);

    DramaMovie movie1 = new DramaMovie(1, "Forrest Gump");
    storage.save(movie1);

    DramaMovieStorage newStorage = new DramaMovieStorage(file);

    DramaMovie foundMovie = newStorage.findById(1);

    assertEquals("Forrest Gump", foundMovie.getTitle());
}


}

