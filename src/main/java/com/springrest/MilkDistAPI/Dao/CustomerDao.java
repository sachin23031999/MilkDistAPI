package com.springrest.MilkDistAPI.Dao;


import com.springrest.MilkDistAPI.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, String> {

}
