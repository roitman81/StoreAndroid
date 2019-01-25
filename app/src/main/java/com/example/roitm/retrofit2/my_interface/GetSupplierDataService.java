package com.example.roitm.retrofit2.my_interface;

import com.example.roitm.retrofit2.model.Category;
import com.example.roitm.retrofit2.model.Suppl;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GetSupplierDataService {
    @GET("categories/")
    Call<ArrayList<Suppl>> getSupplierData();

    @POST("add/")
    Call<Suppl> addSuppl(@Body Suppl c);

    @PUT("update/{id}")
    Call<Suppl> updateSuppl(@Path("id") int id, @Body Suppl suppl);

    @DELETE("delete/{id}")
    Call<Suppl> deleteSuppl(@Path("id") int id);

}
