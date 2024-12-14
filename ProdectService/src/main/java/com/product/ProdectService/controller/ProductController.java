package com.product.ProdectService.controller;

import java.util.List;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.ProdectService.entity.Product;
import com.product.ProdectService.service.ProductService;




@RestController
@RequestMapping("/product")
public class ProductController {

	private static Logger LOG = LogManager.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	@GetMapping("/get_All_product")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts = productService.getAllProducts();
		if(!allProducts.isEmpty()) {
			return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
		}
		else {
			LOG.info("Products Does Not Exist");
			throw new ResourceNotFoundException("Products Does Not Exist") ;
		}
	}
	
	@GetMapping("/get_by_id/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		   Product productById = productService.getProductById(id);
		if(productById!=null) {
			return new ResponseEntity<Product>(productById,HttpStatus.OK);
		}
		else {
			LOG.info("Products Does Not Exist");
			throw new ResourceNotFoundException("Products Does Not Exist") ;
		}
	}


	@PostMapping("/create_product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product createdProduct = productService.createProduct(product);
		if(createdProduct!=null) {
			return new ResponseEntity<Product>(createdProduct,HttpStatus.OK);
		}
		else {
			LOG.info("Products Does Not Exist");
			throw new ResourceNotFoundException("Products Does Not Exist") ;
		}
	}
	
	@PutMapping("update_product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		 boolean updateProduct = productService.updateProduct(id, product);
		if(updateProduct==true) {
			return new ResponseEntity<String>("updated Successfully",HttpStatus.ACCEPTED);
		}
		else {
			LOG.info("Products Does Not Exist");
			throw new ResourceNotFoundException("Products Does Not Exist") ;
		}
	}
	
	@DeleteMapping("delete_product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		  boolean deleteProduct = productService.deleteProduct(id);
		if(deleteProduct==true) {
			return new ResponseEntity<String>("Deleted Succesfully",HttpStatus.ACCEPTED);
		}
		else {
			LOG.info("Products Does Not Exist");
			throw new ResourceNotFoundException("Products Does Not Exist") ;
		}
	}
	
}
