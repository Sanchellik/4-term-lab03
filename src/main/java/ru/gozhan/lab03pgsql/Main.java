package ru.gozhan.lab03pgsql;

import ru.gozhan.lab03pgsql.config.BasicDbConfig;
import ru.gozhan.lab03pgsql.util.DbCinema;
import ru.gozhan.lab03pgsql.util.DbFilm;
import ru.gozhan.lab03pgsql.util.impl.DbCinemaImpl;
import ru.gozhan.lab03pgsql.util.impl.DbFilmImpl;

public class Main {

    public static void main(String[] args) {

//        if (!BasicDbConfig.checkBasicDbFilling()) {
//            BasicDbConfig.fillAllDbs();
//        }

//        CommonMenu.whatWeWillDo();

//        BasicDbConfig.fillHalls();

//        DbHall dbHall = new DbHallImpl();
//        dbHall.getAll().forEach(System.out::println);

//        BasicDbConfig.fillFilms();

//        DbFilm dbFilm = new DbFilmImpl();
//        dbFilm.getAll().forEach(System.out::println);

        BasicDbConfig.fillCinemas();

//        DbCinema dbCinema = new DbCinemaImpl();
//        dbCinema.getAll().forEach(System.out::println);

    }

}
