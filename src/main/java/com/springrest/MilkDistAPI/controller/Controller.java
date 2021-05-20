package com.springrest.MilkDistAPI.controller;

import java.util.List;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.DistReq;
import com.springrest.MilkDistAPI.services.CustomerService;
import com.springrest.MilkDistAPI.services.CustomerServiceImpl;
import com.springrest.MilkDistAPI.services.DistReqService;
import com.springrest.MilkDistAPI.services.DistReqServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springrest.MilkDistAPI.entities.Customer;

@RestController
public class Controller {


		@Autowired
        private CustomerService customerService;

		@Autowired
		private CustomerDao customerDao;

		@Autowired
		private DistReqDao distReqDao;

		@Autowired
		private DistReqService distReqService;

	//Add Customer
	@PostMapping(path = "/customers", consumes = "application/json")
	public List<Customer> addCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
		return this.customerService.getAllCustomers();
	}

	//List Customer
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
	}

	//Update Customer
	@PutMapping(path = "/customers", consumes = "application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return this.customerService.updateCustomer(customer);
	}
	//Add Milk Distribution
	@PostMapping(path = "customers/{customer_id}/milk", consumes = "application/json")
	public void addDistByCustomerID(@PathVariable String customer_id ,@RequestBody DistReq distReq) {
		distReqService.addDistByCustomerID(customer_id, distReq);
		//return distReq;
	}

	//Update Milk Distribution
	@PutMapping(path = "customers/{customer_id}/milk/{dist_id}")
	public DistReq updateDistByDistID(@PathVariable String customer_id, @PathVariable String dist_id, @RequestBody DistReq distReq) {
			distReqService.updateDistByID(customer_id, dist_id, distReq);
			return distReq;
	}

//	@GetMapping("customers/milk/{customer_id}")
//	public List<DistReq> getDistByCustomerID(@PathVariable String customer_id) {
//		return distReqDao.getAlldistByCustomerID(Long.parseLong(customer_id));
//	}

	@GetMapping("/milk")
	public List<DistReq> getAllDist() {
		return this.distReqService.getAllDist();
	}



	@GetMapping("/customers/{customer_id}")
	public Customer getCustomerByID(@PathVariable String customer_id) {
		return this.customerService.getCustomer(Long.parseLong(customer_id));
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
