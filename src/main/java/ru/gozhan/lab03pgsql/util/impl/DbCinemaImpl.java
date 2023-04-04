package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.config.ConnectToDbConfig;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;
import ru.gozhan.lab03pgsql.tables_basic.Cinema;
import ru.gozhan.lab03pgsql.util.DbCinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

                Cinema cinema = new Cinema(id, name, address, parseStringToFormatsEnum(stringOfFormats));

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

    public ArrayList<MovieFormatEnum> parseStringToFormatsEnum(String string) {
        string = string.substring(1, string.length() - 1);
        List<String> splitedStrings;
        splitedStrings = Arrays.asList(string.split(","));

        ArrayList<MovieFormatEnum> result = new ArrayList<>();
        for (String splitString : splitedStrings) {
            result.add(MovieFormatEnum.valueOf(splitString));
        }
        return result;
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

}
