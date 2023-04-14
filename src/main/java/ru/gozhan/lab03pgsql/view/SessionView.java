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
        return id + ") " + cinema.getName() + " " +
                film.getTitle() + " " + hall.getSupportedFormat() + " " + session.getDateTime();
    }

    public void hallScheme(Client client) {

        Set<Integer> bookedSeats = new HashSet<>();
        for (Order order : orders) {
            bookedSeats.add(order.getSeat());
        }

        for (int i = 0; i < hall.getCountSeats(); ++i) {

//            if (!bookedSeats.contains(i)) {
//                System.out.print("\u001B[32m" + "(" + (i + 1) + ") " + session.getSeatCost() * (1 - client.calculateDiscount()) + "  ");
//            } else {
//                System.out.print("\u001B[31m" + "(" + (i + 1) + ") " + session.getSeatCost() * (1 - client.calculateDiscount()) + "  ");
//            }
            if (!bookedSeats.contains(i)) {
//                System.out.printf("\u001B[32m" + "(" + (i + 1) + ") " + session.getSeatCost() * (1 - client.calculateDiscount()) + "  ");
                System.out.printf("\u001B[32m(%2d) %.0f  ", (i + 1), session.getSeatCost() * (1 - client.calculateDiscount()));
            } else {
//                System.out.printf("\u001B[31m" + "(" + (i + 1) + ") " + session.getSeatCost() * (1 - client.calculateDiscount()) + "  ");
                System.out.printf("\u001B[31m(%2d) %.0f  ", (i + 1), session.getSeatCost() * (1 - client.calculateDiscount()));
            }

            if (i % 5 == 4) {
                System.out.println("\u001B[0m");
            }

        }
    }

}
