package com.vovroslyakov.chappie;

import java.util.ArrayList;
import java.util.List;

public class Ekart {

    private String model;

    public Ekart(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }
}
