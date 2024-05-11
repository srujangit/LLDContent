package dev.srujan.springfirstproject.services;

import dev.srujan.springfirstproject.models.Category;
import dev.srujan.springfirstproject.models.Product;
import dev.srujan.springfirstproject.repositories.CategoryRepository;
import dev.srujan.springfirstproject.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ownProductService")
public class OwnProductService implements ProductService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    OwnProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title,
                                 double price,
                                 String description,
                                 String imageUrl,
                                 String category) {
        Product p = new Product();
        p.setTitle(title);
        p.setPrice(price);
        p.setDescription(description);
        p.setImageUrl(imageUrl);

        Category categoryFromDatabase = categoryRepository.findCategoriesByTitle(category);

        if(categoryFromDatabase ==null){
            Category category1 = new Category();
            category1.setTitle(category);

            // categoryRepository.save(category1); persistence as cascade
            categoryFromDatabase = category1;
        }
        p.setCategory(categoryFromDatabase);

        Product saveProduct = productRepository.save(p);

        return saveProduct;
    }
}
