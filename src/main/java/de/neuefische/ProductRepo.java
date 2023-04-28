package de.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductRepo {

    private final List<Product> products = new ArrayList<>(List.of(
            new Product("1", "Bread"),
            new Product("2", "Butter"),
            new Product("3", "Milk"),
            new Product("4", "Cheese"),
            new Product("5", "Eggs")
    ));

    public ProductRepo() {
    }

    public List<Product> getListOfProducts() {
        return products;
    }

    public Optional<Product> getProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
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
