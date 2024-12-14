package com.customer.CustomerService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.CustomerService.dao.CustomerRepository;
import com.customer.CustomerService.entity.Customer;
import com.customer.CustomerService.service.CustomerService;
import com.customer.exception.ResourceAlreadyExistException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public boolean createCustomer(Customer customer) {
	try {
//		if (customerRepository.existsById(customer.getId())) {
//	
//			throw new ResourceAlreadyExistException("Employee Already Exist");
//		}
		customerRepository.save(customer);
		return true;
	
	}
	catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}

	
	@Override
	public boolean updateCustomer(Long id, Customer customer) {
		try{
			Customer byId = customerRepository.getById(id);
		
		if (byId != null) {
			if(customer.getFirstname()!=null) {
				byId.setFirstname(customer.getFirstname());
			}
			if(customer.getLastname()!=null) {
				byId.setLastname(customer.getLastname());
			}
			if(customer.getEmail()!=null) {
				byId.setEmail(customer.getEmail());
			}
			if(customer.getNumber()!=null) {
				byId.setNumber(customer.getNumber());
			}

			customerRepository.save(byId);
			return true;
		}
		else {
			return false;
		}
		}
		catch (Exception e) {
			 e.printStackTrace();
			 return false;
		}
	}

	@Override
	public Customer getCustomerById(Long id) {
	try{
		return	customerRepository.findById(id).orElse(null);
	}
	catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}

	@Override
	public List<Customer> getAllCustomer() {
		try {
			return customerRepository.findAll(); // Fetch all employees
		}
		catch (Exception e) {
			e.printStackTrace();  // Log the exception
			return null; // Return null or an empty list if needed
		}

	}

}
