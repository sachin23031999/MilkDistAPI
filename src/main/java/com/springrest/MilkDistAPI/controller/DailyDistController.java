package com.springrest.MilkDistAPI.controller;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.DailyDist;
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
public class DailyDistController {

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

    //List daily_distribution
    @GetMapping("/daily")
    public List<DailyDist> getDailyDistribution() {
        return dailyDistService.getAllDist();
    }

    //Patch Delivery Date and Quantity
    @PatchMapping("/customers/{customer_id}/daily/{dailyDist_id}")
    public ResponseEntity<?> updateDateAndQuantity
    (@PathVariable String customer_id, @PathVariable String dailyDist_id, @Valid @RequestBody DailyDist dailyDist) {

        try {
            dailyDistService.updateDateAndQuantity(customer_id, dailyDist_id, dailyDist);
            return new ResponseEntity(new ResponseMsg("Date and Quantity successfully updated", ""),
                    HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage() ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Patch Quantity
    @PatchMapping("/customers/{customer_id}/daily/{dailyDist_id}/quantity")
    public ResponseEntity<?> patchQuantity
    (@PathVariable String customer_id, @PathVariable String dailyDist_id, @RequestBody DailyDist dailyDist) {

        try {
            dailyDistService.updateQuantity(Long.parseLong(customer_id), Long.parseLong(dailyDist_id), dailyDist);
            return new ResponseEntity(new ResponseMsg("Quantity successfully updated", ""),
                    HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage() ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    //Update daily_distribution
//    @GetMapping("/daily/{daily_id}")
//    public ResponseEntity<?> updateDist
//    (@PathVariable String daily_id, @PathVariable @RequestBody DailyDist dailyDist) {
//
//        try {
//            dailyDistService.updateDist(Long.parseLong(daily_id), dailyDist);
//            return new ResponseEntity(new ResponseMsg("Data Successfully Updated", ""),
//                    HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getMessage()),
//                    HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}