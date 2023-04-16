package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.table.Hall;

import java.util.ArrayList;

public interface DbHall {

    String SQL_SELECT_ALL = "SELECT * FROM halls";
    String SQL_INSERT = "INSERT INTO halls (hall_format, hall_count_seats, cinema_id) VALUES " +
            "(?::movie_format_enum, ?, ?)";

    String SQL_SELECT_BY_ID = "SELECT * FROM halls WHERE id = ?";

    ArrayList<Hall> getAll();
    void insert(Hall hall);

    Hall getById(int id);

    String SQL_SELECT_BY_CINEMA_ID = "SELECT * FROM halls WHERE cinema_id = ?";

    ArrayList<Hall> getByCinemaId(int cinemaId);

}
