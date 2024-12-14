package com.product.ProdectService.Controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import com.product.ProdectService.controller.ProductController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.ProdectService.entity.Product;
import com.product.ProdectService.service.ProductService;

class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllProducts() throws Exception {
        List<Product> products = Arrays.asList(
                new Product(1L, "Product1", "Category1", 100.0, 10),
                new Product(2L, "Product2", "Category2", 200.0, 20));

        when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(get("/product/get_All_product"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Product1"));

        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testGetProductById() throws Exception {
        Product product = new Product(1L, "Product1", "Category1", 100.0, 10);
        when(productService.getProductById(1L)).thenReturn(product);

        mockMvc.perform(get("/product/get_by_id/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Product1"));

        verify(productService, times(1)).getProductById(1L);
    }

    @Test
    void testCreateProduct() throws Exception {
        Product product = new Product(1L, "Product1", "Category1", 100.0, 10);
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/product/create_product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Product1"));

        verify(productService, times(1)).createProduct(any(Product.class));
    }

    @Test
    void testUpdateProduct() throws Exception {
        Product product = new Product(1L, "UpdatedProduct", "UpdatedCategory", 150.0, 15);
        when(productService.updateProduct(eq(1L), any(Product.class))).thenReturn(true);

        mockMvc.perform(put("/product/update_product/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isAccepted())
                .andExpect(content().string("updated Successfully"));

        verify(productService, times(1)).updateProduct(eq(1L), any(Product.class));
    }

    @Test
    void testDeleteProduct() throws Exception {
        when(productService.deleteProduct(1L)).thenReturn(true);

        mockMvc.perform(delete("/product/delete_product/1"))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Deleted Succesfully"));

        verify(productService, times(1)).deleteProduct(1L);
    }
}
