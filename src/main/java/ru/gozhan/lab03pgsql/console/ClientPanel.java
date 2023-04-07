package ru.gozhan.lab03pgsql.console;

import ru.gozhan.lab03pgsql.user.Client;
import ru.gozhan.lab03pgsql.util.DbClient;
import ru.gozhan.lab03pgsql.util.impl.DbClientImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ClientPanel {

    private static final DbClient dbClient = new DbClientImpl();

    public static void authentication() {

        ArrayList<Client> clients = dbClient.getAll();

        System.out.print("\nEnter your email: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String inputEmail = scanner.nextLine();

            System.out.print("Enter your password: ");
            String inputPassword = scanner.nextLine();

            for (Client client : clients) {
                if (Objects.equals(inputEmail, client.getEmail())
                        && Objects.equals(inputPassword, client.getPassword())) {

                    System.out.println("\nSuccessful authorization");

                    chooseWhatWant(client);
                }
            }
        }
    }

    private static void chooseWhatWant(Client client) {
        System.out.println("1. Check profile");
        System.out.println("2. Increase balance");
        System.out.println("3. Buy ticket");
        System.out.println("4. Exit");

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nYour balance: " + client.getBudget());
                    chooseWhatWant(client);
                }

                case 2 -> {
                    System.out.println(); //TODO replenishment of the balance;
                }

                case 3 -> {
                    System.out.println("\nWe can offer such sessions");

                }

                case 4 -> {
                    CommonMenu.whatWeWillDo();
                }
            }
        }
    }

    public static void registration() {
        System.out.println("\nWelcome to registration");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("How much money do you have: ");
        int budget = scanner.nextInt();

        Client client = new Client(name, email, password, budget, 0);
        dbClient.insert(client);

        System.out.println("\nSuccessful registration. Welcome!");
        chooseWhatWant(client);
    }

}
