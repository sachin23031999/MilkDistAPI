package com.springrest.MilkDistAPI.servicesInterface;

import com.springrest.MilkDistAPI.utils.CowBuffalo;
import com.springrest.MilkDistAPI.utils.TotalEarningCustomer;

import java.util.List;


public interface ReportService {


    List<CowBuffalo> reportCowVsBuffalo(String start_date, String end_date);

    List<TotalEarningCustomer> reportTotalEarning(String start_date, String end_date);
}