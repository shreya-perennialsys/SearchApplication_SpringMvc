package com.example;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Register {
    private String pname;
    @Id
    private long id;
    private Date date;
    //private List<String> courses;
    private String gender;
    private String type;

    @OneToOne(
            orphanRemoval = true,cascade = CascadeType.ALL)
    private Address1 address;

    public Register() {

    }

    public Address1 getAddress() {
       return address;
    }

    public void setAddress(Address1 address) {
        this.address = address;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public List<String> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<String> courses) {
//        this.courses = courses;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Register{" +
                "pname='" + pname + '\'' +
                ", id=" + id +
                ", date=" + date +
//                ", courses=" + courses +
               ", gender='" + gender + '\'' +
                ", type='" + type + '\'' +
                ", address=" + address +
                '}';
    }

    public Register(String pname, long id, Date date, String gender, String type, Address1 address) {
        this.pname = pname;
        this.id = id;
        this.date = date;
        this.gender = gender;
        this.type = type;
        this.address = address;
    }
}
