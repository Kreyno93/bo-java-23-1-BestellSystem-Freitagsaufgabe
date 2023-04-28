package de.neuefische;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    ProductRepo productRepo = new ProductRepo();
    OrderRepo orderRepo = new OrderRepo(new HashMap<>());

    ShopService shopService = new ShopService(productRepo, orderRepo);

    @Test
    void getProductById_withValidId_returnsCorrectProduct() {
        //GIVEN
        String id = "1";
        Optional<Product> expected = Optional.of(new Product("1", "Brot"));

        //WHEN
        Optional<Product> actual = shopService.getProductById(id);

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getProductById_withInvalidId_returnsOptionalEmpty() {
        //GIVEN
        String id = "6";
        Optional<Product> expected = Optional.empty();

        //WHEN
        Optional<Product> actual = shopService.getProductById(id);

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
        Optional<Order> expected = Optional.of(orderToAdd);

        //WHEN
        shopService.addOrder(orderToAdd);
        Optional<Order> actual = shopService.getOrderById("1");

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrderById_withInvalidId_returnOptionalEmpty() {
        //GIVEN
        Order orderToAdd = new Order("1", OrderStatus.OPEN, shopService.getListOfProducts());
        Optional<Order> expected = Optional.empty();

        //WHEN
        shopService.addOrder(orderToAdd);
        Optional<Order> actual = shopService.getOrderById("2");

        //THEN
        assertEquals(expected, actual);
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