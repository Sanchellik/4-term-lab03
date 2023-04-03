package ru.gozhan.lab03pgsql.tables_basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.constants.MovieFormatEnum;

import java.util.ArrayList;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hall {

    private int id;

    private MovieFormatEnum supportedFormat;

    private ArrayList<Integer> costOfSpaces;

    public Hall(int id, MovieFormatEnum supportedFormat, int countSeats, int seatCost) {
        this.id = id;
        this.supportedFormat = supportedFormat;
        this.costOfSpaces = fillCostOfSpaces(countSeats, seatCost);
    }

    public Hall(MovieFormatEnum supportedFormat, int countSeats, int seatCost) {
        this.supportedFormat = supportedFormat;
        this.costOfSpaces = fillCostOfSpaces(countSeats, seatCost);
    }

    public ArrayList<Integer> fillCostOfSpaces(int countSeats, int seatCost) {

        return new ArrayList<>(Collections.nCopies(countSeats, seatCost));
    }
}
