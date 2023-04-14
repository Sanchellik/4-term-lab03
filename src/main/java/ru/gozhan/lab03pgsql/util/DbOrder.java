package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.table.Order;

import java.util.ArrayList;

public interface DbOrder {

    String SQL_SELECT_BY_CLIENT_ID = "SELECT * FROM orders WHERE client_id = ?";
    String SQL_SELECT_BY_SESSION_ID = "SELECT * FROM orders WHERE session_id = ?";
    String SQL_INSERT = "INSERT INTO orders (session_id, client_id, order_seat, order_price) VALUES (?, ?, ?, ?)";

    ArrayList<Order> getBySessionId(int id);
//    ArrayList<Order> getByClientId(int id); //TODO add it for statistics

    void insert(Order order);

}
