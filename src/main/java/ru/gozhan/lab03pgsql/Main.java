package ru.gozhan.lab03pgsql;

import ru.gozhan.lab03pgsql.console.CommonMenu;
import ru.gozhan.lab03pgsql.constants.ClientStatusEnum;
import ru.gozhan.lab03pgsql.user.Admin;
import ru.gozhan.lab03pgsql.user.Client;
import ru.gozhan.lab03pgsql.util.DbClient;
import ru.gozhan.lab03pgsql.util.impl.DbClientImpl;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Hello world!");

        DbClient dbClient = new DbClientImpl();
        dbClient.insert(new Client("Alexandr Gozhan", "sasha", "123", 1000, 0, ClientStatusEnum.NEW));
//        CommonMenu.whatWeWillDo();
    }

}
