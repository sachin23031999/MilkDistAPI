package com.springrest.MilkDistAPI.servicesInterface;

import com.springrest.MilkDistAPI.entities.DailyDist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DailyDistService {

    void addDist(DailyDist dist);

    void updateDateAndQuantity(String customer_id, String dailyDist_id, DailyDist dailyDist);

    void updateDist(long id, DailyDist dist);

    List<DailyDist> getAllDist();

    void setDelivery(long id);

    void setUndelivered(long id);

    List<DailyDist> getDistByCustomerID(String customer_id);

    DailyDist getOneDist(Long id);

    void updateQuantity(long customer_id, long dailyDist_id, DailyDist dailyDist);
}