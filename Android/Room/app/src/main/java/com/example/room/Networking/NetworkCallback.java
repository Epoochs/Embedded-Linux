package com.example.room.Networking;

import com.example.room.Model.Products;

import java.util.List;
import java.util.Vector;

public interface NetworkCallback {
    public void onSuccessResult(List<Products> movies);

    public void onFalureResult(String str);
}
