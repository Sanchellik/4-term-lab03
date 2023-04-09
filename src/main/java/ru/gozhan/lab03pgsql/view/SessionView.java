package ru.gozhan.lab03pgsql.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.gozhan.lab03pgsql.table.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
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

}
