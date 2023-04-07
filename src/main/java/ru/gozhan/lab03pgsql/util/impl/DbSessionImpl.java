package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.config.ConnectToDbConfig;
import ru.gozhan.lab03pgsql.table.Session;
import ru.gozhan.lab03pgsql.util.DbSession;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DbSessionImpl implements DbSession {

    @Override
    public ArrayList<Session> getAll() {

        ArrayList<Session> sessions = new ArrayList<>();

        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                int filmId = resultSet.getInt("film_id");
                int hallId = resultSet.getInt("hall_id");

                LocalDateTime dateTime = resultSet.getTimestamp("session_date_time").toLocalDateTime();

                Session session = new Session(id, filmId, hallId, dateTime);

                sessions.add(session);

            }

            return sessions;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void insert(Session session) {
        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setInt(1, session.getFilmId());
            preparedStatement.setInt(2, session.getHallId());

            preparedStatement.setTimestamp(3, Timestamp.valueOf(session.getDateTime()));

            int row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
