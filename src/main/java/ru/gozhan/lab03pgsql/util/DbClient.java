package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.user.Client;

import java.util.ArrayList;

public interface DbClient {

    String SQL_SELECT_ALL = "SELECT * FROM clients";
    String SQL_INSERT = "INSERT INTO clients (client_name, client_email, client_password, client_budget, client) VALUES " +
            "(?, ?)";

    ArrayList<Client> getAll();
    void insert(Client client);

}
