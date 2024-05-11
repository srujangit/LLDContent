package dev.srujan.springfirstproject.repositories;

import dev.srujan.springfirstproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product Save(Product product);
}
