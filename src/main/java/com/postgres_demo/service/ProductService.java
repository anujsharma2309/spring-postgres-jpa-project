package com.postgres_demo.service;

import com.postgres_demo.dto.ProductDto;
import com.postgres_demo.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductDto productDto);
    void deleteProduct(Long id);
    List<ProductDto> getProductByName(String name);
}
