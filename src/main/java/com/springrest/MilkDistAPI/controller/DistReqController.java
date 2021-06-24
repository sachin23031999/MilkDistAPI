package com.springrest.MilkDistAPI.controller;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.DistReq;
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

import javax.validation.Valid;
import java.util.List;

@RestController
public class DistReqController {
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

    //Add milk details
    @PostMapping(path = "customers/{customer_id}/milk", consumes = "application/json")
    public ResponseEntity<?> addDistByCustomerID(@PathVariable String customer_id,@Valid @RequestBody DistReq distReq) {
        try {
            distReqService.addDistByCustomerID(customer_id, distReq);
            return new ResponseEntity(new ResponseMsg("Milk Details Successfully added", ""),
                    HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage() ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update milk_details
    @PutMapping("customers/{customer_id}/milk/{dist_id}")
    public ResponseEntity<?> updateDistByDistID(@PathVariable String customer_id, @PathVariable String dist_id, @Valid @RequestBody DistReq distReq) {

        try {
            distReqService.updateDistByID(customer_id, dist_id, distReq);
            return new ResponseEntity(new ResponseMsg("Milk Details Successfully updated", ""),
                    HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage() ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //List milk_details
    @GetMapping("/milk")
    public List<DistReq> getAllDist() {
        return this.distReqService.getAllDist();
    }

    //Get milk details by customer_id
    @GetMapping("/milk/customer/{customer_id}")
    public List<DistReq> findDistByCustomerID(@PathVariable String customer_id) {
        return this.distReqService.findMilkDetailsByCustomerID(customer_id);
    }


}