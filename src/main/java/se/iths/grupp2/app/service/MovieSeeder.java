package se.iths.grupp2.app.service;

import se.iths.grupp2.app.model.*;
import se.iths.grupp2.app.storage.*;

import java.io.IOException;

public class MovieSeeder {


    public void seedMovies(
            MovieStorage<DramaMovie> dramaStorage,
            MovieStorage<ActionMovie> actionStorage,
            MovieStorage<ComedyMovie> comedyStorage,
            MovieStorage<HorrorMovie> horrorStorage
    ) throws IOException {
        // region Movie creation
        // Drama movies

        DramaMovie dramaMovie1 = new DramaMovie(1, "A Beautiful Mind");
        dramaStorage.save(dramaMovie1);

        DramaMovie dramaMovie2 = new DramaMovie(2, "Dead Poets Society");
        dramaStorage.save(dramaMovie2);

        DramaMovie dramaMovie3 = new DramaMovie(3, "12 Years a Slave");
        dramaStorage.save(dramaMovie3);

        DramaMovie dramaMovie4 = new DramaMovie(4, "The Green Mile");
        dramaStorage.save(dramaMovie4);

        DramaMovie dramaMovie5 = new DramaMovie(5, "Good Will Hunting");
        dramaStorage.save(dramaMovie5);

        // Action movies

        ActionMovie actionMovie1 = new ActionMovie(1, "Spider-Man 2");
        actionStorage.save(actionMovie1);

        ActionMovie actionMovie2 = new ActionMovie(2, "Rush Hour");
        actionStorage.save(actionMovie2);

        ActionMovie actionMovie3 = new ActionMovie(3, "The Avengers");
        actionStorage.save(actionMovie3);

        ActionMovie actionMovie4 = new ActionMovie(4, "The Dark Knight");
        actionStorage.save(actionMovie4);

        ActionMovie actionMovie5 = new ActionMovie(5, "Green Lantern");
        actionStorage.save(actionMovie5);

        // Comedy movies

        ComedyMovie comedyMovie1 = new ComedyMovie(1, "Superbad");
        comedyStorage.save(comedyMovie1);

        ComedyMovie comedyMovie2 = new ComedyMovie(2, "Step Brothers");
        comedyStorage.save(comedyMovie2);

        ComedyMovie comedyMovie3 = new ComedyMovie(3, "Anchorman");
        comedyStorage.save(comedyMovie3);

        ComedyMovie comedyMovie4 = new ComedyMovie(4, "The Hangover");
        comedyStorage.save(comedyMovie4);

        ComedyMovie comedyMovie5 = new ComedyMovie(5, "Bridesmaids");
        comedyStorage.save(comedyMovie5);

        //Horror movies
        HorrorMovie horrorMovie1 = new HorrorMovie(1, "Suicide Club");
        horrorStorage.save(horrorMovie1);

        HorrorMovie horrorMovie2 = new HorrorMovie(2, "Exit 8");
        horrorStorage.save(horrorMovie2);

        HorrorMovie horrorMovie3 = new HorrorMovie(3, "The Lighthouse");
        horrorStorage.save(horrorMovie3);

        HorrorMovie horrorMovie4 = new HorrorMovie(4, "Session 9");
        horrorStorage.save(horrorMovie4);

        HorrorMovie horrorMovie5 = new HorrorMovie(5, "Oculus");
        horrorStorage.save(horrorMovie5);
        // endregion
    }
}
