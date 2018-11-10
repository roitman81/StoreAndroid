package com.example.roitm.retrofit2.model;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("category_ID")
    private String id;
    @SerializedName("name_category")
    private String name;


    public Category(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public Category() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}


