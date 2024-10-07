package com.postgres_demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDto {

    @JsonProperty("Id")
    private Long id;

    @JsonProperty("ProductName")
    private String name;

    @JsonProperty("ProductPrice")
    private double price;
}
