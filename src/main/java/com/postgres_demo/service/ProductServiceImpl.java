package com.postgres_demo.service;

import com.postgres_demo.dto.ProductDto;
import com.postgres_demo.model.Product;
import com.postgres_demo.repository.ProductRepository;
import com.postgres_demo.utils.ProductUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    /**
     *
     * @return
     */
    public List<ProductDto> getAllProducts() {
        logger.info("Fetching all products");
        return productRepository.findAll().stream()
                .map(ProductUtils::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ProductDto getProductById(Long id) {
        logger.info("Fetching product with id : {}", id);
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id : " + id));
        return ProductUtils.convertToDTO(product);
    }

    /**
     * @param productDto
     * @return
     */
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        logger.info("Saving the new Product");
        Product product = productRepository.save(ProductUtils.convertToEntity(productDto));
        logger.info("Product with id : {} saved", product.getId());
        return ProductUtils.convertToDTO(product);
    }

    /**
     * @param id
     * @param productDto
     * @return
     */
    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        logger.info("Updating the Product with id : {}", id);
        Product existingProduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id : " + id));
        Product updatedProduct = productRepository.save(ProductUtils.updateProduct(existingProduct, productDto));
        logger.info("Product with id : {} updated", updatedProduct.getId());
        return ProductUtils.convertToDTO(updatedProduct);
    }

    /**
     * @param id
     */
    @Override
    public void deleteProduct(Long id) {
        logger.info("Deleting the Product with id : {}", id);
        Product existingProduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id : " + id));
        productRepository.delete(existingProduct);
        logger.info("Product with id : {} deleted", id);
    }

    /**
     * @param name
     */
    @Override
    public List<ProductDto> getProductByName(String name) {
        if (name.isEmpty()) {
            return Collections.emptyList();
        }
        List<Product> products = productRepository.findByName(name);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No data found for the name: " + name);
        }
        return ProductUtils.convertToDTOList(products);
    }
}
