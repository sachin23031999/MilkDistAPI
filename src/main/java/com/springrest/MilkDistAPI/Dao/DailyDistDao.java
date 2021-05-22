package com.springrest.MilkDistAPI.Dao;

import com.springrest.MilkDistAPI.entities.DailyDist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DailyDistDao extends JpaRepository<DailyDist, Long> {

}
