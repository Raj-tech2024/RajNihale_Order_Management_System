package com.order.OrderService.controller;

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

import com.order.OrderService.entity.Orders;
import com.order.OrderService.exception.ResourceNotExistsException;
import com.order.OrderService.model.OPC;
import com.order.OrderService.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static Logger LOG = LogManager.getLogger(OrderController.class);
	@Autowired
	OrderService orderService;

	@PostMapping("/place_order")
	public ResponseEntity<Orders> placeOrder(@RequestBody Orders order) {
		Orders placeOrder = orderService.placeOrder(order);
		if (placeOrder != null) {
			LOG.info("Order Placed :" + order);
			return new ResponseEntity<Orders>(placeOrder, HttpStatus.CREATED);
		} else {
			throw new ResourceNotExistsException("Failed to order place");
		}
	}

	@PutMapping("/update_order/{orderId}")
	public ResponseEntity<Orders> updateOrder(@PathVariable Long orderId, @RequestBody Orders order) {
		Orders updateOrder = orderService.updateOrder(orderId, order);
		if (updateOrder != null) {
			LOG.info("Order Updated :" + order);
			return new ResponseEntity<Orders>(updateOrder, HttpStatus.CREATED);
		} else {
			throw new ResourceNotFoundException("Order Not Found");
		}
	}

	@DeleteMapping("/delete_order/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
		boolean cancelOrder = orderService.cancelOrder(orderId);
		if (cancelOrder == true) {
			LOG.info("Order Cancel :" + orderId);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Order Not Found");
		}
	}
	
	@GetMapping("get-Order-by-orderid-with-pc/{orderId}")
	public ResponseEntity<OPC> getProductWithPC(@PathVariable long orderId) {
		OPC productWithPC = orderService.getProductWithPC(orderId);
		return new ResponseEntity<>(productWithPC, HttpStatus.OK);
	}
	
}
