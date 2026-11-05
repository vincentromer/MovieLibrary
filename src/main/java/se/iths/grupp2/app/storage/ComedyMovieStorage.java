package se.iths.grupp2.app.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.iths.grupp2.app.model.ComedyMovie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ComedyMovieStorage implements MovieStorage<ComedyMovie> {

    private final Path file;
    private final ObjectMapper mapper = new ObjectMapper();

    public ComedyMovieStorage(Path file) {
        this.file = file;
    }

    // Reads all movies from the file. If the file does not exist, returns an empty list.
    @Override
    public List<ComedyMovie> findAll() throws IOException {
        if (!Files.exists(file)) {
            return new ArrayList<>();
        }
        return mapper.readValue(file.toFile(), new TypeReference<List<ComedyMovie>>() {});
    }

    // Returns the movie with the given id, or null if it does not exist.
    @Override
    public ComedyMovie findById(int id) throws IOException {
        for (ComedyMovie movie : findAll()) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    // Saves the movie. If the id already exists, does nothing.
    @Override
    public void save(ComedyMovie movie) throws IOException {
        if (findById(movie.getId()) != null) {
            return;
        }
        List<ComedyMovie> movies = findAll();
        movies.add(movie);
        mapper.writerWithDefaultPrettyPrinter().writeValue(file.toFile(), movies);
    }
}