package ru.gozhan.lab03pgsql.tables_complex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.tables_basic.Cinema;
import ru.gozhan.lab03pgsql.tables_basic.Film;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    private Cinema cinema;

    private Film film;

    private Hall hall;

    private LocalDate date;

    private final String path = "src/main/resources/sessions.json";


//    public ArrayList<Session> createBasicSessions() {
//
//        ArrayList<Movie> movies = new Movie().createBasicMovies();
//
//        ArrayList<Session> sessions = new ArrayList<>();
//
//        sessions.add(
//                new Session(
//
//                )
//        );
//
//
//
//        return sessions;
//    }

}
