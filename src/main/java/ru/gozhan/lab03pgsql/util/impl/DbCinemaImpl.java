package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.config.ConnectToDbConfig;
import ru.gozhan.lab03pgsql.table.Cinema;
import ru.gozhan.lab03pgsql.util.DbCinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbCinemaImpl implements DbCinema {

    @Override
    public ArrayList<Cinema> getAll() {

        ArrayList<Cinema> cinemas = new ArrayList<>();

        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                String name = resultSet.getString("cinema_name");
                String address = resultSet.getString("cinema_address");

                String stringOfFormats = (resultSet.getString("cinema_supported_formats"));

                Cinema cinema = new Cinema(id, name, address, Cinema.parseStringToFormatsEnum(stringOfFormats));

                cinemas.add(cinema);

            }

            return cinemas;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void insert(Cinema cinema) {
        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, cinema.getName());

            preparedStatement.setString(2, cinema.getAddress());
            preparedStatement.setString(3, cinema.supportedFormatsToString());

            int row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cinema getById(int id) {

        Cinema cinema = null;

        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_BY_ID)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString("cinema_name");
                String address = resultSet.getString("cinema_address");

                String stringOfFormats = (resultSet.getString("cinema_supported_formats"));

                cinema = new Cinema(id, name, address, Cinema.parseStringToFormatsEnum(stringOfFormats));

            }

            return cinema;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
