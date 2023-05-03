package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopServiceTest {

    ProductRepo productRepo = new ProductRepo();
    OrderRepo orderRepo = new OrderRepo(new HashMap<>());

    ShopService shopService = new ShopService(productRepo, orderRepo);

    @Test
    void getProductById_withValidId_returnsCorrectProduct() {
        //GIVEN
        String id = "1";
        Product expected = new Product("1", "Brot");

        //WHEN
        Product actual = shopService.getProductById(id);

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getListOfProducts() {
        //GIVEN
        ArrayList<Product> expected = new ArrayList<>(List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch"),
                new Product("3", "Eier"),
                new Product("4", "Käse"),
                new Product("5", "Wurst")
        )
        );

        //WHEN
        ArrayList<Product> actual = shopService.getListOfProducts();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void addOrder() {
        //GIVEN
        Order orderToAdd = new Order("1", OrderStatus.OPEN, new ArrayList<>());
        ArrayList<Order> expected = new ArrayList<>(List.of(
                new Order("1", OrderStatus.OPEN, new ArrayList<>())
        ));

        //WHEN
        shopService.addOrder(orderToAdd);
        ArrayList<Order> actual = shopService.getListOfOrders();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrderById_withValidId_returnCorrectOrder() {
        //GIVEN
        Order orderToAdd = new Order("1", OrderStatus.OPEN, shopService.getListOfProducts());

        //WHEN
        shopService.addOrder(orderToAdd);
        Order actual = shopService.getOrderById("1");

        //THEN
        assertEquals(orderToAdd, actual);
    }


    @Test
    void getOrders() {
        //GIVEN
        Order orderToAdd = new Order("1", OrderStatus.OPEN, shopService.getListOfProducts());
        ArrayList<Order> expected = new ArrayList<>(List.of(
                orderToAdd)
        );

        //WHEN
        shopService.addOrder(orderToAdd);
        ArrayList<Order> actual = shopService.getListOfOrders();

        //THEN
        assertEquals(expected, actual);
    }

}