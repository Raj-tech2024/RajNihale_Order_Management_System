package com.product.ProdectService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ProdectService.dao.ProductRepository;
import com.product.ProdectService.entity.Product;
import com.product.ProdectService.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		try{
			return productRepository.findAll();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product getProductById(long id) {
		try {
			return productRepository.findById(id).orElse(null);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product createProduct(Product product) {
		try {
			return productRepository.save(product);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateProduct(Long id, Product product) {
		try{
			Product byId = productRepository.getById(id);
			if(product.getName()!=null) {
				byId.setName(product.getName());
			}
			if(product.getPrice()!=null) {
				byId.setPrice(product.getPrice());
			}
			if(product.getStock()!=null) {
				byId.setStock(product.getStock());
			}
			 productRepository.save(byId);
			 return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(Long id) {
		boolean	deleted=false;
		try {
			Product byId = productRepository.getById(id);
			if(byId!=null) {
				productRepository.delete(byId);
				deleted=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}
}
