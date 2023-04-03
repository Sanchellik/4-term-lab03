package ru.gozhan.lab03pgsql.user;

import ru.gozhan.lab03pgsql.constants.ClientStatusEnum;

public interface Discountable {

    double calculateDiscount();
    ClientStatusEnum calculateStatus(int numberOfTrips);

}
