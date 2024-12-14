package com.customer.CustomerService.service;

import java.util.List;

import com.customer.CustomerService.entity.Customer;

public interface CustomerService {

	boolean createCustomer(Customer customer);

	boolean updateCustomer(Long id, Customer customer);

	Customer getCustomerById(Long id);

	List<Customer> getAllCustomer();

}
