package ru.gozhan.lab03pgsql.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;

import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hall {

    private int id;

    private MovieFormatEnum supportedFormat;

    private int countSeats;

    private int cinemaId;

    public Hall(MovieFormatEnum supportedFormat, int countSeats, int cinemaId) {
        this.supportedFormat = supportedFormat;
        this.countSeats = countSeats;
        this.cinemaId = cinemaId;
    }

    public static Hall scanHall(int cinemaId) {
        System.out.print("\nFormat (choose FORMAT_2D/3D/4D): ");

        try (Scanner scanner = new Scanner(System.in)) {
            String supportedFormat = scanner.nextLine();

            System.out.print("Number of seats: ");
            int numberOfSeats = Integer.parseInt(scanner.nextLine());

            return new Hall(MovieFormatEnum.valueOf(supportedFormat), numberOfSeats, cinemaId);
        }
    }

}
