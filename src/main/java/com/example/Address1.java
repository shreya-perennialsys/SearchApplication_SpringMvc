package com.example;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Address1 {
    private String street;
    private String city;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long U_id;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address1() {
    }

    @Override
    public String toString() {
        return "Address1{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }





}
