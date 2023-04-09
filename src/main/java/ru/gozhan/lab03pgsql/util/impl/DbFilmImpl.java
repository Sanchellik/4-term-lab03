package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.config.ConnectToDbConfig;
import ru.gozhan.lab03pgsql.constants.GenreEnum;
import ru.gozhan.lab03pgsql.table.Film;
import ru.gozhan.lab03pgsql.util.DbFilm;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class DbFilmImpl implements DbFilm {

    @Override
    public ArrayList<Film> getAll() {

        ArrayList<Film> films = new ArrayList<>();

        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                String title = resultSet.getString("film_title");

                GenreEnum genre = GenreEnum
                        .valueOf(resultSet.getString("film_genre"));

                LocalTime duration = resultSet.getTime("film_duration").toLocalTime();

                Film film = new Film(id, title, genre, duration);
                films.add(film);

            }

            return films;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void insert(Film film) {
        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, film.getTitle());

            preparedStatement.setString(2, film.getGenre().toString());
            preparedStatement.setTime(3, Time.valueOf(film.getDuration()));

            int row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Film getById(int id) {

        Film film = null;

        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_BY_ID)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                String title = resultSet.getString("film_title");

                GenreEnum genre = GenreEnum
                        .valueOf(resultSet.getString("film_genre"));

                LocalTime duration = resultSet.getTime("film_duration").toLocalTime();

                film = new Film(id, title, genre, duration);

            }

            return film;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
