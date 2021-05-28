package com.springrest.MilkDistAPI.Dao;


import com.springrest.MilkDistAPI.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM customers WHERE is_archived = true", nativeQuery = true)
    public List<Customer> getCustomersByIsArchive();

    @Query(value = "SELECT * FROM customers WHERE is_archived = false", nativeQuery = true)
    public List<Customer> getActiveCustomers();
}
