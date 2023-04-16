package ru.gozhan.lab03pgsql.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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

    public static Session scanSession(int filmId, int hallId) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Date Time (format: \"2023-05-09 21:45:\"): ");
            String dateTime = scanner.nextLine();

            System.out.print("Cost: ");
            int seatCost = scanner.nextInt();

            return new Session(
                    filmId,
                    hallId,
                    LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                    seatCost
            );
        }
    }

}
