package com.springrest.MilkDistAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springrest.MilkDistAPI.enums.CustomerType;
import com.springrest.MilkDistAPI.exceptionHandler.enumException.Enum;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {

   // @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(unique = true, length = 32, nullable = false)
    private String user_id;

    @Size(min = 2, message = "Enter valid name")
    @Column(length = 100, nullable = false)
    private String name;

    @Size(min = 10, max = 10, message = "Length of mobile should be 10")
    //@Column(columnDefinition = "CHAR(10)", nullable = false)
    private String mobile;

    @Size(min = 2, message = "Enter valid address")
    private String address;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean is_archived;

    @Size(min = 6, max = 6, message = "Pincode length should be 6")
    @Column(columnDefinition = "CHAR(6)", nullable = false)
    private String pincode;

    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
    //private DistReq distReq;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "dist_id")
//	private DistReq distReq;

    //@Enumerated(EnumType.STRING)
    @Enum(clazz = CustomerType.class, message = "Use (individual, professional)")
    private String type_of_customer; // Individual/Professional

    public Customer(String user_id, String name, String mobile, String address, String pincode, String type_of_customer) {
        this.user_id = user_id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.pincode = pincode;
        this.type_of_customer = type_of_customer;
    }

    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getType_of_customer() {
        return type_of_customer;
    }

    public void setType_of_customer(String type_of_customer) {
        this.type_of_customer = type_of_customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }


    public void setIs_archived(boolean is_archived) {
        this.is_archived = is_archived;
    }

    @Override
    public String toString() {
        return "Customer [user_id=" + user_id + ", name=" + name + ", mobile=" + mobile + ", address=" + address
                + ", pincode=" + pincode + ", type_of_customer=" + type_of_customer + "]";
    }
}