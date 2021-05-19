package com.springrest.MilkDistAPI.services;

import java.util.List;

import com.springrest.MilkDistAPI.entities.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	public void addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer getCustomer(String id);
	public Customer deleteCustomer(String id);
}
