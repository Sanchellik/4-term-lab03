package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.config.ConnectToDbConfig;
import ru.gozhan.lab03pgsql.table.Order;
import ru.gozhan.lab03pgsql.util.DbOrder;

import java.sql.*;
import java.util.ArrayList;

public class DbOrderImpl implements DbOrder {

    @Override
    public ArrayList<Order> getBySessionId(int id) {

        ArrayList<Order> orders = new ArrayList<>();

        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_BY_SESSION_ID)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int clientId = resultSet.getInt("client_id");
                int sessionId = resultSet.getInt("session_id");
                int seat = resultSet.getInt("order_seat");
                int price = resultSet.getInt("order_price");

                Order order = new Order(clientId, sessionId, seat, price);
                orders.add(order);
            }

            return orders;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void insert(Order order) {
        try (Connection conn = ConnectToDbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setInt(1, order.getSessionId());
            preparedStatement.setInt(2, order.getClientId());
            preparedStatement.setInt(3, order.getSeat());
            preparedStatement.setInt(4, order.getPrice());

            int row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
