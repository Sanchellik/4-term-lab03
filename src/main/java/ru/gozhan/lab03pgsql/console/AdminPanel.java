package ru.gozhan.lab03pgsql.console;

import ru.gozhan.lab03pgsql.user.Admin;
import ru.gozhan.lab03pgsql.util.DbAdmin;
import ru.gozhan.lab03pgsql.util.impl.DbAdminImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AdminPanel {

    private static final DbAdmin dbAdmin = new DbAdminImpl();

    public static void authentication() {

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

                    chooseWhatWant(admin);
                }
            }

            System.out.println("\nIncorrect login or password");
        }
    }

    private static void chooseWhatWant(Admin admin) {

    }

}
