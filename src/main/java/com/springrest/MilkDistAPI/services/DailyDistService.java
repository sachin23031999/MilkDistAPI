package com.springrest.MilkDistAPI.services;

import com.springrest.MilkDistAPI.entities.DailyDist;

import java.util.List;

public interface DailyDistService {

    public void addDist(DailyDist dist);

    public void updateDist(DailyDist dist);

    public List<DailyDist> getAllDist();

    public DailyDist getOneDist(Long id);
}
