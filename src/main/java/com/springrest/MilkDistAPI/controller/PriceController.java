package com.springrest.MilkDistAPI.controller;

import com.springrest.MilkDistAPI.entities.Price;
import com.springrest.MilkDistAPI.responses.ResponseMsg;
import com.springrest.MilkDistAPI.servicesInterface.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PriceController {

    @Autowired
    private PriceService priceService;

    //Add Price
    @PostMapping("/price")
    public ResponseEntity<String> addPrice(@Valid @RequestBody Price price) {
        try {
            priceService.addPrice(price);
            //return this.customerService.getAllCustomers();
            ResponseMsg responseMsg = new ResponseMsg("Price successfully added", "");
            return new ResponseEntity(responseMsg, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update Price
    @PutMapping("/price/{id}")
    public ResponseEntity<String> updatePrice(@PathVariable String id, @Valid @RequestBody Price price) {
        try {
            priceService.updatePrice(id, price);
            ResponseMsg responseMsg = new ResponseMsg("Price successfully updated", "");
            return new ResponseEntity(responseMsg, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity(new ResponseMsg("Something went wrong", e.getRootCause().getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get Price
    @GetMapping("/price")
    public ResponseEntity<?> getAllPrice() {
        return new ResponseEntity(this.priceService.getAllPrice(), HttpStatus.OK);
    }
}
