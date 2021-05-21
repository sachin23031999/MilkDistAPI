package com.springrest.MilkDistAPI.controller;

import java.util.List;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.DistReq;
import com.springrest.MilkDistAPI.responses.ResponseMsg;
import com.springrest.MilkDistAPI.services.CustomerService;
import com.springrest.MilkDistAPI.services.CustomerServiceImpl;
import com.springrest.MilkDistAPI.services.DistReqService;
import com.springrest.MilkDistAPI.services.DistReqServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        try {
            customerService.addCustomer(customer);
            //return this.customerService.getAllCustomers();
            ResponseMsg responseMsg = new ResponseMsg("Customer successfully added", "");
            return new ResponseEntity(responseMsg, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //List Customer
    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers() {
        return new ResponseEntity(this.customerService.getAllCustomers(), HttpStatus.OK);
    }

    //Update Customer
    @PutMapping(path = "/customers", consumes = "application/json")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        try {
            this.customerService.updateCustomer(customer);
            return new ResponseEntity(new ResponseMsg("Customer successfully updated", ""),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Add Milk Distribution
    @PostMapping(path = "customers/{customer_id}/milk", consumes = "application/json")
    public ResponseEntity<?> addDistByCustomerID(@PathVariable String customer_id, @RequestBody DistReq distReq) {
        try {
            distReqService.addDistByCustomerID(customer_id, distReq);
            return new ResponseEntity(new ResponseMsg("Milk Details Successfully added", ""),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update Milk Distribution
    @PutMapping("customers/{customer_id}/milk/{dist_id}")
    public ResponseEntity<?> updateDistByDistID(@PathVariable String customer_id, @PathVariable String dist_id, @RequestBody DistReq distReq) {

        try {
            distReqService.updateDistByID(customer_id, dist_id, distReq);
            return new ResponseEntity(new ResponseMsg("Milk Details Successfully updated", ""),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getMessage()),
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
        } catch (Exception e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getMessage()),
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
        } catch (Exception e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Total Earning
    @GetMapping("/reports/total-earning/{start_date}/{end_date}")
    public ResponseEntity<?> totalEarning(@PathVariable String start_date, @PathVariable String end_date) {
        return null;
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
