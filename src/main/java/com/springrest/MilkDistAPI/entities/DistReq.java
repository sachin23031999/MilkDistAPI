package com.springrest.MilkDistAPI.entities;

import com.springrest.MilkDistAPI.enums.DeliveryTime;
import com.springrest.MilkDistAPI.enums.MilkType;
import com.springrest.MilkDistAPI.enums.Unit;

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MilkType type_of_milk;

    @Column(columnDefinition = "FLOAT", nullable = false)
    private float price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit; // Litre/kg

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryTime time_of_delivery;

    public DistReq(Customer customer, MilkType type_of_milk, float price, Unit unit, DeliveryTime time_of_delivery) {
        this.customer = customer;
        this.type_of_milk = type_of_milk;
        this.price = price;
        this.unit = unit;
        this.time_of_delivery = time_of_delivery;
    }

    public long getId() {
        return id;
    }

    public MilkType getType_of_milk() {
        return type_of_milk;
    }

    public Unit getUnit() {
        return unit;
    }

    public DeliveryTime getTime_of_delivery() {
        return time_of_delivery;
    }

    public void setType_of_milk(MilkType type_of_milk) {
        this.type_of_milk = type_of_milk;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setTime_of_delivery(DeliveryTime time_of_delivery) {
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
