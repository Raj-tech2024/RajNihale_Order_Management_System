package com.order.OrderService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.OrderService.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{

}
