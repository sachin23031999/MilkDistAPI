package com.springrest.MilkDistAPI.servicesImpl;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DailyDistDao;
import com.springrest.MilkDistAPI.entities.Customer;
import com.springrest.MilkDistAPI.entities.DailyDist;
import com.springrest.MilkDistAPI.servicesInterface.DailyDistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void updateDist(long id, DailyDist dist) {
        dist.setId(id);
        DailyDist dist1 = dailyDistDao.getOne(id);
        dist.setCustomer(dist1.getCustomer());

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

    @Override
    public void updateQuantity(long customer_id, long dailyDist_id, DailyDist dailyD) {

        Customer customer = customerDao.getOne(customer_id);
        DailyDist dailyDist = dailyDistDao.getOne(dailyDist_id);
        dailyDist.setCustomer(customer);
        dailyDist.setQuantity(dailyD.getQuantity());

        dailyDistDao.save(dailyDist);
    }
}