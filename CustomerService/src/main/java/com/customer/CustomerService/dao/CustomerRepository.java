package com.customer.CustomerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.CustomerService.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
