package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.view.HallView;
import ru.gozhan.lab03pgsql.view.SessionView;

import java.util.ArrayList;

public interface DbComplex {

    ArrayList<SessionView> getAllSessionsInfo();

    ArrayList<HallView> getAllHallsInfo();

}
