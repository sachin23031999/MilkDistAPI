package com.springrest.MilkDistAPI.entities;

import com.springrest.MilkDistAPI.enums.TimePeriod;
import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "daily_distribution")
public class DailyDist {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private TimePeriod time_period;

    private float quantity;

    private String delivered_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public DailyDist(TimePeriod time_period, float quantity, String delivered_at) {
        this.time_period = time_period;
        this.quantity = quantity;
        this.delivered_at = delivered_at;
    }
    public DailyDist() { }

    public TimePeriod getTime_period() {
        return time_period;
    }

    public void setTime_period(TimePeriod time_period) {
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
