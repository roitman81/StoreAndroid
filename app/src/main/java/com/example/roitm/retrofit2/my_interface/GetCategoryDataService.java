package com.example.roitm.retrofit2.my_interface;



import com.example.roitm.retrofit2.model.Category;



import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface GetCategoryDataService {
    @GET("MyPortfolio2/rest/category")
    Call<ArrayList<Category>> getCategoryData();

    @PUT("MyPortfolio2/rest/category")
    Call<Category> UpdateData(@Body Category category);
}