package com.springrest.MilkDistAPI.services;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.Customer;
import com.springrest.MilkDistAPI.entities.DistReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistReqServiceImpl implements DistReqService{

    @Autowired
    private DistReqDao distReqDao;
    @Autowired
    private CustomerDao customerDao;


    public DistReqServiceImpl() {

    }

    @Override
    public List<DistReq> getAllDist() {
        return distReqDao.findAll();
    }

    @Override
    public DistReq updateDistByID(String customerID, String distID, DistReq dist) {

        List<DistReq> distFilteredByCustomerID = distReqDao.getAlldistByCustomerID(Long.parseLong(customerID));
        Customer customer = customerDao.getOne(Long.parseLong(customerID));
        dist.setCustomer(customer);
        dist.setId(Long.parseLong(distID));
        distReqDao.save(dist);
        return dist;
    }

//    @Override
//    public List<DistReq> getAllDistbyCustID(String customerID) {
//        return distReqDao.getAlldistByCustomerID(Long.parseLong(customerID));
//    }
    @Override
    public DistReq addDistByCustomerID(String customerID, DistReq distReq) {
            Customer customer = customerDao.getOne(Long.parseLong(customerID));
            distReq.setCustomer(customer);
            distReqDao.save(distReq);

            return distReq;
    }

    @Override
    public Customer findByCustomerID(String customerID) {
        return null;
    }

    @Override
    public DistReq addDist(DistReq dist) {
        distReqDao.save(dist);
        return dist;
    }

}
