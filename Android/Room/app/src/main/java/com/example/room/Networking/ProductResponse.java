package com.example.room.Networking;

import com.example.room.Model.Products;

import java.util.List;
import java.util.Vector;

public class ProductResponse {

    List<Products> products;

    public ProductResponse(List<Products> products) {
        System.out.println("ProductResponse -> Constructor");
        this.products = products;
    }

    public ProductResponse() {
    }

    public void setProducts(List<Products> products) {
        System.out.println("ProductResponse -> setProducts");
        this.products = products;
    }

    public List<Products> getProducts() {
        System.out.println("ProductResponse -> getProducts");
        return products;
    }
}
