package com.customer.CustomerService.controller;

import java.util.List;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.CustomerService.entity.Customer;
import com.customer.CustomerService.service.CustomerService;
import com.customer.exception.ResourceAlreadyExistException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static Logger LOG = LogManager.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	@PostMapping("/create_customer")
	public ResponseEntity<Boolean> createCustomer(@RequestBody Customer customer) {
		boolean isCreated = customerService.createCustomer(customer);
		if (isCreated == true) {
			return new ResponseEntity<Boolean>(isCreated, HttpStatus.CREATED);
		} else {
			LOG.info("User Already Exixts With >ID:" + customer.getId());
			throw new ResourceAlreadyExistException("Customer Already Exist");
		}
	}

	@PutMapping("update_customer/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		boolean updateCustomer = customerService.updateCustomer(id, customer);
		if (updateCustomer == true) {
			return new ResponseEntity<String>("Customer Update Sucessfull", HttpStatus.CREATED);	
		}
		else {
			LOG.info("User Not Found For Update >ID: " + customer.getId());
			throw new ResourceNotFoundException("Customer Does Not Exist");
		}
	}
	
	@GetMapping("get_by_id/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customerById = customerService.getCustomerById(id);
		if(customerById!=null) {
			return new ResponseEntity<Customer>(customerById,HttpStatus.OK);
		}
		else {
			LOG.info("User Not Found For Update >ID: " + customerById.getId());
			throw new ResourceNotFoundException("Customer Does Not Exist");
		}
	}
	
	@GetMapping("get_All_Customer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> allCustomer = customerService.getAllCustomer();
		if(allCustomer.isEmpty()) {
			LOG.info("User Not Found For Update >ID: ");
			throw new ResourceNotFoundException("Customers Does Not Exist");
		}
		else {
			return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.OK);
		}
	}
	
	

}
