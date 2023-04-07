package ru.gozhan.lab03pgsql.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDbConfig {

    public static String url = "jdbc:postgresql://localhost:5432/term-4-prog-lab03";
    public static String user = "postgres";
    public static String password = "123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
