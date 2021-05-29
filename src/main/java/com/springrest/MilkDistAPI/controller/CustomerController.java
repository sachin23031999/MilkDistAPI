package com.springrest.MilkDistAPI.controller;

import java.util.List;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.responses.ResponseMsg;
import com.springrest.MilkDistAPI.servicesInterface.CustomerService;
import com.springrest.MilkDistAPI.servicesInterface.DailyDistService;
import com.springrest.MilkDistAPI.servicesInterface.DistReqService;
import com.springrest.MilkDistAPI.servicesInterface.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springrest.MilkDistAPI.entities.Customer;

import javax.validation.Valid;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private DistReqDao distReqDao;

    @Autowired
    private DistReqService distReqService;

    @Autowired
    private DailyDistService dailyDistService;

    @Autowired
    private ReportService reportService;

    //Add Customer
    @PostMapping(path = "/customers", consumes = "application/json")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer) {
        try {
            customerService.addCustomer(customer);
            //return this.customerService.getAllCustomers();
            ResponseMsg responseMsg = new ResponseMsg("Customer successfully added", "");
            return new ResponseEntity(responseMsg, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage() ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //List All Active Customer
    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers() {
        return new ResponseEntity(this.customerService.getAllActiveCustomers(), HttpStatus.OK);
    }

    //Get Customer by ID
    @GetMapping("/customers/{customer_id}")
    public Customer getCustomerByID(@PathVariable String customer_id) {
        return this.customerService.getCustomer(Long.parseLong(customer_id));
    }

    //List Archived Customer
    @GetMapping("/customers/archived")
    public List<Customer> getArchivedCustomers() {
        return customerService.listOfArchivedCustomers();
    }

    //Update Customer
    @PutMapping(path = "/customers/{customer_id}", consumes = "application/json")
    public ResponseEntity<?> updateCustomer(@PathVariable String customer_id,@Valid @RequestBody Customer customer) {
        try {
            this.customerService.updateCustomer(customer_id, customer);
            return new ResponseEntity(new ResponseMsg("Customer successfully updated", ""),
                    HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage() ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Archive Customer
    @PatchMapping("/customers/{customer_id}/archive")
    public ResponseEntity<?> archiveCustomer(@PathVariable String customer_id) {

        try {
            customerService.archiveCustomer(Long.parseLong(customer_id));
            return new ResponseEntity(new ResponseMsg("Customer Successfully Archived", ""),
                    HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage() ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Unarchive Customer
    @PatchMapping("/customers/{customer_id}/active")
    public ResponseEntity<?> unArchiveCustomer(@PathVariable String customer_id) {

        try {
            customerService.unArchiveCustomer(Long.parseLong(customer_id));
            return new ResponseEntity(new ResponseMsg("Customer successfully marked as active", ""),
                    HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage() ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}