package com.example.jacksonskin.data;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String type = "CLIENTE";
    private String sex;
    private String pass;
    private Float review;
    private byte[] thumb;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Float getReview() {
        return review;
    }

    public void setReview(Float review) {
        this.review = review;
    }

    public byte[] getThumb() {
        return thumb;
    }

    public void setThumb(byte[] thumb) {
        this.thumb = thumb;
    }
}
