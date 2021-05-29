package com.springrest.MilkDistAPI.entities;

import com.springrest.MilkDistAPI.enums.DeliveryTime;
import com.springrest.MilkDistAPI.enums.MilkType;
import com.springrest.MilkDistAPI.enums.Unit;
import com.springrest.MilkDistAPI.exceptionHandler.enumException.Enum;

import javax.persistence.*;

@Entity
@Table(name = "distribution_required")
public class DistReq {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enum(clazz = MilkType.class, message = "Error, use: (cow, buffalo)")
   // @Enumerated(EnumType.STRING)
    private String type_of_milk;

    @Column(columnDefinition = "FLOAT", nullable = false)
    private float price;

    @Enum(clazz = Unit.class, message = "Error, use: (litre,kilogram)")
   // @Enumerated(EnumType.STRING)
    private String unit; // Litre/kg

    //@Enumerated(EnumType.STRING)
    @Enum(clazz = DeliveryTime.class, message = "Error, use: (morning, evening, both)")
    private String time_of_delivery;

    public DistReq(Customer customer, String type_of_milk, float price, String unit, String time_of_delivery) {
        this.customer = customer;
        this.type_of_milk = type_of_milk;
        this.price = price;
        this.unit = unit;
        this.time_of_delivery = time_of_delivery;
    }

    public long getId() {
        return id;
    }

    public String getType_of_milk() {
        return type_of_milk;
    }

    public String getUnit() {
        return unit;
    }

    public String getTime_of_delivery() {
        return time_of_delivery;
    }

    public void setType_of_milk(String type_of_milk) {
        this.type_of_milk = type_of_milk;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setTime_of_delivery(String time_of_delivery) {
        this.time_of_delivery = time_of_delivery;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DistReq() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "MilkDist [type_of_milk=" + type_of_milk + ", price=" + price + ", unit=" + unit + ", time_of_delivery="
                + time_of_delivery + "]";
    }


}