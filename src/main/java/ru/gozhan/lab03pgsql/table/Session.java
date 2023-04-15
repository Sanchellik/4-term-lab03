package ru.gozhan.lab03pgsql.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    private int id;

    private int filmId;

    private int hallId;

    private LocalDateTime dateTime;

    private int seatCost;

    public Session(int filmId, int hallId, LocalDateTime dateTime, int seatCost) {
        this.filmId = filmId;
        this.hallId = hallId;
        this.dateTime = dateTime;
        this.seatCost = seatCost;
    }

//    public Session scanSession() {
//
//    }

}
