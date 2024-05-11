package dev.srujan.springfirstproject.services;

import dev.srujan.springfirstproject.dtos.FakeStoreProductServiceDto;
import dev.srujan.springfirstproject.dtos.FakeStoreRequestBodyDto;
import dev.srujan.springfirstproject.models.Category;
import dev.srujan.springfirstproject.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service(value = "fakeStore")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductServiceDto FakeStoreProductResponse = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductServiceDto.class);
        assert FakeStoreProductResponse != null;
        return FakeStoreProductResponse.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        FakeStoreProductServiceDto[] fakeStoreProductServiceDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductServiceDto[].class);

        assert fakeStoreProductServiceDtos != null;
        for(FakeStoreProductServiceDto fakeStore: fakeStoreProductServiceDtos){
            products.add(fakeStore.toProduct());
        }

        return products;
    }

    @Override
    public Product createProduct(String title, double price, String description, String image, String category) {
        FakeStoreProductServiceDto fakeStoreProductServiceDto = new FakeStoreProductServiceDto();
        fakeStoreProductServiceDto.setTitle(title);
        fakeStoreProductServiceDto.setPrice(price);
        fakeStoreProductServiceDto.setDescription(description);
        fakeStoreProductServiceDto.setImage(image);
        fakeStoreProductServiceDto.setCategory(category);

        FakeStoreProductServiceDto fakeStoreProductServiceDto1 = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductServiceDto, FakeStoreProductServiceDto.class);

        assert fakeStoreProductServiceDto1 != null;
        return fakeStoreProductServiceDto1.toProduct();
    }
}
