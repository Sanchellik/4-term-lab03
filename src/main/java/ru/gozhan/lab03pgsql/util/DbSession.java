package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.table.Session;

import java.util.ArrayList;

public interface DbSession {

    String SQL_SELECT_ALL = "SELECT * FROM sessions";
    String SQL_INSERT = "INSERT INTO sessions (film_id, hall_id, session_date_time, session_seat_cost) VALUES " +
            "(?, ?, ?, ?)";

    String SQL_SELECT_BY_ID = "SELECT * FROM sessions WHERE id = ?";

    ArrayList<Session> getAll();
    void insert(Session session);

    Session getById(int id);

    String SQL_SELECT_BY_HALL_ID = "SELECT * FROM sessions WHERE hall_id = ?";

    ArrayList<Session> getByHallId(int hallId);

}
