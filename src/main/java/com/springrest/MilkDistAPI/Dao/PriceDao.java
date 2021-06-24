package com.springrest.MilkDistAPI.Dao;

import com.springrest.MilkDistAPI.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceDao extends JpaRepository<Price, Long> {

}
