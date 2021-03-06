package com.springrest.MilkDistAPI.utils;

import java.util.List;

public class TotalEarningCustomer {

    private String customer_id;
    private String total_earning;
    private List<CowBuffalo> details;

    public TotalEarningCustomer(String customer_id, String total_earning, List<CowBuffalo> list) {
        this.customer_id = customer_id;
        this.total_earning = total_earning;
        this.details = list;
    }

    public TotalEarningCustomer() {
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getTotal_earning() {
        return total_earning;
    }

    public void setTotal_earning(String total_earning) {
        this.total_earning = total_earning;
    }

    public List<CowBuffalo> getDetails() {
        return details;
    }

    public void setDetails(List<CowBuffalo> details) {
        this.details = details;
    }
}