package de.neuefische;

import java.util.ArrayList;


public class ShopService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getProductById(String id) {
        return productRepo.getProductById(id);
    }

    public ArrayList<Product> getListOfProducts() {
        return productRepo.getListOfProducts();
    }

    public void addOrder(Order orderToAdd) {
        orderRepo.addOrder(orderToAdd);
    }

    public Order getOrderById(String id){
        return (orderRepo.getOrderById(id));
    }

    public ArrayList<Order> getListOfOrders(){
        return orderRepo.getListOfOrders();
    }

}
