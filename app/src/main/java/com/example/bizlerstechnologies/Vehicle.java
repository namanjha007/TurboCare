package com.example.bizlerstechnologies;

import android.graphics.Bitmap;

public class Vehicle {

    private String number;
    private String make;
    private String model;
    private String variant;

    public Vehicle(String number, String make, String model, String variant, String image) {
        this.number = number;
        this.make = make;
        this.model = model;
        this.variant = variant;
        this.image = image;
    }

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

}
