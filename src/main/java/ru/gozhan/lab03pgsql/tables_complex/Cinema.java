package ru.gozhan.lab03pgsql.tables_complex;

import lombok.*;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

    private String name;
    private String address;

    private ArrayList<MovieFormatEnum> supportedFormats;

    private ArrayList<Integer> hallsId;

}
