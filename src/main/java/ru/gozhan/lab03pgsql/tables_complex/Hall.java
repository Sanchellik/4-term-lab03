package ru.gozhan.lab03pgsql.tables_complex;

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

    private int cinemaId;

    public Hall(int id, MovieFormatEnum supportedFormat, int countSeats, int seatCost, int cinemaId) {
        this.id = id;
        this.supportedFormat = supportedFormat;
        this.costOfSpaces = fillCostOfSpaces(countSeats, seatCost);
        this.cinemaId = cinemaId;
    }

    public Hall(MovieFormatEnum supportedFormat, int countSeats, int seatCost, int cinemaId) {
        this.supportedFormat = supportedFormat;
        this.costOfSpaces = fillCostOfSpaces(countSeats, seatCost);
        this.cinemaId = cinemaId;
    }

    public ArrayList<Integer> fillCostOfSpaces(int countSeats, int seatCost) {

        return new ArrayList<>(Collections.nCopies(countSeats, seatCost));
    }
}
