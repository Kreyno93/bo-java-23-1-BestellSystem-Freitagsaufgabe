package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    OrderRepo orderRepo = new OrderRepo(new ArrayList<>());

    @Test
    void getListOfOrders() {
        //GIVEN
        ArrayList<Order> expected = new ArrayList<>();

        //WHEN
        ArrayList<Order> actual = orderRepo.getListOfOrders();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void addOrder() {
        //GIVEN
        Optional expected = Optional.of(new Order("1",OrderStatus.OPEN, new ArrayList<>()));

        //WHEN
        Order orderToAdd = new Order("1",OrderStatus.OPEN, new ArrayList<>());
        orderRepo.addOrder(orderToAdd);
        Optional<Order> actual = orderRepo.getOrderById("1");

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrderById_ValidId_returnsCorrectOrder() {
        //GIVEN
        Optional<Order> expected = Optional.of(new Order("1",OrderStatus.OPEN, new ArrayList<>()));

        //WHEN
        Order orderToAdd = new Order("1",OrderStatus.OPEN, new ArrayList<>());
        orderRepo.addOrder(orderToAdd);
        Optional<Order> actual = orderRepo.getOrderById("1");

        //THEN
        assertEquals(expected, actual);
    }
    @Test
    void getOrderById_InvalidId_returnsOptionalEmpty(){
        //GIVEN
        Optional<Order> expected = Optional.empty();

        //WHEN
        Order orderToAdd = new Order("1",OrderStatus.OPEN, new ArrayList<>());
        orderRepo.addOrder(orderToAdd);
        Optional<Order> actual = orderRepo.getOrderById("2");

        //THEN
        assertEquals(expected, actual);
    }
}