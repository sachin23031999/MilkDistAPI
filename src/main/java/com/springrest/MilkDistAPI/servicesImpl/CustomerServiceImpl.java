package com.springrest.MilkDistAPI.servicesImpl;

import java.util.List;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.entities.Customer;
import com.springrest.MilkDistAPI.servicesInterface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    public CustomerServiceImpl() {
    }

    @Override
    public Customer getCustomer(long id) {
        return customerDao.getOne(id);
    }

    @Override
    public void updateCustomer(String customer_id, Customer customer) {
        //Customer customer1 = customerDao.getOne(Long.parseLong(customer_id));
        customer.setId(Long.parseLong(customer_id));
        //customer.setUser_id(customer1.getUser_id());
        customerDao.save(customer);
    }

    @Override
    public void unArchiveCustomer(long customer_id) {
        Customer customer = customerDao.getOne(customer_id);
        customer.setIs_archived(false);
        customerDao.save(customer);
    }

    @Override
    public void archiveCustomer(long customer_id) {
        Customer customer = customerDao.getOne(customer_id);
        customer.setIs_archived(true);
        customerDao.save(customer);
    }

    @Override
    public List<Customer> listOfArchivedCustomers() {
        return customerDao.getCustomersByIsArchive();
    }

    @Override
    public Customer deleteCustomer(long id) {
        Customer customer = customerDao.getOne(id);
        customerDao.delete(customer);
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public List<Customer> getAllActiveCustomers() {
        return customerDao.getActiveCustomers();
    }
}