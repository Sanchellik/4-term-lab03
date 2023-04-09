package ru.gozhan.lab03pgsql.config;

import ru.gozhan.lab03pgsql.constants.GenreEnum;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;
import ru.gozhan.lab03pgsql.table.Cinema;
import ru.gozhan.lab03pgsql.table.Film;
import ru.gozhan.lab03pgsql.table.Hall;
import ru.gozhan.lab03pgsql.table.Session;
import ru.gozhan.lab03pgsql.user.Admin;
import ru.gozhan.lab03pgsql.user.Client;
import ru.gozhan.lab03pgsql.util.*;
import ru.gozhan.lab03pgsql.util.impl.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BasicDbConfig {

    private static final DbAdmin dbAdmin = new DbAdminImpl();
    private static final DbClient dbClient = new DbClientImpl();
    private static final DbCinema dbCinema = new DbCinemaImpl();
    private static final DbHall dbHall = new DbHallImpl();
    private static final DbFilm dbFilm = new DbFilmImpl();
    private static final DbSession dbSession = new DbSessionImpl();

    public static boolean checkBasicDbFilling() {
        if (Objects.equals(dbAdmin.getAll(), new ArrayList<>())) return false;

        if (Objects.equals(dbClient.getAll(), new ArrayList<>())) return false;

        if (Objects.equals(dbCinema.getAll(), new ArrayList<>())) return false;

        if (Objects.equals(dbHall.getAll(), new ArrayList<>())) return false;

        if (Objects.equals(dbFilm.getAll(), new ArrayList<>())) return false;

        if (Objects.equals(dbSession.getAll(), new ArrayList<>())) return false;

        return true;
    }

    public static void truncateAllDbs() {
        try (Connection conn = ConnectToDbConfig.getConnection();
             Statement statement = conn.createStatement()) {
            int result = statement.executeUpdate("TRUNCATE admins, cinemas, clients, films, halls, orders, sessions RESTART IDENTITY;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillAllDbs() {
        truncateAllDbs();
        fillAdmins();
        fillClients();
        fillFilms();
        fillCinemas();
        fillHalls();
        fillSessions();
    }

    public static void fillAdmins() {
        dbAdmin.insert(new Admin("admin", "admin"));
    }

    public static void fillClients() {
        dbClient.insert(new Client("Gozhan Alexandr", "sasha", "123", 300, 0));
        dbClient.insert(new Client("Butskovsky Kirill", "kirill", "123", 1_000_000, 10));
        dbClient.insert(new Client("Ryabov Nikita", "nikita", "123", 7000, 3));
        dbClient.insert(new Client("Mironov Danil", "danil", "123", 1000, 7));
        dbClient.insert(new Client("Podogov Vadim", "vadim", "123", 2000, 6));
    }

    public static void fillFilms() {
        dbFilm.insert(new Film("Interstellar", GenreEnum.ROMANCE, LocalTime.of(3, 10)));
        dbFilm.insert(new Film("SpiderMan 1", GenreEnum.ACTION, LocalTime.of(2, 15)));
        dbFilm.insert(new Film("It", GenreEnum.HORROR, LocalTime.of(1, 50)));
    }

    public static void fillCinemas() {
        dbCinema.insert(new Cinema("KinoMax", "Krasnodar",
                new ArrayList<>(Arrays.asList(
                        MovieFormatEnum.FORMAT_2D,
                        MovieFormatEnum.FORMAT_3D,
                        MovieFormatEnum.FORMAT_4D))));
        dbCinema.insert(new Cinema("Galaxy", "Krasnodar",
                new ArrayList<>(Arrays.asList(
                        MovieFormatEnum.FORMAT_2D,
                        MovieFormatEnum.FORMAT_3D,
                        MovieFormatEnum.FORMAT_4D))));
    }

    public static void fillHalls() {
        dbHall.insert(new Hall(MovieFormatEnum.FORMAT_2D, 20, 1));
        dbHall.insert(new Hall(MovieFormatEnum.FORMAT_2D, 25, 2));

        dbHall.insert(new Hall(MovieFormatEnum.FORMAT_3D, 15, 1));
        dbHall.insert(new Hall(MovieFormatEnum.FORMAT_3D, 10, 2));

        dbHall.insert(new Hall(MovieFormatEnum.FORMAT_4D, 5, 1));
        dbHall.insert(new Hall(MovieFormatEnum.FORMAT_4D, 2, 2));
    }

    public static void fillSessions() {
        String localDateTimePattern = "dd-MM-yyyy HH:mm";
        dbSession.insert(new Session(1, 1,
                LocalDateTime.parse("08-05-2023 20:30", DateTimeFormatter.ofPattern(localDateTimePattern)),
                500));

        dbSession.insert(new Session(1, 4,
                LocalDateTime.parse("09-05-2023 21:45", DateTimeFormatter.ofPattern(localDateTimePattern)),
                1500));

    }

}
