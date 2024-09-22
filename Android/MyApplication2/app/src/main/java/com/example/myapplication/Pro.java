package com.example.myapplication;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Pro {
    @GET("products")
    Call<ProductResponse> getProduct();
}
