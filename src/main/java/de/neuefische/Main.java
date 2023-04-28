package de.neuefische;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo(new HashMap<>());
        ShopService shopService = new ShopService(productRepo,orderRepo );
        Order orderToAdd = new Order("1",OrderStatus.OPEN, shopService.getListOfProducts());

        System.out.println(shopService.getProductById("1"));
        System.out.println(shopService.getListOfOrders());
        shopService.addOrder(orderToAdd);
        System.out.println(shopService.getOrderById("1"));
        System.out.println(shopService.getListOfOrders());
        System.out.println(shopService.getProductById("21321312"));


    }
}