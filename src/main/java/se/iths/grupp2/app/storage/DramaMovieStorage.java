package se.iths.grupp2.app.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.iths.grupp2.app.model.DramaMovie;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DramaMovieStorage implements MovieStorage<DramaMovie> {
    private final Path file;
    private final ObjectMapper mapper = new ObjectMapper();

    public DramaMovieStorage(Path file) {
        this.file = file;
    }

    @Override
    public void save(DramaMovie movie) throws IOException {

        DramaMovie existingMovie = findById(movie.getId());
        if (existingMovie != null) {
            return;
        }
        List<DramaMovie> dramaMovies = new ArrayList<>(findAll());
        dramaMovies.add(movie);

        mapper.writerWithDefaultPrettyPrinter().writeValue(file.toFile(), dramaMovies);

    }


    @Override
    public DramaMovie findById(int id) throws IOException {
        List<DramaMovie> dramaMovies = findAll();

        for (DramaMovie movie : dramaMovies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public List<DramaMovie> findAll() throws IOException {
        if (Files.notExists(file)) {
            return List.of();
        }
        List<DramaMovie> dramaMovieList = mapper.readValue(file.toFile(), new TypeReference<List<DramaMovie>>() {
                }
        );
        return dramaMovieList;
    }
}
