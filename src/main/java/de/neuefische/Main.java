package de.neuefische;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo(new HashMap<>());
        ShopService shopService = new ShopService(productRepo, orderRepo);
        Order orderToAdd = new Order("1", OrderStatus.OPEN, new ArrayList<>(List.of(productRepo.getProductById("1"))));
        Order orderToAdd2 = new Order("2", OrderStatus.OPEN, new ArrayList<>(List.of(
                productRepo.getProductById("1"),
                productRepo.getProductById("2"),
                productRepo.getProductById("3")
        )));
        System.out.println(shopService.getProductById("1"));
        System.out.println(shopService.getListOfOrders());
        shopService.addOrder(orderToAdd);
        shopService.addOrder(orderToAdd2);
        System.out.println(shopService.getOrderById("1"));
        System.out.println(shopService.getListOfOrders());
        System.out.println(shopService.getProductById("21321312"));
    }
}