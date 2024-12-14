package com.order.OrderService.model;

public class CustomerServiceModel {

	private Long id;
	
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String number;

	public CustomerServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerServiceModel(Long id, String firstname, String lastname, String email, String number) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "CustomerServiceModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", number=" + number + "]";
	}

	
}
