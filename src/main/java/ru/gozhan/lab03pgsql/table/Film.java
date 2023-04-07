package ru.gozhan.lab03pgsql.table;

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

}
