package com.example.myapplication;

import java.util.List;

public class ProductResponse {

    List<Products> products;

    public ProductResponse(List<Products> products) {
        this.products = products;
    }
    public ProductResponse(){
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Products> getProducts() {
        return products;
    }
}
