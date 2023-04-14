package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.user.Client;

import java.util.ArrayList;

public interface DbClient {

    String SQL_SELECT_ALL = "SELECT * FROM clients";
    String SQL_INSERT = "INSERT INTO clients (client_name, client_email, client_password, client_budget, " +
            "client_number_of_trips) VALUES (?, ?, ?, ?, ?)";

    String SQL_UPDATE_BUDGET_BY_ID = "UPDATE clients SET client_budget = ? WHERE id = ?";
    String SQL_UPDATE_NUMBER_OF_TRIPS_BY_ID = "UPDATE clients SET client_number_of_trips = ? WHERE id = ?";

    ArrayList<Client> getAll();
    void insert(Client client);

    void updateBudget(int id, int newBudget);
    void updateNumberOfTrips(int id, int newNumberOfTrips);

}
