package com.example.recview;

public class Products {
    private String title;
    private int price;
    private String brand;
    private String description;
    private double ratings;
    private String imgURL;


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
    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
    public void setImgURL(String url) { this.imgURL = url;}

    /* Getters */
    public String getTitle() {
        return title;
    }
    public int getPrice() {
        return price;
    }
    public String getBrand() {
        return brand;
    }
    public String getDescription() {
        return description;
    }
    public double getRatings() {
        return ratings;
    }
    public String getImgURL(){ return imgURL; }
}
