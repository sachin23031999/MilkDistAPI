package com.springrest.MilkDistAPI.services;

import com.springrest.MilkDistAPI.entities.Customer;
import com.springrest.MilkDistAPI.entities.DistReq;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistReqService {

    List<DistReq> getAllDist();
    DistReq addDist(DistReq dist);

    Customer findByCustomerID(String customerID);

    DistReq updateDistByID(String customerID, String distID, DistReq dist);

    //List<DistReq> getAllDistbyCustID(String customerID);

    DistReq addDistByCustomerID(String customerID, DistReq distReq);

}
