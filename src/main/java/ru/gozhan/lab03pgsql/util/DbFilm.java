package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.table.Film;

import java.util.ArrayList;

public interface DbFilm {

    String SQL_SELECT_ALL = "SELECT * FROM films";
    String SQL_INSERT = "INSERT INTO films (film_title, film_genre, film_duration) VALUES " +
            "(?, ?::genre_enum, ?)";

    ArrayList<Film> getAll();
    void insert(Film film);

}
