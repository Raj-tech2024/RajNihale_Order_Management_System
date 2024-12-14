package com.order.OrderService.service;

import com.order.OrderService.entity.Orders;
import com.order.OrderService.model.OPC;

public interface OrderService {

	Orders placeOrder(Orders order);

	Orders updateOrder(Long orderId, Orders order);

	boolean cancelOrder(Long orderId);

	OPC getProductWithPC(long orderId);

}
