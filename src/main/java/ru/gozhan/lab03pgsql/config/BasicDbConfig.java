package ru.gozhan.lab03pgsql.config;

import ru.gozhan.lab03pgsql.constants.GenreEnum;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;
import ru.gozhan.lab03pgsql.tables_basic.Cinema;
import ru.gozhan.lab03pgsql.tables_basic.Film;
import ru.gozhan.lab03pgsql.user.Admin;
import ru.gozhan.lab03pgsql.user.Client;
import ru.gozhan.lab03pgsql.util.DbAdmin;
import ru.gozhan.lab03pgsql.util.DbCinema;
import ru.gozhan.lab03pgsql.util.DbClient;
import ru.gozhan.lab03pgsql.util.DbFilm;
import ru.gozhan.lab03pgsql.util.impl.DbAdminImpl;
import ru.gozhan.lab03pgsql.util.impl.DbCinemaImpl;
import ru.gozhan.lab03pgsql.util.impl.DbClientImpl;
import ru.gozhan.lab03pgsql.util.impl.DbFilmImpl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class BasicDbConfig {

    public static boolean checkBasicDbFilling() {
        DbAdmin dbAdmin = new DbAdminImpl();
        if (dbAdmin.getAll() == null) {
            return false;
        }

        DbClient dbClient = new DbClientImpl();
        if (dbClient.getAll() == null) {
            return false;
        }

        return true;
    }

    public static void fillAllDbs() {
        fillAdmins();
        fillClients();
        fillFilms();
//        fillCinemas(); //TODO add fillCinemas();
//        fillHalls(); //TODO add fillHalls();
//        fillSessions(); //TODO add fillSessions();
    }

    public static void fillAdmins() {
        DbAdmin dbAdmin = new DbAdminImpl();

        dbAdmin.insert(new Admin("admin", "admin"));
    }

    public static void fillClients() {
        DbClient dbClient = new DbClientImpl();

        dbClient.insert(new Client("Gozhan Alexandr", "sasha", "123", 300, 0));
        dbClient.insert(new Client("Butskovsky Kirill", "kirill", "123", 1_000_000, 10));
        dbClient.insert(new Client("Ryabov Nikita", "nikita", "123", 7000, 3));
        dbClient.insert(new Client("Mironov Danil", "danil", "123", 1000, 7));
        dbClient.insert(new Client("Podogov Vadim", "vadim", "123", 2000, 6));
    }

    public static void fillFilms() {
        DbFilm dbFilm = new DbFilmImpl();

        dbFilm.insert(new Film("Interstellar", GenreEnum.ROMANCE, LocalTime.of(3, 10)));
        dbFilm.insert(new Film("SpiderMan 1", GenreEnum.ACTION, LocalTime.of(2, 15)));
        dbFilm.insert(new Film("It", GenreEnum.HORROR, LocalTime.of(1, 50)));
    }

    public static void fillCinemas() { //TODO this before halls
        DbCinema dbCinema = new DbCinemaImpl();

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

//    public static void fillHalls() { //TODO rewrite this with cinema_id
//        DbHall dbHall = new DbHallImpl();
//
//        dbHall.insert(new Hall(MovieFormatEnum.FORMAT_2D, 20, 500));
//        dbHall.insert(new Hall(MovieFormatEnum.FORMAT_3D, 10, 750));
//        dbHall.insert(new Hall(MovieFormatEnum.FORMAT_4D, 5, 1750));
//    }

}
