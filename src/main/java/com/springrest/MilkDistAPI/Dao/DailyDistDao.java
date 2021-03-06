package com.springrest.MilkDistAPI.Dao;

import com.springrest.MilkDistAPI.entities.Customer;
import com.springrest.MilkDistAPI.entities.DailyDist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface DailyDistDao extends JpaRepository<DailyDist, Long> {

    @Query(value = "SELECT * FROM daily_distribution WHERE customer_id = :customer_id", nativeQuery = true)
    List<DailyDist> getDistByCusID(@PathVariable String customer_id);
}