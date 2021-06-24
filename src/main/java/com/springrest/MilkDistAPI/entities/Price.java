package com.springrest.MilkDistAPI.entities;

import com.springrest.MilkDistAPI.enums.MilkType;
import com.springrest.MilkDistAPI.exceptionHandler.enumException.Enum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue
    private Long id;

    private String milk_type;
    private Float price;

    public Price(String milk_type, Float price) {
        this.milk_type = milk_type;
        this.price = price;
    }

    public Price() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMilk_type() {
        return milk_type;
    }

    public void setMilk_type(String milk_type) {
        this.milk_type = milk_type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
