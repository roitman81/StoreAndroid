package com.example.roitm.retrofit2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Suppl {

    @SerializedName("city")
    @Expose
    private String city;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("phoneNum")
    private String phoneNum;

    public Suppl(String city, String name, String phoneNum) {
        this.city = city;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public Suppl(){}

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}

