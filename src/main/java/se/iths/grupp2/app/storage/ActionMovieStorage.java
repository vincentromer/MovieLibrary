package se.iths.grupp2.app.storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.iths.grupp2.app.model.ActionMovie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ActionMovieStorage implements MovieStorage<ActionMovie> {

    ObjectMapper mapper = new ObjectMapper();

    Path filePath;

    public ActionMovieStorage(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(ActionMovie actionMovie) throws IOException {
        if (Files.exists(filePath)) {
            boolean movieExists = findById(actionMovie.getId()) != null;
            if (movieExists) {
                return;
            }
            List<ActionMovie> actionMovies = findAll();
            IO.println("ActionMovies = " + actionMovies);

            actionMovies.add(actionMovie);

            mapper.writerWithDefaultPrettyPrinter().writeValue(filePath.toFile(), actionMovies);
        }
    }

    @Override
    public List<ActionMovie> findAll() throws IOException {
        if (Files.exists(filePath)) {
            List<ActionMovie> actionMovies = mapper.readValue(
                    filePath.toFile(),
                    new TypeReference<List<ActionMovie>>() {
            });
            return actionMovies;
        }
        else {
            return List.of();
        }
    }

    @Override
    public ActionMovie findById(int id) throws IOException {
        List<ActionMovie> actionMovies = findAll();
        for (ActionMovie actionMovie : actionMovies) {
            if (actionMovie.getId() == id) {
                return actionMovie;
            }
        }
        return null;
    }

}
