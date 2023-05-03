package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;


import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    OrderRepo orderRepo = new OrderRepo(new HashMap<>());

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
        Order expected = new Order("1",OrderStatus.OPEN, new ArrayList<>());

        //WHEN
        Order orderToAdd = new Order("1",OrderStatus.OPEN, new ArrayList<>());
        orderRepo.addOrder(orderToAdd);
        Order actual = orderRepo.getOrderById("1");

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrderById_ValidId_returnsCorrectOrder() {
        //GIVEN
        Order expected = new Order("1",OrderStatus.OPEN, new ArrayList<>());

        //WHEN
        Order orderToAdd = new Order("1",OrderStatus.OPEN, new ArrayList<>());
        orderRepo.addOrder(orderToAdd);
        Order actual = orderRepo.getOrderById("1");

        //THEN
        assertEquals(expected, actual);
    }
}