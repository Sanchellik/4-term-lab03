//package ru.gozhan.lab03pgsql.console;
//
//import ru.gozhan.lab03pgsql.user.Client;
//
//import java.util.ArrayList;
//import java.util.Objects;
//import java.util.Scanner;
//
//public class ClientPanel {
//
//    public static void authentication() {
//
//        ArrayList<Client> clients = ;
//
//        System.out.print("\nEnter your email: ");
//        try (Scanner scanner = new Scanner(System.in)) {
//            String inputEmail = scanner.nextLine();
//
//            System.out.print("Enter your password: ");
//            String inputPassword = scanner.nextLine();
//
//            for (Client client : clients) {
//                if (Objects.equals(inputEmail, client.getEmail())
//                        && Objects.equals(inputPassword, client.getPassword())) {
//
//                    System.out.println("\nSuccessful authorization");
//
//                    chooseWhatWant(client);
//                }
//            }
//        }
//    }
//
//    private static void chooseWhatWant(Client client) {
//        System.out.println("1. Check balance");
//        System.out.println("2. Increase balance");
//        System.out.println("3. Buy ticket");
//        System.out.println("4. Exit");
//
//        try (Scanner scanner = new Scanner(System.in)) {
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1 -> {
//                    System.out.println("\nYour balance: " + client.getBudget());
//                    chooseWhatWant(client);
//                }
//
//                case 2 -> {
//                    System.out.println("\n Now you may choose sort");
//
//                }
//            }
//        }
//    }
//
//}
