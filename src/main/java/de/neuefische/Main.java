package de.neuefische;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderRepo(new HashMap<>());
        ShopService shopService = new ShopService(productRepo, orderRepo);
        Order orderToAdd = new Order("1", OrderStatus.OPEN, shopService.getListOfProducts());
        Product productToAdd = productRepo.getProductById("1");
        Product productToAdd2 = productRepo.getProductById("2");
        Product productToAdd3 = productRepo.getProductById("3");
        Order orderToAdd2 = new Order("2", OrderStatus.OPEN, new ArrayList<>(List.of(productToAdd, productToAdd2, productToAdd3)));

        System.out.println(shopService.getProductById("1"));
        System.out.println(shopService.getListOfOrders());
        shopService.addOrder(orderToAdd);
        shopService.addOrder(orderToAdd2);
        System.out.println(shopService.getOrderById("1"));
        System.out.println(shopService.getListOfOrders());
        System.out.println(shopService.getProductById("21321312"));


    }
}