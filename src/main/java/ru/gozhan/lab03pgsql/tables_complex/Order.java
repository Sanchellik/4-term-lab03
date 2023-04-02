package ru.gozhan.lab03pgsql.tables_complex;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Order {

//    private

    private final String path = "src/main/resources/orders.json";

}
