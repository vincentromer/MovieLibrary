package se.iths.grupp2.app.storage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import se.iths.grupp2.app.model.ComedyMovie;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComedyMovieStorageTest {

    @TempDir
    Path tempDir;

    @Test
    void saveAndFindById() throws IOException {
        ComedyMovieStorage storage = new ComedyMovieStorage(tempDir.resolve("comedy-movies.json"));

        storage.save(new ComedyMovie(1, "Superbad"));
        ComedyMovie found = storage.findById(1);

        assertNotNull(found);
        assertEquals(1, found.getId());
        assertEquals("Superbad", found.getTitle());
    }

    @Test
    void duplicateIdIsNotSavedTwice() throws IOException {
        ComedyMovieStorage storage = new ComedyMovieStorage(tempDir.resolve("comedy-movies.json"));

        storage.save(new ComedyMovie(1, "Superbad"));
        storage.save(new ComedyMovie(1, "Step Brothers"));
        List<ComedyMovie> all = storage.findAll();

        assertEquals(1, all.size());
        assertEquals("Superbad", all.get(0).getTitle());
    }

    @Test
    void findAllReturnsEmptyListWhenNothingSaved() throws IOException {
        ComedyMovieStorage storage = new ComedyMovieStorage(tempDir.resolve("comedy-movies.json"));

        assertTrue(storage.findAll().isEmpty());
    }

    @Test
    void findByIdReturnsNullForMissingId() throws IOException {
        ComedyMovieStorage storage = new ComedyMovieStorage(tempDir.resolve("comedy-movies.json"));

        storage.save(new ComedyMovie(1, "Superbad"));

        assertNull(storage.findById(99));
    }
}