package de.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopService {


    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Optional<Product> getProductById(String id) {
        return productRepo.getProductById(id);
    }

    public List<Product> getListOfProducts() {
        return productRepo.getListOfProducts();
    }

    public void addOrder(Order orderToAdd) {
        orderRepo.addOrder(orderToAdd);
    }

    public Optional<Order> getOrderById(String id){
        return (orderRepo.getOrderById(id));
    }

    public List<Order> getOrders(){
        return orderRepo.getListOfOrders();
    }

}
