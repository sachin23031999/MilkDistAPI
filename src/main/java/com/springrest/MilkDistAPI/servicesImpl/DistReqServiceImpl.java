package com.springrest.MilkDistAPI.servicesImpl;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DailyDistDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.Customer;
import com.springrest.MilkDistAPI.entities.DailyDist;
import com.springrest.MilkDistAPI.entities.DistReq;
import com.springrest.MilkDistAPI.enums.DeliveryTime;
import com.springrest.MilkDistAPI.enums.TimePeriod;
import com.springrest.MilkDistAPI.servicesInterface.DistReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistReqServiceImpl implements DistReqService {

    @Autowired
    private DistReqDao distReqDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private DailyDistDao dailyDistDao;

    public DistReqServiceImpl() {

    }

    @Override
    public List<DistReq> getAllDist() {
        return distReqDao.findAll();
    }

    @Override
    public DistReq updateDistByID(String customerID, String distID, DistReq dist) {

        //List<DistReq> distFilteredByCustomerID = distReqDao.getAlldistByCustomerID(Long.parseLong(customerID));
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

        DailyDist dailyDist = new DailyDist();
        dailyDist.setCustomer(customer);
        dailyDist.setMilk_type(distReq.getType_of_milk());

        if (distReq.getTime_of_delivery().equals(DeliveryTime.both.toString())) {

            dailyDist.setTime_period(TimePeriod.morning.toString());
            dailyDistDao.save(dailyDist);

            DailyDist dailyDist2 = new DailyDist();
            dailyDist2.setCustomer(customer);
            dailyDist2.setTime_period(TimePeriod.evening.toString());
            dailyDist2.setMilk_type(distReq.getType_of_milk());
            dailyDistDao.save(dailyDist2);

        } else if (distReq.getTime_of_delivery().equals(DeliveryTime.morning.toString())) {
            dailyDist.setTime_period(TimePeriod.morning.toString());
            dailyDistDao.save(dailyDist);

        } else if (distReq.getTime_of_delivery().equals(DeliveryTime.evening.toString())) {
            dailyDist.setTime_period(TimePeriod.evening.toString());
            dailyDistDao.save(dailyDist);
        }


        return distReq;
    }

    @Override
    public List<DistReq> findMilkDetailsByCustomerID(String customer_id) {
        return distReqDao.getMilkDetailsByCustomerID(customer_id);
    }

    @Override
    public DistReq addDist(DistReq dist) {
        distReqDao.save(dist);
        return dist;
    }

}