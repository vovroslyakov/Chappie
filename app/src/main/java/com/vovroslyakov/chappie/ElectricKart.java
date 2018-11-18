package com.vovroslyakov.chappie;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ElectricKart {

    private String modelKart;
    private int price;

    public String getModelKart() {
        return modelKart;
    }

    public void setModelKart(String modelKart) {
        this.modelKart = modelKart;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ElectricKart(String modelKart, int price) {
        this.modelKart = modelKart;
        this.price = price;


    }
}
