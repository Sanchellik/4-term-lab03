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

    public Session(int filmId, int hallId, LocalDateTime dateTime) {
        this.filmId = filmId;
        this.hallId = hallId;
        this.dateTime = dateTime;
    }

}
