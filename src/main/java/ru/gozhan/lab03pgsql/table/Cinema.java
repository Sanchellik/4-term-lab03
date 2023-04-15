package ru.gozhan.lab03pgsql.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

    private int id;

    private String name;
    private String address;

    private ArrayList<MovieFormatEnum> supportedFormats;

    public Cinema(String name, String address, ArrayList<MovieFormatEnum> supportedFormats) {
        this.name = name;
        this.address = address;
        this.supportedFormats = supportedFormats;
    }

    public String supportedFormatsToString() {
        String result = "{";
        for (MovieFormatEnum format : supportedFormats) {
            result += format.toString() + ",";
        }
        result = result.substring(0, result.length() - 1) + "}";
        return result;
    }

    public static Cinema scanCinema() {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("\nName: ");
            String name = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("Supported formats (style: \"{FORMAT_2D,FORMAT_3D,FORMAT_4D}\"): ");
            String supportedFormats = scanner.nextLine();

            return new Cinema(name, address, parseStringToFormatsEnum(supportedFormats));
        }
    }

    public static ArrayList<MovieFormatEnum> parseStringToFormatsEnum(String string) {
        string = string.substring(1, string.length() - 1);
        List<String> splitedStrings;
        splitedStrings = Arrays.asList(string.split(","));

        ArrayList<MovieFormatEnum> result = new ArrayList<>();
        for (String splitString : splitedStrings) {
            result.add(MovieFormatEnum.valueOf(splitString));
        }
        return result;
    }

    public String toString() {
        return id + ". " + name;

    }
}
