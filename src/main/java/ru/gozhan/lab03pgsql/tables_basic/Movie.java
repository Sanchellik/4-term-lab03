package ru.gozhan.lab03pgsql.tables_basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.constants.GenreEnum;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;

import java.time.LocalTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String name;

    private LocalTime duration;

    private GenreEnum genre;

    private MovieFormatEnum format;


    public ArrayList<Movie> createBasicMovies() {

        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(
                new Movie(
                        "Interstellar",
                        LocalTime.of(3, 5),
                        GenreEnum.ROMANCE,
                        MovieFormatEnum.FORMAT_3D
                )
        );

        movies.add(
                new Movie(
                        "SpiderMan 1",
                        LocalTime.of(2, 15),
                        GenreEnum.ACTION,
                        MovieFormatEnum.FORMAT_2D
                )
        );

        movies.add(
                new Movie(
                        "It",
                        LocalTime.of(1, 50),
                        GenreEnum.HORROR,
                        MovieFormatEnum.FORMAT_4D
                )
        );

        return movies;
    }

}
