package com.example.yy.gridlayout;

public class FoodItem {
    String name;
    int price;
    int resId;
    public FoodItem(String name, int price, int resId) {
        this.name = name;
        this.price = price;
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

