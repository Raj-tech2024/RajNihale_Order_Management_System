package com.order.OrderService.model;

public class ProductServiceModel {

	private Long productId;

	private String name;

	private String category;
	
	private Double price;

	private Integer stock;

	public ProductServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductServiceModel(Long productId, String name, String category, Double price, Integer stock) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ProductServiceModel [productId=" + productId + ", name=" + name + ", category=" + category + ", price="
				+ price + ", stock=" + stock + "]";
	}
	
	
	
}
