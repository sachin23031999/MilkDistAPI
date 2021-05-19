package com.springrest.MilkDistAPI.services;

import java.util.ArrayList;
import java.util.List;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    public CustomerServiceImpl() {
    }

    @Override
    public Customer getCustomer(String id) {
        return customerDao.getOne(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customerDao.save(customer);
        return customer;
    }

    @Override
    public Customer deleteCustomer(String id) {
        Customer customer = customerDao.getOne(id);
        customerDao.delete(customer);
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
            customerDao.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        return customerDao.findAll();
    }

}
