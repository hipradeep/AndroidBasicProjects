package com.hipradeep.learnandroid.androidbasics.models;

public class UserModel {
    int image;
    String name;
    String mobile;
    String address;


    public UserModel() {
    }

    public UserModel(int image, String name, String mobile, String address) {
        this.image = image;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
