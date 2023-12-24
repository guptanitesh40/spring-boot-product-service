package com.nitesh.productservice.services;

import com.nitesh.productservice.dtos.FakeStoreProductDto;
import com.nitesh.productservice.models.Category;
import com.nitesh.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;

    @Autowired
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        return convertFakeStoreProductDtoToProduct(productDto);
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto) {
        if (productDto == null) return null;
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setImageUrl(productDto.getImage());
        return product;
    }

    @Override
    public Product addNewProduct(FakeStoreProductDto fakeProduct) {
        if (fakeProduct == null) return null;
        FakeStoreProductDto productDto = restTemplate.postForObject("https://fakestoreapi.com/products", fakeProduct, FakeStoreProductDto.class);
        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProducts = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        if (fakeStoreProducts == null) return products;
        for (FakeStoreProductDto productDto : fakeStoreProducts) {
            products.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return products;
    }

    @Override
    public Product updateProduct(Long id, FakeStoreProductDto product) {
        System.out.println("https://fakestoreapi.com/products/" + id + " " + product.toString());
        FakeStoreProductDto fakeStoreProduct = restTemplate.patchForObject("https://fakestoreapi.com/products/7" + id, product, FakeStoreProductDto.class);
        return convertFakeStoreProductDtoToProduct(fakeStoreProduct);
    }

    @Override
    public Product replaceProduct(Long id, FakeStoreProductDto product) {
        restTemplate.put("https://fakestoreapi.com/products/" + id, product);
        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return convertFakeStoreProductDtoToProduct(fakeStoreProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }

    @Override
    public List<Product> getAllCategoryProducts(String category) {
        FakeStoreProductDto[] fakeStoreProducts = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category, FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        if (fakeStoreProducts == null) return products;
        for (FakeStoreProductDto productDto : fakeStoreProducts) {
            products.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return products;
    }

}
