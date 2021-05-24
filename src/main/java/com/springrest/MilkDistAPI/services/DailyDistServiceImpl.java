package com.springrest.MilkDistAPI.services;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DailyDistDao;
import com.springrest.MilkDistAPI.entities.Customer;
import com.springrest.MilkDistAPI.entities.DailyDist;
import com.sun.jdi.FloatValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DailyDistServiceImpl implements DailyDistService {

    @Autowired
    DailyDistDao dailyDistDao;

    @Autowired
    CustomerDao customerDao;

    @Override
    public void updateDateAndQuantity(String customer_id, String dailyDist_id, DailyDist dailyD) {
        Customer customer = customerDao.getOne(Long.parseLong(customer_id));
        DailyDist dailyDist = dailyDistDao.getOne(Long.parseLong(dailyDist_id));
        dailyDist.setCustomer(customer);
        dailyDist.setDelivered_at(dailyD.getDelivered_at());
        dailyDist.setQuantity(dailyD.getQuantity());

        dailyDistDao.save(dailyDist);
    }

    @Override
    public void addDist(DailyDist dist) {
        dailyDistDao.save(dist);
    }

    @Override
    public void updateDist(DailyDist dist) {
        dailyDistDao.save(dist);
    }

    @Override
    public List<DailyDist> getAllDist() {
        return dailyDistDao.findAll();
    }

    @Override
    public DailyDist getOneDist(Long id) {
        return dailyDistDao.getOne(id);
    }
}
