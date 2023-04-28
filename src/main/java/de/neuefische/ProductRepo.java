package de.neuefische;

import java.lang.reflect.Array;
import java.util.*;

public class ProductRepo {

    private final HashMap<String,Product> products = new HashMap<>(Map.of(
            "1",new Product("1","Brot"),
            "2",new Product("2","Milch"),
            "3",new Product("3","Eier"),
            "4",new Product("4","Käse"),
            "5",new Product("5","Wurst")
    ));

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }

    public ProductRepo() {
    }

    public ArrayList<Product> getListOfProducts() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> getProductById(String id){
        if (products.containsKey(id)){
            return Optional.of(products.get(id));
        } return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}
