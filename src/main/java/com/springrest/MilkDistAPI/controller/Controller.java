package com.springrest.MilkDistAPI.controller;

import java.util.List;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.DailyDist;
import com.springrest.MilkDistAPI.entities.DistReq;
import com.springrest.MilkDistAPI.responses.ResponseMsg;
import com.springrest.MilkDistAPI.services.CustomerService;
import com.springrest.MilkDistAPI.services.DailyDistService;
import com.springrest.MilkDistAPI.services.DistReqService;
import com.springrest.MilkDistAPI.services.ReportService;
import com.springrest.MilkDistAPI.utils.CowBuffalo;
import com.springrest.MilkDistAPI.utils.TotalEarningCustomer;
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

    @Autowired
    private DailyDistService dailyDistService;

    @Autowired
    private ReportService reportService;

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
    @PutMapping(path = "/customers/{customer_id}", consumes = "application/json")
    public ResponseEntity<?> updateCustomer(@PathVariable String customer_id, @RequestBody Customer customer) {
        try {
            this.customerService.updateCustomer(customer_id, customer);
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

    //List Archived Customer
    @GetMapping("/customers/archived")
    public List<Customer> getArchivedCustomers() {
        return customerService.listOfArchivedCustomers();
    }

    //Update Delivery Date and Quantity
    @PatchMapping("/customers/{customer_id}/milk/{dailyDist_id}")
    public ResponseEntity<?> updateDateAndQuantity
        (@PathVariable String customer_id, @PathVariable String dailyDist_id, @RequestBody DailyDist dailyDist) {

        try {
            dailyDistService.updateDateAndQuantity(customer_id, dailyDist_id, dailyDist);
            return new ResponseEntity(new ResponseMsg("Date and Quantity successfully updated", ""),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Report Cow vs Buffalo
    @GetMapping("/reports/cow-vs-buffalo/{start_date}/{end_date}")
    public List<CowBuffalo> reportCowBuffalo(@PathVariable String start_date, @PathVariable String end_date) {
        List<CowBuffalo> result = reportService.reportCowVsBuffalo(start_date, end_date);
        return result;
    }

    //Total Earning
    @GetMapping("/reports/total-earning/{start_date}/{end_date}")
    public List<TotalEarningCustomer> totalEarning(@PathVariable String start_date, @PathVariable String end_date) {
        return reportService.reportTotalEarning(start_date, end_date);
    }


//	@GetMapping("customers/milk/{customer_id}")
//	public List<DistReq> getDistByCustomerID(@PathVariable String customer_id) {
//		return distReqDao.getAlldistByCustomerID(Long.parseLong(customer_id));
//	}

    //List milk distribution required
    @GetMapping("/milk")
    public List<DistReq> getAllDist() {
        return this.distReqService.getAllDist();
    }

    //Get Customer by ID
    @GetMapping("/customers/{customer_id}")
    public Customer getCustomerByID(@PathVariable String customer_id) {
        return this.customerService.getCustomer(Long.parseLong(customer_id));
    }

//    //Delete Customer by ID
//    @DeleteMapping("/customers/{customer_id}")
//    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String customer_id) {
//        try {
//            this.customerService.deleteCustomer(Long.parseLong(customer_id));
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
