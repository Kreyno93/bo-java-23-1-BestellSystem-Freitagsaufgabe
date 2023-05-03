package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    ProductRepo productRepo = new ProductRepo();

    @Test
    void getListOfProducts_returnsListOfProducts() {
        //GIVEN
        ArrayList<Product> expected = new ArrayList<>(List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch"),
                new Product("3", "Eier"),
                new Product("4", "Käse"),
                new Product("5", "Wurst")
        ));

        //WHEN
        ArrayList<Product> actual = productRepo.getListOfProducts();

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getProductById_ValidId_returnsProduct() {
        //GIVEN
        Product expected = new Product("1", "Brot");

        //WHEN
        Product actual = productRepo.getProductById("1");

        //THEN
        assertEquals(expected, actual);
    }



}