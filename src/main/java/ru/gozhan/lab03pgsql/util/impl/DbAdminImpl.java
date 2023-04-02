package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.config.DbConfig;
import ru.gozhan.lab03pgsql.user.Admin;
import ru.gozhan.lab03pgsql.util.DbAdmin;

import java.sql.*;
import java.util.ArrayList;

public class DbAdminImpl implements DbAdmin {

    @Override
    public ArrayList<Admin> getAll() {

        ArrayList<Admin> admins = new ArrayList<>();

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_ALL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");
                String email = resultSet.getString("admin_email");
                String password = resultSet.getString("admin_password");

                Admin admin = new Admin(id, email, password);

                admins.add(admin);

            }

            return admins;

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void insert(Admin admin) {
        try (Connection conn = DbConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, admin.getEmail());
            preparedStatement.setString(2, admin.getPassword());

            int row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
