package com.example.roitm.retrofit2.my_interface;



import com.example.roitm.retrofit2.model.Category;



import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GetCategoryDataService {
    @GET("/categories")
    Call<ArrayList<Category>> getCategoryData();

    @POST("add/")
    Call<Category> addCategory(@Body Category c);

    @PUT("update")
    Call<Category> updateCategory( @Body Category category);

    @DELETE("categories/delete/{id}")
    Call<Category> deleteCategory(@Path("id") int id);

}