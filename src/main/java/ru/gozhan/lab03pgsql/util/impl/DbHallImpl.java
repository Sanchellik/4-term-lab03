package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.config.ConnectToDbConfig;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;
import ru.gozhan.lab03pgsql.table.Hall;
import ru.gozhan.lab03pgsql.util.DbHall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbHallImpl implements DbHall {

    @Override
    public ArrayList<Hall> getAll() {

        ArrayList<Hall> halls = new ArrayList<>();

        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                MovieFormatEnum supportedFormat = MovieFormatEnum
                        .valueOf(resultSet.getString("hall_format"));

                int countSeats = resultSet.getInt("hall_count_seats");
//                int seatCost = resultSet.getInt("hall_seat_cost");
                int cinemaId = resultSet.getInt("cinema_id");

                Hall hall = new Hall(id, supportedFormat, countSeats, cinemaId);

                halls.add(hall);

            }

            return halls;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void insert(Hall hall) {
        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, hall.getSupportedFormat().toString());

            preparedStatement.setInt(2, hall.getCountSeats());
            preparedStatement.setInt(3, hall.getCinemaId());

            int row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Hall getById(int id) {

        Hall hall = null;

        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_BY_ID)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

//                int id = resultSet.getInt("id");

                MovieFormatEnum supportedFormat = MovieFormatEnum
                        .valueOf(resultSet.getString("hall_format"));

                int countSeats = resultSet.getInt("hall_count_seats");
//                int seatCost = resultSet.getInt("hall_seat_cost");
                int cinemaId = resultSet.getInt("cinema_id");

                hall = new Hall(id, supportedFormat, countSeats, cinemaId);

            }

            return hall;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Hall> getByCinemaId(int cinemaId) {

        ArrayList<Hall> halls = new ArrayList<>();

        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_BY_CINEMA_ID)) {

            preparedStatement.setInt(1, cinemaId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                MovieFormatEnum supportedFormat = MovieFormatEnum
                        .valueOf(resultSet.getString("hall_format"));

                int countSeats = resultSet.getInt("hall_count_seats");

                Hall hall = new Hall(id, supportedFormat, countSeats, cinemaId);

                halls.add(hall);

            }

            return halls;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


}
