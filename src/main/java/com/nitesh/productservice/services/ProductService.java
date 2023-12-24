package com.nitesh.productservice.services;

import com.nitesh.productservice.dtos.FakeStoreProductDto;
import com.nitesh.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    Product addNewProduct(FakeStoreProductDto fakeProduct);
    List<Product> getAllProducts();
}
