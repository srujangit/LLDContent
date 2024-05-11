package dev.srujan.springfirstproject.services;

import dev.srujan.springfirstproject.models.Category;
import dev.srujan.springfirstproject.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id);

    Product createProduct(String title, double price, String description, String image, String category);

    List<Product> getAllProducts();

}
