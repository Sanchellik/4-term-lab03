package ru.gozhan.lab03pgsql;

import ru.gozhan.lab03pgsql.config.BasicDbConfig;
import ru.gozhan.lab03pgsql.console.CommonMenu;
import ru.gozhan.lab03pgsql.util.DbHall;
import ru.gozhan.lab03pgsql.util.impl.DbHallImpl;

public class Main {

    public static void main(String[] args) {

//        if (!BasicDbConfig.checkBasicDbFilling()) {
//            BasicDbConfig.fillAllDbs();
//        }

//        CommonMenu.whatWeWillDo();

//        BasicDbConfig.fillHalls();
        DbHall dbHall = new DbHallImpl();
        dbHall.getAll().forEach(System.out::println);

    }

}
