package de.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderRepo {

    private ArrayList<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }

    public OrderRepo(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getListOfOrders() {
        return orders;
    }

    public Optional<Order> getOrderById(String number) {
        for (Order order : orders) {
            if (order.getId().equals(number)) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
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
