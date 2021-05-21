package com.springrest.MilkDistAPI.services;

import java.util.List;

import com.springrest.MilkDistAPI.entities.Customer;

public interface CustomerService {


	public List<Customer> getAllCustomers();
	public void addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer getCustomer(long id);

	void archiveCustomer(long customer_id);

	public Customer deleteCustomer(long id);

	void unArchiveCustomer(long customer_id);
}
