package se.iths.grupp2.app.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.iths.grupp2.app.model.HorrorMovie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class HorrorMovieStorage implements MovieStorage<HorrorMovie> {

    ObjectMapper mapper = new ObjectMapper();
    Path filePath;

    public HorrorMovieStorage(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(HorrorMovie horrorMovie) throws IOException {
        boolean movieExisting = findById(horrorMovie.getId()) != null;
        if (movieExisting) {
            return;
        }
        List<HorrorMovie> horrorMovies = findAll();

        horrorMovies.add(horrorMovie);

        mapper.writerWithDefaultPrettyPrinter().writeValue(filePath.toFile(), horrorMovies);
    }

    public List<HorrorMovie> findAll() throws IOException {
        if (Files.exists(filePath)) {
            List<HorrorMovie> horrorMovies = mapper.readValue(
                    filePath.toFile(),
                    new TypeReference<List<HorrorMovie>>() {
                    });
            return horrorMovies;
        }
        else {
            return new ArrayList<>();
        }
    }

    @Override
    public HorrorMovie findById(int id) throws IOException {
        List<HorrorMovie> horrorMovies = findAll();
        for (HorrorMovie horrorMovie : horrorMovies) {
            if (horrorMovie.getId() == id) {
                return horrorMovie;
            }
        }
        return null;
    }
}
