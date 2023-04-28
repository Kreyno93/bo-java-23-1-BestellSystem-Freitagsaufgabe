package de.neuefische;

import java.sql.Array;
import java.util.*;

public class OrderRepo {

    private HashMap<String,Order> orders;

    public void addOrder(Order order) {
        orders.put(order.getId(),order);
    }

    public OrderRepo(HashMap<String,Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getListOfOrders() {
        return new ArrayList<>(orders.values());
    }

    public Optional<Order> getOrderById(String id){
        if (orders.containsKey(id)){
            return Optional.of(orders.get(id));
        } return Optional.empty();
    }

    @Override
    public String toString() {
        return "OrderRepo{" +
                "orders=" + orders +
                '}';
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
