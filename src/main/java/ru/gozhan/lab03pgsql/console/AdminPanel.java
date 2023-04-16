package ru.gozhan.lab03pgsql.console;

import ru.gozhan.lab03pgsql.table.Cinema;
import ru.gozhan.lab03pgsql.table.Film;
import ru.gozhan.lab03pgsql.table.Hall;
import ru.gozhan.lab03pgsql.table.Session;
import ru.gozhan.lab03pgsql.user.Admin;
import ru.gozhan.lab03pgsql.util.*;
import ru.gozhan.lab03pgsql.util.impl.*;
import ru.gozhan.lab03pgsql.view.HallView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AdminPanel {

    private static final DbAdmin dbAdmin = new DbAdminImpl();
    private static final DbCinema dbCinema = new DbCinemaImpl();
    private static final DbFilm dbFilm = new DbFilmImpl();
    private static final DbHall dbHall = new DbHallImpl();
    private static final DbSession dbSession = new DbSessionImpl();
    private static final DbComplex dbComplex = new DbComplexImpl();

    public static void authentication(int numberOfAttempts) {

        ArrayList<Admin> admins = dbAdmin.getAll();

        System.out.print("\nEnter your email: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String inputEmail = scanner.nextLine();

            System.out.print("Enter your password: ");
            String inputPassword = scanner.nextLine();

            for (Admin admin : admins) {
                if (Objects.equals(inputEmail, admin.getEmail())
                        && Objects.equals(inputPassword, admin.getPassword())) {

                    System.out.println("\nSuccessful authorization");

                    chooseWhatWant();
                }
            }

            System.out.println("\nIncorrect login or password");
            ++numberOfAttempts;
            if (numberOfAttempts > 2) {
                CommonMenu.whatWeWillDo();
            } else {
                authentication(numberOfAttempts);
            }
        }
    }

    private static void chooseWhatWant() {
        System.out.println("\n1. Check statistics");
        System.out.println("2. Add something");
        System.out.println("3. Logout");

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    checkStatistics();
                    chooseWhatWant();
                }

                case 2 -> {
                    chooseWhatAdd();
                    chooseWhatWant();
                }

                case 3 -> {
                    CommonMenu.whatWeWillDo();
                }
            }
        }
    }

    public static void checkStatistics() {
        System.out.println("\n1. By cinemas");
        System.out.println("2. By films");

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> {
                    statisticByCinemas();
                }

//                case 2 -> {
//                    statisticByFilms();
//                }
            }
        }
    }

    public static void statisticByCinemas() {

    }

    private static void chooseWhatAdd() {
        System.out.println("\n1. Add cinema");
        System.out.println("2. Add hall");
        System.out.println("3. Add film");
        System.out.println("4. Add session");

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> {
                    Cinema cinema = Cinema.scanCinema();
                    dbCinema.insert(cinema);
                }

                case 2 -> {
                    addHall();
                }

                case 3 -> {
                    Film film = Film.scanFilm();
                    dbFilm.insert(film);
                }

                case 4 -> {
                    addSession();
                }

            }
        }
    }

    public static void addHall() {

        System.out.println("\nIn which cinema do you want to add a hall?");

        ArrayList<Cinema> cinemas = dbCinema.getAll();
        System.out.println("0. Nope");
        cinemas.forEach(System.out::println);

        try (Scanner scanner = new Scanner(System.in)) {
            int choiceCinemaId = Integer.parseInt(scanner.nextLine());

            if (choiceCinemaId == 0) {
                chooseWhatAdd();
            }

            dbHall.insert(Hall.scanHall(choiceCinemaId));
        }
    }

    public static void addSession() {

        System.out.println("\nIn which hall do you want to create a session?");

        ArrayList<HallView> hallViews = dbComplex.getAllHallsInfo();
        System.out.println("0. Nope");
        hallViews.forEach(System.out::println);

        int choiceHall;
        try (Scanner scanner = new Scanner(System.in)) {
            choiceHall = Integer.parseInt(scanner.nextLine());

            if (choiceHall == 0) {
                chooseWhatAdd();
            }
        }

        System.out.println("\nChoose film");
        ArrayList<Film> films = dbFilm.getAll();
        System.out.println("0. Nope");
        films.forEach(System.out::println);

        try (Scanner scanner = new Scanner(System.in)) {
            int choiceFilm = Integer.parseInt(scanner.nextLine());

            if (choiceFilm == 0) {
                chooseWhatAdd();
            }

            dbSession.insert(Session
                    .scanSession(
                            choiceFilm,
                            hallViews.get(choiceHall).getId()
                    )
            );
        }
    }

}
