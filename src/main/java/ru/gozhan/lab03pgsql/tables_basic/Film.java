package ru.gozhan.lab03pgsql.tables_basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.constants.GenreEnum;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    private int id;

    private String title;

    private GenreEnum genre;

    private LocalTime duration;

    public Film(String title, GenreEnum genre, LocalTime duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

//    public ArrayList<Movie> createBasicMovies() {
//
//        ArrayList<Movie> movies = new ArrayList<>();
//
//        movies.add(
//                new Movie(
//                        "Interstellar",
//                        LocalTime.of(3, 5),
//                        GenreEnum.ROMANCE
//                )
//        );
//
//        movies.add(
//                new Movie(
//                        "SpiderMan 1",
//                        LocalTime.of(2, 15),
//                        GenreEnum.ACTION
//                )
//        );
//
//        movies.add(
//                new Movie(
//                        "It",
//                        LocalTime.of(1, 50),
//                        GenreEnum.HORROR
//                )
//        );
//
//        return movies;
//    }

}
