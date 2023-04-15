package ru.gozhan.lab03pgsql.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.constants.GenreEnum;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    private int id;

    private String title;

    private GenreEnum genre;

    private LocalTime duration;

    public Film(String title, GenreEnum genre, LocalTime duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public static Film scanFilm() {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("\nTitle: ");
            String title = scanner.nextLine();

            System.out.print("Genre (HORROR/ROMANCE/ACTION/): ");
            String genre = scanner.nextLine();

            System.out.print("Duration (style: \"H:mm\"): ");
            String duration = scanner.nextLine();

            return new Film(title, GenreEnum.valueOf(genre), LocalTime.parse(duration, DateTimeFormatter.ofPattern("H:mm")));
        }
    }

}
