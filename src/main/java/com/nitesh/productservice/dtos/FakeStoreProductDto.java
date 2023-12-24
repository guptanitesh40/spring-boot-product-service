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

    @Override
    public String toString() {
        return "FakeStoreProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
