package ru.gozhan.lab03pgsql.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gozhan.lab03pgsql.constants.ClientStatusEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Discountable {

    private int id;

    private String name;
    private String email;
    private String password;

    private int budget;
    private int numberOfTrips;

    private ClientStatusEnum status;

    public Client(String name, String email, String password, int budget, int numberOfTrips, ClientStatusEnum status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.budget = budget;
        this.numberOfTrips = numberOfTrips;
        this.status = status;
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

}
