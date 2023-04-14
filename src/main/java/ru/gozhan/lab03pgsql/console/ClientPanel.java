package ru.gozhan.lab03pgsql.console;

import ru.gozhan.lab03pgsql.table.Order;
import ru.gozhan.lab03pgsql.user.Client;
import ru.gozhan.lab03pgsql.util.DbClient;
import ru.gozhan.lab03pgsql.util.DbComplex;
import ru.gozhan.lab03pgsql.util.DbOrder;
import ru.gozhan.lab03pgsql.util.impl.DbClientImpl;
import ru.gozhan.lab03pgsql.util.impl.DbComplexImpl;
import ru.gozhan.lab03pgsql.util.impl.DbOrderImpl;
import ru.gozhan.lab03pgsql.view.SessionView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ClientPanel {

    private static final DbClient dbClient = new DbClientImpl();
    private static final DbComplex dbComplex = new DbComplexImpl();
    private static final DbOrder dbOrder = new DbOrderImpl();

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
            System.out.println("\nIncorrect login or password");
            authentication();
        }
    }

    private static void chooseWhatWant(Client client) {
        System.out.println("\n1. Check profile");
        System.out.println("2. Change balance");
        System.out.println("3. Buy ticket");
        System.out.println("4. Logout");

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    client.printInfo();
                    chooseWhatWant(client);
                }

                case 2 -> {
                    System.out.print("Enter your new budget: ");
                    try (Scanner scanner1 = new Scanner(System.in)) {

                        int newBudget = scanner1.nextInt();
                        dbClient.updateBudget(client.getId(), newBudget);

                        client.setBudget(newBudget);
                        chooseWhatWant(client);
                    }
                }

                case 3 -> {
                    bookSeat(client);
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

    public static void bookSeat(Client client) {
        System.out.println("\nWe can offer such sessions");
        System.out.println("0) Exit");

        ArrayList<SessionView> sessionViews = dbComplex.getAllSessionsInfo();
        sessionViews.forEach(System.out::println);

        try (Scanner scanner = new Scanner(System.in)) {
            int sessionChoise = scanner.nextInt();

            if (sessionChoise == 0) {
                chooseWhatWant(client);
            }

            SessionView selectedSessionView = sessionViews.get(sessionChoise - 1);

            System.out.println("\nDefault price: " + selectedSessionView.getSession().getSeatCost());
            selectedSessionView.hallScheme(client);

            System.out.println("Choose seat");
            int seatChoise = scanner.nextInt();

            if (selectedSessionView.isSeatPurchased(seatChoise)) {
                System.out.println("\nThis seat purchased. Choose another");
                bookSeat(client);
            }

            if (!selectedSessionView.doesClientHaveMoneyToBook(client)) {
                System.out.println("\nYou don't have money to book");
                bookSeat(client);
            }

            client.setBudget(client.getBudget() - selectedSessionView.getPriceForClient(client));
            dbClient.updateBudget(
                    client.getId(),
                    client.getBudget() - selectedSessionView.getPriceForClient(client)
            );

            dbOrder.insert(new Order(
                    client.getId(),
                    selectedSessionView.getSession().getId(),
                    seatChoise,
                    selectedSessionView.getPriceForClient(client))
            );

            client.setNumberOfTrips(client.getNumberOfTrips() + 1);
            dbClient.updateNumberOfTrips(
                    client.getId(),
                    client.getNumberOfTrips() + 1
            );

            System.out.println("\nSuccessful book");
            chooseWhatWant(client);

        }
    }

}
