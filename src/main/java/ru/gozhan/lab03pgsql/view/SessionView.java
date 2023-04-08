package ru.gozhan.lab03pgsql.view;

import lombok.Data;
import ru.gozhan.lab03pgsql.table.Cinema;
import ru.gozhan.lab03pgsql.table.Film;
import ru.gozhan.lab03pgsql.table.Hall;
import ru.gozhan.lab03pgsql.table.Session;

@Data
public class SessionView {

    private int id;

    private Cinema cinema;

    private Hall hall;

    private Film film;

    private Session session;

}
