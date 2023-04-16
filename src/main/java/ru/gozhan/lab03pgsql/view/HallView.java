package ru.gozhan.lab03pgsql.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.table.Cinema;
import ru.gozhan.lab03pgsql.table.Hall;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallView {

    private int id;

    private Cinema cinema;

    private Hall hall;

    public String toString() {
        return id + ". " + cinema.getName() + " " + "hall #" + hall.getId();
    }

}
