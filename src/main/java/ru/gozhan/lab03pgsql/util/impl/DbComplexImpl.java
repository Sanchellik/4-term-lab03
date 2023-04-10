package ru.gozhan.lab03pgsql.util.impl;

import ru.gozhan.lab03pgsql.table.*;
import ru.gozhan.lab03pgsql.util.*;
import ru.gozhan.lab03pgsql.view.SessionView;

import java.util.ArrayList;

public class DbComplexImpl implements DbComplex {

    private static final DbSession dbSession = new DbSessionImpl();
    private static final DbHall dbHall = new DbHallImpl();
    private static final DbCinema dbCinema = new DbCinemaImpl();
    private static final DbFilm dbFilm = new DbFilmImpl();
    private static final DbOrder dbOrder = new DbOrderImpl();

    @Override
    public ArrayList<SessionView> getAllSessionsInfo() {

        ArrayList<Session> sessions = dbSession.getAll();

        ArrayList<SessionView> listOfSessionViews = new ArrayList<>();
        for (Session session : sessions) {

            ArrayList<Order> orders = dbOrder.getBySessionId(session.getId());

            Film film = dbFilm.getById(session.getFilmId());

            Hall hall = dbHall.getById(session.getHallId());

            Cinema cinema = dbCinema.getById(hall.getCinemaId());

            SessionView sessionView = new SessionView(
                    session.getId(), cinema, hall, film, session, orders);

            listOfSessionViews.add(sessionView);
        }

        return listOfSessionViews;
    }

}
