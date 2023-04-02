package ru.gozhan.lab03pgsql.tables_basic;

import lombok.*;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hall {

    private ArrayList<Integer> costOfSpaces;

    private MovieFormatEnum supportedFormat;

}
