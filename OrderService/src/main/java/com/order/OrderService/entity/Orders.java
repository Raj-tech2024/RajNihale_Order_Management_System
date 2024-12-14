package com.order.OrderService.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Orders {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Min(value = 1, message = "Invalid Order Id")
	private Long id;
	
	//@Min(value = 1, message = "Invalid Category Id")
	private long customer;
	
	private long product;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime orderDate;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private Double totalAmount;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(@Min(value = 1, message = "Invalid Order Id") Long id, long customer, long product,
			LocalDateTime orderDate, String status, Double totalAmount) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
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

	public long getCustomer() {
		return customer;
	}

	public void setCustomer(long customer) {
		this.customer = customer;
	}

	public long getProduct() {
		return product;
	}

	public void setProduct(long product) {
		this.product = product;
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
		return "Orders [id=" + id + ", customer=" + customer + ", product=" + product + ", orderDate=" + orderDate
				+ ", status=" + status + ", totalAmount=" + totalAmount + "]";
	}

			
}
