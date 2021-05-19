package com.springrest.MilkDistAPI.controller;

import java.util.List;

import com.springrest.MilkDistAPI.services.CustomerService;
import com.springrest.MilkDistAPI.services.CustomerServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springrest.MilkDistAPI.entities.Customer;

@RestController
public class MyController {


		@Autowired
        private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
	}
	@PostMapping(path = "/customers", consumes = "application/json")
	public List<Customer> addCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
		return this.customerService.getAllCustomers();
	}

	@PutMapping(path = "/customers", consumes = "application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/customers/{customer_id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String customer_id) {
		try {
			this.customerService.deleteCustomer(Long.parseLong(customer_id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
