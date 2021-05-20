package com.springrest.MilkDistAPI.Dao;

import com.springrest.MilkDistAPI.entities.DistReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistReqDao extends JpaRepository<DistReq, Long> {

   @Query(value = "select * from distribution_required where customer_id = :cID", nativeQuery = true)
    List<DistReq> getAlldistByCustomerID(@Param("cID") long customerID);

   @Query(value = "select SUM(price) from distribution_required", nativeQuery = true)
    long totalPrice();

}
