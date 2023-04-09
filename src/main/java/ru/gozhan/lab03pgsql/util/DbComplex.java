package ru.gozhan.lab03pgsql.util;

import ru.gozhan.lab03pgsql.view.SessionView;

import java.util.ArrayList;

public interface DbComplex {

//    String SQL_INNER_JOIN_FOR_SESSION_VIEW = ""; //TODO finish inner join query

    ArrayList<SessionView> getAllSessionsInfo();

}
