package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.table.Cinema;

import java.util.ArrayList;

public interface DbCinema {

    String SQL_SELECT_ALL = "SELECT * FROM cinemas";
    String SQL_INSERT = "INSERT INTO cinemas (cinema_name, cinema_address, cinema_supported_formats) VALUES " +
            "(?, ?, ?::movie_format_enum[])";

    ArrayList<Cinema> getAll();
    void insert(Cinema cinema);

}
