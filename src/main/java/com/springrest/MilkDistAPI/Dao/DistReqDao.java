package com.springrest.MilkDistAPI.Dao;

import com.springrest.MilkDistAPI.entities.DistReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistReqDao extends JpaRepository<DistReq, Long> {

//    @Query(value = "SELECT * FROM distribution_required WHERE type_of_milk = 'cow' ORDER BY customer_id", nativeQuery = true)
//    List<DistReq> listDistReqByCow();
//
//    @Query(value = "SELECT * FROM distribution_required WHERE type_of_milk = 'buffalo' ORDER BY customer_id", nativeQuery = true)
//    List<DistReq> listDistReqByBuffalo();

//     @Query(value = "SELECT price, type_of_milk, delivered_at, quantity, time_period " +
//             "FROM distribution_required, daily_distribution " +
//             "WHERE distribution_required.customer_id = daily_distribution.customer_id" +
//             " AND type_of_milk = 'cow' " +
//             "AND delivered_at BETWEEN :start_date AND :end_date", nativeQuery = true)
//     List<ReportQuery> listResultsForCow(@Param("start_date") String start_date, @Param("end_date") String end_date);
//
//    @Query(value = "SELECT price, type_of_milk, delivered_at, quantity, time_period " +
//            "FROM distribution_required, daily_distribution " +
//            "WHERE distribution_required.customer_id = daily_distribution.customer_id" +
//            " AND type_of_milk = 'buffalo' " +
//            "AND delivered_at BETWEEN :start_date AND :end_date", nativeQuery = true)
//    List<ReportQuery> listResultsForBuffalo(@Param("start_date") String start_date, @Param("end_date") String end_date);

    //List<ReportQuery> listResultsForBuffalo(String start_date,String end_date);

    @Query(value = "select SUM(quantity) from daily_distribution, distribution_required" +
            " WHERE distribution_required.customer_id = daily_distribution.customer_id" +
            " AND (delivered_at BETWEEN :start_date AND :end_date)" +
            " AND type_of_milk = :type"
            , nativeQuery = true)
    Float totalQuantityBetweenDate(@Param("start_date") String start_date,
                                   @Param("end_date") String end_date,
                                   @Param("type") String type);

    @Query(value = "select SUM(price * quantity) from daily_distribution, distribution_required" +
            " WHERE distribution_required.customer_id = daily_distribution.customer_id" +
            " AND (delivered_at BETWEEN :start_date AND :end_date)" +
            " AND type_of_milk = :type"
            , nativeQuery = true)
    Float totalPriceBetweenDate(@Param("start_date") String start_date,
                                @Param("end_date") String end_date,
                                @Param("type") String type);

    @Query(value = "select SUM(price * quantity) from daily_distribution, distribution_required" +
            " WHERE distribution_required.customer_id = daily_distribution.customer_id" +
            " AND (delivered_at BETWEEN :start_date AND :end_date)" +
            " AND daily_distribution.customer_id = :customer_id" +
            " AND type_of_milk = :type"
            , nativeQuery = true)
    Float totalEarningPerCustomer(@Param("start_date") String start_date,
                                  @Param("end_date") String end_date,
                                  @Param("customer_id") String customer_id,
                                  @Param("type") String type);

    @Query(value = "select SUM(quantity) from daily_distribution, distribution_required" +
            " WHERE distribution_required.customer_id = daily_distribution.customer_id" +
            " AND (delivered_at BETWEEN :start_date AND :end_date)" +
            " AND daily_distribution.customer_id = :customer_id" +
            " AND type_of_milk = :type"
            , nativeQuery = true)
    Float totalQuantityPerCustomer(@Param("start_date") String start_date,
                                   @Param("end_date") String end_date,
                                   @Param("customer_id") String customer_id,
                                   @Param("type") String type);
}
