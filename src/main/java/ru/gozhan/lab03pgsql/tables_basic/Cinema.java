package ru.gozhan.lab03pgsql.tables_basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;

import java.util.ArrayList;

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

}
