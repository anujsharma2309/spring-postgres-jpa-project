package com.postgres_demo.controller;

import com.postgres_demo.dto.ProductDto;
import com.postgres_demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private ProductDto productDto;

    @BeforeEach
    public void setup() {
        productDto = new ProductDto();
        productDto.setId(10L);
        productDto.setName("Car");
        productDto.setPrice(100.99);
    }

    @Test
    public void testGetAllProduct() throws Exception {
        List<ProductDto> productDTOs = Arrays.asList(productDto);
        when(productService.getAllProducts()).thenReturn(productDTOs);

        mockMvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].Id").value(productDto.getId()));

        //verify(productService, calls(1)).getAllProducts();
    }
}
