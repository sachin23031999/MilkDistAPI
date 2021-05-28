package com.springrest.MilkDistAPI.services;

import com.springrest.MilkDistAPI.entities.DailyDist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DailyDistService {

    public void addDist(DailyDist dist);

    public void updateDist(DailyDist dist);

    public void updateDateAndQuantity(String customer_id, String dailyDist_id, DailyDist dailyDist);

    public List<DailyDist> getAllDist();

    public DailyDist getOneDist(Long id);
}
