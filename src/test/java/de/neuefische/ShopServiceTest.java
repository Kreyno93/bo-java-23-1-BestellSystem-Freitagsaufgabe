package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    ProductRepo productRepo = new ProductRepo();
    OrderRepo orderRepo = new OrderRepo(new ArrayList<>());

    ShopService shopService = new ShopService(productRepo, orderRepo);

    @Test
    void getProductById_withValidId_returnsCorrectProduct() {
        //GIVEN
        String id = "1";
        Optional<Product> expected = Optional.of(new Product("1", "Bread"));

        //WHEN
        Optional<Product> actual = shopService.getProductById(id);

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getProductById_withInvalidId_returnsOptionalEmpty(){
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
        List<Product> expected = List.of(
                new Product("1", "Bread"),
                new Product("2", "Butter"),
                new Product("3", "Milk"),
                new Product("4", "Cheese"),
                new Product("5", "Eggs")
        );

        //WHEN
        List<Product> actual = shopService.getListOfProducts();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void addOrder() {
        //GIVEN
        Order orderToAdd = new Order("1",OrderStatus.OPEN, shopService.getListOfProducts());
        List<Order> expected = List.of(orderToAdd);

        //WHEN
        shopService.addOrder(orderToAdd);
        List<Order> actual = shopService.getOrders();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrderById_withValidId_returnCorrectOrder() {
        //GIVEN
        Order orderToAdd = new Order("1",OrderStatus.OPEN, shopService.getListOfProducts());
        Optional<Order> expected = Optional.of(orderToAdd);

        //WHEN
        shopService.addOrder(orderToAdd);
        Optional<Order> actual = shopService.getOrderById("1");

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrderById_withInvalidId_returnOptionalEmpty(){
        //GIVEN
        Order orderToAdd = new Order("1", OrderStatus.OPEN,shopService.getListOfProducts());
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
        Order orderToAdd = new Order("1", OrderStatus.OPEN,shopService.getListOfProducts());
        List<Order> expected = List.of(orderToAdd);

        //WHEN
        shopService.addOrder(orderToAdd);
        List<Order> actual = shopService.getOrders();

        //THEN
        assertEquals(expected, actual);
    }

}