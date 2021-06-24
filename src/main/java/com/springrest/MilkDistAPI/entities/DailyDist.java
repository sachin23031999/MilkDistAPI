package com.springrest.MilkDistAPI.entities;

import com.springrest.MilkDistAPI.exceptionHandler.dateConstraint.CustomDate;

import javax.persistence.*;

@Entity
@Table(name = "daily_distribution")
public class DailyDist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    //@Enum(clazz = TimePeriod.class, message = "Enter correct time period")
    private String time_period;

    private float quantity;

    @CustomDate(message = "Invalid date format. Use yyyy-MM-dd")
    private String delivered_at;

    private String milk_type;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean is_delivered;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public DailyDist(String time_period, float quantity, String delivered_at, String milk_type, Boolean is_delivered) {
        this.time_period = time_period;
        this.quantity = quantity;
        this.delivered_at = delivered_at;
        this.milk_type = milk_type;
        this.is_delivered = is_delivered;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getIs_delivered() {
        return is_delivered;
    }

    public void setIs_delivered(Boolean is_delivered) {
        this.is_delivered = is_delivered;
    }

    public DailyDist() {
    }

    public String getMilk_type() {
        return milk_type;
    }

    public void setMilk_type(String milk_type) {
        this.milk_type = milk_type;
    }

    public String getTime_period() {
        return time_period;
    }

    public void setTime_period(String time_period) {
        this.time_period = time_period;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getDelivered_at() {
        return delivered_at;
    }

    public void setDelivered_at(String delivered_at) {
        this.delivered_at = delivered_at;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}