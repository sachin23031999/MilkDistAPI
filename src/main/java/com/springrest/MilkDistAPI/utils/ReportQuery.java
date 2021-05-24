package com.springrest.MilkDistAPI.utils;

import com.springrest.MilkDistAPI.enums.MilkType;
import com.springrest.MilkDistAPI.enums.TimePeriod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ReportQuery {


    private float price;
    private MilkType type_of_milk;
    private String delivered_at;
    private float quantity;
    private TimePeriod time_period;

    public ReportQuery(float price, MilkType milkType, String delivered_at, float quantity, TimePeriod timePeriod) {
        this.price = price;
        this.type_of_milk = milkType;
        this.delivered_at = delivered_at;
        this.quantity = quantity;
        this.time_period = timePeriod;
    }

    public ReportQuery() { }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public MilkType getType_of_milk() {
        return type_of_milk;
    }

    public void setType_of_milk(MilkType type_of_milk) {
        this.type_of_milk = type_of_milk;
    }

    public String getDelivered_at() {
        return delivered_at;
    }

    public void setDelivered_at(String delivered_at) {
        this.delivered_at = delivered_at;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public TimePeriod getTime_period() {
        return time_period;
    }

    public void setTime_period(TimePeriod time_period) {
        this.time_period = time_period;
    }
}
