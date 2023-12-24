package com.nitesh.productservice.dtos;

import lombok.Getter;

@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private Float price;
    private String category;
    private String image;
}
