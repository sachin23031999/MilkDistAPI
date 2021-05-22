package com.springrest.MilkDistAPI.services;

import com.springrest.MilkDistAPI.Dao.DailyDistDao;
import com.springrest.MilkDistAPI.entities.DailyDist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyDistServiceImpl implements DailyDistService {

    @Autowired
    DailyDistDao dailyDistDao;

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
