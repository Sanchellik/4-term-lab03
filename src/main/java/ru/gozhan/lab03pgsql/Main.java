package ru.gozhan.lab03pgsql;

import ru.gozhan.lab03pgsql.config.BasicDbConfig;
import ru.gozhan.lab03pgsql.console.CommonMenu;

public class Main {

    public static void main(String[] args) {

        if (!BasicDbConfig.checkBasicDbFilling()) {
            BasicDbConfig.fillAllDbs();
        }
        CommonMenu.whatWeWillDo();

    }

}
