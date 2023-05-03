package de.neuefische;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ShopService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;


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
