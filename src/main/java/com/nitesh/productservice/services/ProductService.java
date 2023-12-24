package com.nitesh.productservice.services;

import com.nitesh.productservice.dtos.FakeStoreProductDto;
import com.nitesh.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    Product addNewProduct(FakeStoreProductDto fakeProduct);
    List<Product> getAllProducts();
    List<Product> getAllCategoryProducts(String category);

    Product updateProduct(Long id, FakeStoreProductDto product);

    Product replaceProduct(Long id, FakeStoreProductDto product);

    void deleteProduct(Long id);
}
