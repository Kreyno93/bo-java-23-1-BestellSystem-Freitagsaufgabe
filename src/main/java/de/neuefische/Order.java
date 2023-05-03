package de.neuefische;

import java.util.ArrayList;

import java.util.Objects;
import java.util.Optional;

public class Order {

    private String id;
    private OrderStatus orderStatus;
    private ArrayList<Product> products;

    public Order(String id, OrderStatus orderStatus, ArrayList<Product> products) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && orderStatus == order.orderStatus && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderStatus, products);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderStatus=" + orderStatus +
                ", products=" + products +
                '}';
    }
}
