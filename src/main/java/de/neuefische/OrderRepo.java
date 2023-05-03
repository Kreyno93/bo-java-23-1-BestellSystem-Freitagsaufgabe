package de.neuefische;

import java.util.*;

public class OrderRepo {

    private HashMap<String,Order> orders;

    public void addOrder(Order order) {
        orders.put(order.getId(),order);
    }

    public OrderRepo(HashMap<String,Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderRepo{" +
                "orders=" + orders +
                '}';
    }

    public ArrayList<Order> getListOfOrders() {
        return new ArrayList<>(orders.values());
    }

    public Order getOrderById(String id){
        return orders.get(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepo orderRepo = (OrderRepo) o;
        return Objects.equals(orders, orderRepo.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }

}
