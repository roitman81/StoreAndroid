package com.example.roitm.retrofit2.my_interface;



import com.example.roitm.retrofit2.model.Category;



import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCategoryDataService
{
    @GET("/MyPortfolio2/rest/category")
    Call<ArrayList<Category>> getCategoryData();
}