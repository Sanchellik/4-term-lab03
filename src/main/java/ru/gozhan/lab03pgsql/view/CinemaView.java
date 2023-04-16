package ru.gozhan.lab03pgsql.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.table.Cinema;
import ru.gozhan.lab03pgsql.table.Order;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaView {

    private Cinema cinema;

    private ArrayList<Order> orders;

    public String toString() {
        return cinema.getId() + ". " + cinema.getName() + "\nTotal revenue: " + calculateRevenue();
    }

    public int calculateRevenue() {
        return orders.stream().map(Order::getPrice).reduce(0, Integer::sum);
    }

}
