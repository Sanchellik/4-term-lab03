package ru.gozhan.lab03pgsql.config;

import ru.gozhan.lab03pgsql.user.Admin;
import ru.gozhan.lab03pgsql.user.Client;
import ru.gozhan.lab03pgsql.util.DbAdmin;
import ru.gozhan.lab03pgsql.util.DbClient;
import ru.gozhan.lab03pgsql.util.impl.DbAdminImpl;
import ru.gozhan.lab03pgsql.util.impl.DbClientImpl;

public class BasicDbConfig {

    public static boolean checkBasicDbFilling() {
        DbAdmin dbAdmin = new DbAdminImpl();
        if (dbAdmin.getAll() == null) {
            return false;
        }

        DbClient dbClient = new DbClientImpl();
        if (dbClient.getAll() == null) {
            return false;
        }

        return true;
    }

    public static void fillAllDb() {
        fillAdmins();
        fillClients();
        fillHalls();
        fillCinemas();
        fillSessions();
    }

    public static void fillAdmins() {
        DbAdmin dbAdmin = new DbAdminImpl();

        dbAdmin.insert(new Admin("admin", "admin"));
    }

    public static void fillClients() {
        DbClient dbClient = new DbClientImpl();

        dbClient.insert(new Client("Gozhan Alexandr", "sasha", "123", 300, 0));
        dbClient.insert(new Client("Butskovsky Kirill", "kirill", "123", 1_000_000, 10));
        dbClient.insert(new Client("Ryabov Nikita", "nikita", "123", 7000, 3));
        dbClient.insert(new Client("Mironov Danil", "danil", "123", 1000, 7));
        dbClient.insert(new Client("Podogov Vadim", "vadim", "123", 2000, 6));
    }

    public static void fillHalls() {

    }

}
