package com.vovroslyakov.chappie;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class ElectricKart {

    private String model;
    private int price;
    private String imgUrl;

    public String getModelKart() {
        return model;
    }

    public void setModelKart(String modelKart) {
        this.model = modelKart;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imgUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imgUrl = imageUrl;
    }

    public ElectricKart(String modelKart, int price, String imgUrl) {
        this.model = modelKart;
        this.price = price;
        this.imgUrl = imgUrl;
    }
}
