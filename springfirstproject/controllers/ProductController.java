package dev.srujan.springfirstproject.controllers;

import dev.srujan.springfirstproject.dtos.FakeStoreProductServiceDto;
import dev.srujan.springfirstproject.dtos.FakeStoreRequestBodyDto;
import dev.srujan.springfirstproject.models.Product;
import dev.srujan.springfirstproject.services.FakeStoreProductService;
import dev.srujan.springfirstproject.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

//    ProductService productService = new FakeStoreProductService();
    /*
     instead of creating an object of FakeStoreProductService here, we should do dependency injection here, so commenting the above
     */

    ProductService productService;

    ProductController(@Qualifier("ownProductService") ProductService productService){
        this.productService = productService;
    }
    /*
      there is no instance of controller to pass the fakestore product service, so we have to add a Qualifier and we should use @service in FakeStoreProductService
     */

    /*
        POST/products
        Request body{
            id,
            title,
            name,
            description,
            price,
            imageUrl
            }
     */
    @PostMapping("/products")
    public Product createProduct(@RequestBody FakeStoreRequestBodyDto request){

        return productService.createProduct(request.getTitle(), request.getPrice(),
                request.getDescription(), request.getImage(), request.getCategory());

    }

    /*
        getproduct will return
        id,
        title,
        name,
        price,
        description
     */

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
//        return new Product();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/products")
    public void updateProduct(){

    }


}
