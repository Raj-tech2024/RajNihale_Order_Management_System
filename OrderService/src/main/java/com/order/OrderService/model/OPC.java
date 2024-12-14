package com.order.OrderService.model;

public class OPC {

	private OrderServiceModel orderServiceModel;
	
	private ProductServiceModel productServiceModel;
	
	private CustomerServiceModel customerServiceModel;

	public OPC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OPC(OrderServiceModel orderServiceModel, ProductServiceModel productServiceModel,
			CustomerServiceModel customerServiceModel) {
		super();
		this.orderServiceModel = orderServiceModel;
		this.productServiceModel = productServiceModel;
		this.customerServiceModel = customerServiceModel;
	}

	public OrderServiceModel getOrderServiceModel() {
		return orderServiceModel;
	}

	public void setOrderServiceModel(OrderServiceModel orderServiceModel) {
		this.orderServiceModel = orderServiceModel;
	}

	public ProductServiceModel getProductServiceModel() {
		return productServiceModel;
	}

	public void setProductServiceModel(ProductServiceModel productServiceModel) {
		this.productServiceModel = productServiceModel;
	}

	public CustomerServiceModel getCustomerServiceModel() {
		return customerServiceModel;
	}

	public void setCustomerServiceModel(CustomerServiceModel customerServiceModel) {
		this.customerServiceModel = customerServiceModel;
	}

	@Override
	public String toString() {
		return "OPC [orderServiceModel=" + orderServiceModel + ", productServiceModel=" + productServiceModel
				+ ", customerServiceModel=" + customerServiceModel + "]";
	}
	
	
}
