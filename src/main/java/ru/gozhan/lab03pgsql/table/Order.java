package ru.gozhan.lab03pgsql.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;

    private int clientId;

    private int sessionId;

    private int seat;

    private int price;

    public Order(int clientId, int sessionId, int seat) {
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.seat = seat;
    }

}
