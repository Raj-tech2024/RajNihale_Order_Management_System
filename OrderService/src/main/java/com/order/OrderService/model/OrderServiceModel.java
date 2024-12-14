package com.order.OrderService.model;

import java.time.LocalDateTime;

public class OrderServiceModel {

	private Long id;
	
	private long customerId;
	
	private long productId;
	
	private LocalDateTime orderDate;
	
	private String status;
	
	private Double totalAmount;

	public OrderServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderServiceModel(Long id, long customerId, long productId, LocalDateTime orderDate, String status,
			Double totalAmount) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.productId = productId;
		this.orderDate = orderDate;
		this.status = status;
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "OrderServiceModel [id=" + id + ", customerId=" + customerId + ", productId=" + productId
				+ ", orderDate=" + orderDate + ", status=" + status + ", totalAmount=" + totalAmount + "]";
	}

	
}
