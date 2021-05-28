package com.springrest.MilkDistAPI.services;

import java.util.List;

import com.springrest.MilkDistAPI.entities.Customer;

public interface CustomerService {


    public List<Customer> getAllCustomers();

    public void addCustomer(Customer customer);

    public void updateCustomer(String customer_id, Customer customer);

    public Customer getCustomer(long id);

    void archiveCustomer(long customer_id);

    List<Customer> listOfArchivedCustomers();

    public Customer deleteCustomer(long id);

    public List<Customer> getAllActiveCustomers();

    void unArchiveCustomer(long customer_id);
}
