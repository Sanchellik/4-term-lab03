package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.config.ConnectToDbConfig;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;
import ru.gozhan.lab03pgsql.tables_basic.Hall;
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

                MovieFormatEnum supportedFormat = MovieFormatEnum.valueOf(resultSet.getString("hall_format"));

                int countSeats = resultSet.getInt("hall_count_seats");
                int seatCost = resultSet.getInt("hall_seat_cost");

                Hall hall = new Hall(id, supportedFormat, countSeats, seatCost);

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

            preparedStatement.setInt(2, hall.getCostOfSpaces().size());
            preparedStatement.setInt(3, hall.getCostOfSpaces().get(0));

            int row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
