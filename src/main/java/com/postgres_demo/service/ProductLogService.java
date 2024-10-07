package com.postgres_demo.service;

import com.postgres_demo.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductLog")
public class ProductLogService implements ProductService{
    /**
     * @return
     */
    @Override
    public List<ProductDto> getAllProducts() {
        return List.of();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    /**
     * @param productDto
     * @return
     */
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return null;
    }

    /**
     * @param id
     * @param productDto
     * @return
     */
    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteProduct(Long id) {

    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<ProductDto> getProductByName(String name) {
        return List.of();
    }
}
