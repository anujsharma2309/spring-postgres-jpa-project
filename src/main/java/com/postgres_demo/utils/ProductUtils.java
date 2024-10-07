package com.postgres_demo.utils;

import com.postgres_demo.dto.ProductDto;
import com.postgres_demo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductUtils {

    // Helper methods to convert between DTO and Entity
    public static ProductDto convertToDTO(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }

    // Helper methods to convert between DTO and Entity
    public static Product convertToEntity(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return product;
    }

    public static Product updateProduct(Product existingProduct, ProductDto productDto) {
        existingProduct.setName(productDto.getName());
        existingProduct.setPrice(productDto.getPrice());
        return existingProduct;
    }

    public static List<ProductDto> convertToDTOList(List<Product> products) {
        List<ProductDto> productDTOs = new ArrayList<>();
        products.forEach(pro -> {
            productDTOs.add(convertToDTO(pro));
        });
        return productDTOs;
    }
}
