package com.example.jacksonskin.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @Expose
    @SerializedName("id")
    private long id;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("amount")
    private int amount;

    @Expose
    @SerializedName("desc")
    private String desc;

    @Expose
    @SerializedName("rating")
    private double rating;
    @Expose
    @SerializedName("price")
    private double price;

    @Expose
    @SerializedName("is_on_offer")
    private boolean isOffer;

    private int image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isOffer() {
        return isOffer;
    }

    public void setOffer(boolean offer) {
        isOffer = offer;
    }
}
