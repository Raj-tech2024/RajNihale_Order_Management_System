package com.order.OrderService.serviceImpl;

import java.time.LocalDateTime;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.order.OrderService.dao.OrderRepository;
import com.order.OrderService.entity.Orders;
import com.order.OrderService.model.CustomerServiceModel;
import com.order.OrderService.model.OPC;
import com.order.OrderService.model.OrderServiceModel;
import com.order.OrderService.model.ProductServiceModel;
import com.order.OrderService.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Orders placeOrder(Orders order) {
		try {
			order.setOrderDate(LocalDateTime.now());
			order.setStatus("PLACED");
			return orderRepository.save(order);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Orders updateOrder(Long orderId, Orders newOrder) {
		try {
			Orders oldOrder = orderRepository.getById(orderId);
			if (oldOrder == null) {
				throw new ResourceNotFoundException("Order Not Found");
			} else {

				newOrder.setStatus(oldOrder.getStatus());
				newOrder.setOrderDate(LocalDateTime.now());
				return orderRepository.save(newOrder);
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("Update Failed");
		}
	}

	@Override
	public boolean cancelOrder(Long orderId) {
		boolean cancel = false;
		try {
			Orders placedOrder = orderRepository.getById(orderId);
			if (placedOrder == null) {
				throw new ResourceNotFoundException("Order Does Not Exist");
			} else {

				orderRepository.delete(placedOrder);
				cancel = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cancel;
	}

	@Override
	public OPC getProductWithPC(long orderId) {
		OPC opc=new OPC();
		Orders OrderEntity = orderRepository.getById(orderId);
		CustomerServiceModel customerServiceModel=null;
		ProductServiceModel productServiceModel=null;
		
		if(OrderEntity!=null) {
			OrderServiceModel orderServiceModel=mapper.map(OrderEntity, OrderServiceModel.class);
			opc.setOrderServiceModel(orderServiceModel);
			
			try {
				customerServiceModel = restTemplate.getForObject("http://CUSTOMER-SERVICE/customer/get_by_id/"+OrderEntity.getCustomer() , CustomerServiceModel.class);
				opc.setCustomerServiceModel(customerServiceModel);
			}
			catch (ResourceAccessException e) {
				opc.setCustomerServiceModel(null);
			}
			
			try {
				productServiceModel =restTemplate.getForObject("http://PRODUCT-SERVICE/product/get_by_id/"+OrderEntity.getProduct(), ProductServiceModel.class);
				opc.setProductServiceModel(productServiceModel);
			}
			catch (ResourceAccessException e) {
				opc.setProductServiceModel(null);
			}
		}
		return opc;
	}

}
