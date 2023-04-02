package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.user.Admin;

import java.util.ArrayList;

public interface DbAdmin {

    String SQL_SELECT_ALL = "SELECT * FROM admins";
    String SQL_INSERT = "INSERT INTO admins (admin_email, admin_password) VALUES " +
            "(?, ?)";

    ArrayList<Admin> getAll();
    void insert(Admin admin);

}
