package dev.srujan.springfirstproject.dtos;

import dev.srujan.springfirstproject.models.Category;
import dev.srujan.springfirstproject.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductServiceDto {
    private Long id;
    private String title;
    private double price;

    private String category;
    private String description;
    private String image;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        Category category1 = new Category();
        category1.setTitle(title);
        category1.setDescription(description);

        product.setCategory(category1);
        product.setDescription(description);
        product.setImageUrl(image);

        return product;
    }

}
