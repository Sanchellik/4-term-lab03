package ru.gozhan.lab03pgsql.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.table.*;
import ru.gozhan.lab03pgsql.user.Client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionView {

    private int id;

    private Cinema cinema;

    private Hall hall;

    private Film film;

    private Session session;

    private ArrayList<Order> orders;

    public String toString() {
        return id + ". " + cinema.getName() + " " +
                film.getTitle() + " " + hall.getSupportedFormat() + " " + session.getDateTime();
    }

    public void printHallScheme(Client client) {

        for (int i = 1; i < hall.getCountSeats() + 1; ++i) {

            if (!isSeatPurchased(i)) {
                System.out.printf("\u001B[32m(%2d) %.0f  \u001B[0m", (i), session.getSeatCost() * (1 - client.calculateDiscount()));
            } else {
                System.out.printf("\u001B[31m(%2d) %.0f  \u001B[0m", (i), session.getSeatCost() * (1 - client.calculateDiscount()));
            }

            if (i % 5 == 0) {
                System.out.println("\u001B[0m");
            }

        }
    }

    public boolean isSeatPurchased(int seat) {
        Set<Integer> bookedSeats = new HashSet<>();
        for (Order order : orders) {
            bookedSeats.add(order.getSeat());
        }
        return bookedSeats.contains(seat);
    }

    public int getPriceForClient(Client client) {
        return (int) (session.getSeatCost() * (1 - client.calculateDiscount()));
    }

    public boolean doesClientHaveMoneyToBook(Client client) {
        return client.getBudget() >= getPriceForClient(client);
    }

}
