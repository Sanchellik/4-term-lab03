package ru.gozhan.lab03pgsql.tables_complex;

import lombok.*;
import ru.gozhan.lab03pgsql.tables_basic.Hall;
import ru.gozhan.lab03pgsql.tables_basic.Movie;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    private Cinema cinema;

    private Movie movie;

    private Hall hall;

    private LocalDate date;

    private final String path = "src/main/resources/sessions.json";


    public ArrayList<Session> createBasicSessions() {

        ArrayList<Movie> movies = new Movie().createBasicMovies();

        ArrayList<Session> sessions = new ArrayList<>();

        sessions.add(
                new Session(

                )
        );



        return sessions;
    }

}
