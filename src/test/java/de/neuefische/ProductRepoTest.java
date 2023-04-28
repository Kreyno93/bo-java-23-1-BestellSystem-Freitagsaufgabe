package de.neuefische;

import org.junit.jupiter.api.Test;

import javax.lang.model.element.ModuleElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    ProductRepo productRepo = new ProductRepo();

    @Test
    void getListOfProducts_returnsListOfProducts() {
        //GIVEN
        List<Product> expected = new ArrayList<>(List.of(
                new Product("1", "Bread"),
                new Product("2", "Butter"),
                new Product("3", "Milk"),
                new Product("4", "Cheese"),
                new Product("5", "Eggs")
        ));

        //WHEN
        List<Product> actual = productRepo.getListOfProducts();

        //THEN
        assertEquals(expected, actual);
    }

    @Test

    void getProductById_ValidId_returnsProduct() {
        //GIVEN
        Optional<Product> expected = Optional.of(new Product("1", "Bread"));

        //WHEN
        Optional<Product> actual = productRepo.getProductById("1");

        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getProductById_InvalidId_returnsEmptyOptional() {
        //GIVEN
        Optional<Product> expected = Optional.empty();

        //WHEN
        Optional<Product> actual = productRepo.getProductById("6");

        //THEN
        assertEquals(expected, actual);
    }



}