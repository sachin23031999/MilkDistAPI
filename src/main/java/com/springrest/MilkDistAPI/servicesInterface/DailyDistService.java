package com.springrest.MilkDistAPI.servicesInterface;

import com.springrest.MilkDistAPI.entities.DailyDist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DailyDistService {

    public void addDist(DailyDist dist);

    public void updateDateAndQuantity(String customer_id, String dailyDist_id, DailyDist dailyDist);

    void updateDist(long id, DailyDist dist);

    public List<DailyDist> getAllDist();

    public DailyDist getOneDist(Long id);

    void updateQuantity(long customer_id, long dailyDist_id, DailyDist dailyDist);
}