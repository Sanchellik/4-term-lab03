package ru.gozhan.lab03pgsql.console;

import java.util.Scanner;

public class CommonMenu {

    public static void whatWeWillDo() {
        System.out.println("\nHi there! What do your want to do?");
        System.out.println("0. Register account");
        System.out.println("1. Log in to client account");
        System.out.println("2. Log in to admin account");
        System.out.println("3. Exit");
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0 -> ClientPanel.registration();
                case 1 -> ClientPanel.authentication(0);

                case 2 -> AdminPanel.authentication(0);

                case 3 -> System.out.println("\nGoodbye");
            }
        }

    }

}
