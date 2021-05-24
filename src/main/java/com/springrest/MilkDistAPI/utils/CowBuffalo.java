package com.springrest.MilkDistAPI.utils;

import com.springrest.MilkDistAPI.enums.MilkType;
import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CowBuffalo {

    private MilkType type_of_milk;
    private String total_quantity;
    private String total_earning;

    public CowBuffalo(MilkType type_of_milk, String total_quantity, String total_earning) {
        this.type_of_milk = type_of_milk;
        this.total_quantity = total_quantity;
        this.total_earning = total_earning;
    }

    public CowBuffalo() { }

    public MilkType getType_of_milk() {
        return type_of_milk;
    }

    public void setType_of_milk(MilkType type_of_milk) {
        this.type_of_milk = type_of_milk;
    }

    public String getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(String total_quantity) {
        this.total_quantity = total_quantity;
    }

    public String getTotal_earning() {
        return total_earning;
    }

    public void setTotal_earning(String total_earning) {
        this.total_earning = total_earning;
    }
}
