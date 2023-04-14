package ru.gozhan.lab03pgsql.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.constants.ClientStatusEnum;

@Data
@NoArgsConstructor
public class Client implements Discountable {

    private int id;

    private String name;
    private String email;
    private String password;

    private int budget;
    private int numberOfTrips;

    private ClientStatusEnum status;

    public Client(String name, String email, String password, int budget, int numberOfTrips) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.budget = budget;
        this.numberOfTrips = numberOfTrips;
        this.status = calculateStatus(numberOfTrips);
    }

    public Client(int id, String name, String email, String password, int budget, int numberOfTrips) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.budget = budget;
        this.numberOfTrips = numberOfTrips;
        this.status = calculateStatus(numberOfTrips);
    }

    @Override
    public double calculateDiscount() {
        if (this.status == ClientStatusEnum.VIP) {
            return 0.2;
        } else if (this.status == ClientStatusEnum.FRIEND) {
            return 0.1;
        } else {
            return 0;
        }
    }

    @Override
    public ClientStatusEnum calculateStatus(int numberOfTrips) {
        if (numberOfTrips <= 3) {
            return ClientStatusEnum.NEW;
        } else if (numberOfTrips <= 7) {
            return ClientStatusEnum.FRIEND;
        } else {
            return ClientStatusEnum.VIP;
        }
    }

    public void printInfo() {
        System.out.println("\nName = " + name + "\nEmail = " + email + "\nBudget = " + budget + "\nStatus = " + status +
                "\nDiscount = " + calculateDiscount() * 100 + "%");
    }

}
