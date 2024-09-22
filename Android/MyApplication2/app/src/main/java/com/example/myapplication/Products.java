package com.example.myapplication;

public class Products {
    private String title;
    private double price;
    private String brand;
    private String description;
    private double rating;
    private String thumbnail;

    public Products(String title, int price, String brand, String description, double ratings, String imgURL) {
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.rating = ratings;
        this.thumbnail = imgURL;
    }

    public Products(){

    }

    /* Setters */
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRatings(double rating) {
        this.rating = rating;
    }
    public void setImgURL(String thumbnail) { this.thumbnail = thumbnail;}

    /* Getters */
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public String getBrand() {
        return brand;
    }
    public String getDescription() {
        return description;
    }
    public double getRatings() {
        return rating;
    }
    public String getImgURL(){ return thumbnail; }
}
