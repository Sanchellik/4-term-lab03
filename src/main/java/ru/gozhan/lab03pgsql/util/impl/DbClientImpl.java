package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.config.DbConfig;
import ru.gozhan.lab03pgsql.constants.ClientStatusEnum;
import ru.gozhan.lab03pgsql.user.Client;
import ru.gozhan.lab03pgsql.util.DbClient;

import java.sql.*;
import java.util.ArrayList;

public class DbClientImpl implements DbClient {

    @Override
    public ArrayList<Client> getAll() {

        ArrayList<Client> clients = new ArrayList<>();

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                String name = resultSet.getString("client_name");
                String email = resultSet.getString("client_email");
                String password = resultSet.getString("client_password");

                int budget = resultSet.getInt("client_budget");
                int numberOfTrips = resultSet.getInt("client_number_of_trips");

//                String string_status = resultSet.getString("client_status");

//                ClientStatusEnum status = ClientStatusEnum.valueOf(string_status);
//                ClientStatusEnum status = resultSet.getObject("client_level", ClientStatusEnum.class);

                Client client = new Client(id, name, email, password, budget, numberOfTrips);

                clients.add(client);

            }

            return clients;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void insert(Client client) {
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getPassword());
            preparedStatement.setInt(4, client.getBudget());
            preparedStatement.setInt(5, client.getNumberOfTrips());
//            preparedStatement.setString(6, String.valueOf(client.getStatus()));

            int row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
