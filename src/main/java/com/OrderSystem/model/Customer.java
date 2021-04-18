package com.OrderSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    private int customerID;

    private String customer_name;
    private String customer_surname;
    private String customer_phone;
    private String province;
    private String postal_id;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_surname() {
        return customer_surname;
    }

    public void setCustomer_surname(String customer_surname) {
        this.customer_surname = customer_surname;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostal_id() {
        return postal_id;
    }

    public void setPostal_id(String postal_id) {
        this.postal_id = postal_id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customer_name='" + customer_name + '\'' +
                ", customer_surname='" + customer_surname + '\'' +
                ", customer_phone='" + customer_phone + '\'' +
                ", province='" + province + '\'' +
                ", postal_id='" + postal_id + '\'' +
                '}';
    }
}

