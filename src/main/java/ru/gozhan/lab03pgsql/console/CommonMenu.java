package ru.gozhan.lab03pgsql.console;

import java.util.Scanner;

public class CommonMenu {

    public static void whatWeWillDo() {
        System.out.println("Hi there! What do your to do?");
        System.out.println("1. Log in to client account");
        System.out.println("2. Log in to admin account");
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = scanner.nextInt();

            switch (choice) {
//                case 1 -> ClientPanel.authentication();
                case 2 -> AdminPanel.authentication();
            }
        }

    }

}
