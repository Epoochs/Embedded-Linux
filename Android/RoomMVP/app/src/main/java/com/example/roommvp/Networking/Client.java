package com.example.roommvp.Networking;

import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = "https://dummyjson.com/";
    private Pro productInterface;
    private static Client client = null;
    Retrofit retrofit;

    public Client() {
        System.out.println("Client Created");
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
        productInterface = retrofit.create(Pro.class);
    }

    public static Client getInstance() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public void makeNetworkCallback(NetworkCallback networkCallback) {
        Call<ProductResponse> call = productInterface.getProduct();
        System.out.println("CallBack");
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductResponse> call, @NonNull Response<ProductResponse> response) {
                System.out.println("Response");
                networkCallback.onSuccessResult(response.body().getProducts());
                Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
            }
        });

    }
}
