package de.neuefische;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private OrderStatus orderStatus;
    private ArrayList<Product> products;


}
