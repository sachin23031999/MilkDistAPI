package com.springrest.MilkDistAPI.controller;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.servicesInterface.CustomerService;
import com.springrest.MilkDistAPI.servicesInterface.DailyDistService;
import com.springrest.MilkDistAPI.servicesInterface.DistReqService;
import com.springrest.MilkDistAPI.servicesInterface.ReportService;
import com.springrest.MilkDistAPI.utils.CowBuffalo;
import com.springrest.MilkDistAPI.utils.TotalEarningCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private DistReqDao distReqDao;

    @Autowired
    private DistReqService distReqService;

    @Autowired
    private DailyDistService dailyDistService;

    @Autowired
    private ReportService reportService;

    //Report Cow vs Buffalo
    @GetMapping("/reports/cow-vs-buffalo/{start_date}/{end_date}")
    public List<CowBuffalo> reportCowBuffalo(@PathVariable String start_date, @PathVariable String end_date) {
        return reportService.reportCowVsBuffalo(start_date, end_date);
    }

    //Total Earning
    @GetMapping("/reports/total-earning/{start_date}/{end_date}")
    public List<TotalEarningCustomer> totalEarning(@PathVariable String start_date, @PathVariable String end_date) {
        return reportService.reportTotalEarning(start_date, end_date);
    }
}