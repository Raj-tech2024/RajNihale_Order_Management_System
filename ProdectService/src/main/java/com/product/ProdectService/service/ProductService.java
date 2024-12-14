package com.product.ProdectService.service;

import java.util.List;

import com.product.ProdectService.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(long id);

	Product createProduct(Product product);

	boolean updateProduct(Long id, Product product);

	boolean deleteProduct(Long id);

}
